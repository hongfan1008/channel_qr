package com.hairong.channel.qr.param;

public class GetSalesmanQrCodeParam {

	
//	@ApiDocField(description = "业务员编号",dataType = DataType.STRING, required = true, example = "10000000001")
//	@NotEmpty(message = "业务员编号不能为空")
    private String salesmanNo;

	public String getSalesmanNo() {
		return salesmanNo;
	}

	public void setSalesmanNo(String salesmanNo) {
		this.salesmanNo = salesmanNo;
	}
	
}
