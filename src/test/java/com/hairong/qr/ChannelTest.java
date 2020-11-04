package com.hairong.qr;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.hairong.channel.qr.BaseTest;
import com.hairong.channel.qr.Request;
import com.hairong.channel.qr.Response;
import com.hairong.channel.qr.param.AddPromotePermissionParam;
import com.hairong.channel.qr.param.GetSalesmanQrCodeParam;
import com.hairong.channel.qr.utils.QRCodeUtil;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

public class ChannelTest extends BaseTest {

	@Test
	/**
	 * 增加业务员
	 */
	public void testAddQr() {
		
		ExcelReader reader = ExcelUtil.getReader("C:\\Users\\Administrator\\Desktop\\推广开码demo(2).xlsx");
		List<Map<String,Object>> readAll = reader.readAll();
		for (Map<String, Object> map : readAll) {
			Request request = new Request();
			request.setName("channel.promote.addsalesman");
			request.setVersion("2.0");
			 
			
			AddPromotePermissionParam addPromotePermissionParam =  new AddPromotePermissionParam();
			BeanUtil.copyProperties(map, addPromotePermissionParam);
			request.setParam(addPromotePermissionParam);
			
			Response response = client.execute(request);
			if (response.isSuccess()) {
				// 返回结果
				Map<String, Object> data = response.getData();
				System.out.println(data.get("salesmanNo"));
				 
			} else {
				System.out.println("errorCode:" + response.getCode() + ",errorMsg:" + response.getMsg());
				System.out.println(map.get("salesmanMobile")+"：api调用错误");
			}
		}
		
	}
	
	@Test
	public void testGetQr() {
		ExcelReader reader = ExcelUtil.getReader("C:\\Users\\Administrator\\Desktop\\excel\\推广开码20201104.xlsx");
		List<Map<String,Object>> readAll = reader.readAll();
		for (Map<String, Object> map : readAll) {
			String provinceName = null;
			String cityName = null;
			String salesmanNo = String.valueOf(map.get("salesmanNo"));
			String salesmanName = String.valueOf(map.get("salesmanName"));
			String salesmanMobile = String.valueOf(map.get("salesmanMobile"));
			String provinceNo = String.valueOf(map.get("provinceNo"));
			String cityNo = String.valueOf(map.get("cityNo"));
			ExcelReader reader1 = ExcelUtil.getReader("D:\\省市编码表v1.1.0.xlsx");
			List<Map<String, Object>> maps = reader1.readAll();
			for (Map<String, Object> map1 : maps){
				String provinceNo2 = String.valueOf(map1.get("省编码"));
				String cityNo2 = String.valueOf(map1.get("市编码"));
				if (provinceNo2.equals(provinceNo) && cityNo2.equals(cityNo)){
					provinceName = String.valueOf(map1.get("省名称"));
					cityName = String.valueOf(map1.get("市名称"));
				}
			}

			Request request = new Request();
			request.setName("channel.qrcode.get");
			request.setVersion("1.0");
			 
			GetSalesmanQrCodeParam getSalesmanQrCodeParam = new GetSalesmanQrCodeParam();
			getSalesmanQrCodeParam.setSalesmanNo(salesmanNo);
			 
			request.setParam(getSalesmanQrCodeParam);
			
			Response response = client.execute(request);
			if (response.isSuccess()) {
				System.out.println("provinceName:"+provinceName);
				System.out.println("cityName:"+cityName);
				// 返回结果
				Map<String, Object> data = response.getData();
//				System.out.println(data);
				String url = String.valueOf(data.get("url"));
				  try {
					QRCodeUtil.encodeWithNumberSmall(salesmanName, url, null, "C:\\Users\\Administrator\\Desktop\\ErWeiMa\\salesmanqr_20201104_广宏帆2", salesmanNo+"_"+salesmanName+"_"+salesmanMobile, false);
					//QRCodeUtil.encodeWithNumberSmall(salesmanName, url, null, "C:\\Users\\Administrator\\Desktop\\ErWeiMa\\salesmanqr_20201030_广宏帆8", salesmanNo+"_"+salesmanMobile, false);
					//QRCodeUtil.encodeWithNumberSmall(salesmanName+"-"+provinceName+cityName, url, null, "C:\\Users\\Administrator\\Desktop\\ErWeiMa\\salesmanqr_20201104_广宏帆", salesmanNo+"_"+salesmanMobile, false);

				  } catch (Exception e) {
					System.out.println(map.get("salesmanNo")+"：执行qr生成错误");
					e.printStackTrace();
				}  
			} else {
				System.out.println("errorCode:" + response.getCode() + ",errorMsg:" + response.getMsg());
				System.out.println(map.get("salesmanNo")+"：api调用错误");
			}
		}
	}
 
}
