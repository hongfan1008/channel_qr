package com.hairong.channel.qr.param;

public class AddPromotePermissionParam {


	
//	@ApiDocField(description = "业务员编号(可空，不填写则系统递增自动生成)",dataType = DataType.STRING, required = false, example = "10000000001")
//	@NotEmpty(message = "业务员编号不能为空")
	private String salesmanNo;
	
	
//	@ApiDocField(description = "业务员姓名",dataType = DataType.STRING, required = true, example = "张三")
//	@NotEmpty(message = "业务员姓名不能为空")
	private String salesmanName;
	
//	@ApiDocField(description = "业务员手机号",dataType = DataType.STRING, required = true, example = "15130141111")
//	@NotEmpty(message = "业务员手机号")
	private String salesmanMobile;
	
//	@ApiDocField(description = "业务员身份证号(可空)",dataType = DataType.STRING, required = false, example = "130184198004152576")
//	@NotEmpty(message = "业务员身份证号")
//	private String salesmanIdNo;
	
//	@ApiDocField(description = "省份编号",dataType = DataType.STRING, required = true, example = "010000")
//	@NotEmpty(message = "省份编号")
	private String provinceNo;
	
//	@ApiDocField(description = "城市编号",dataType = DataType.STRING, required = true, example = "010100")
//	@NotEmpty(message = "城市编号")
	private String cityNo;

//	@ApiDocField(description = "二维码有效时间(不为空则为临时码),以秒为单位。 最大不超过2592000（即30天）",dataType = DataType.INT, required = false, example = "")
//	@Max(2592000)
//	private  Integer expireSeconds;

	//	@ApiDocField(description = "代理商名称(系统中没有则新建)",dataType = DataType.STRING, required = true, example = "张三")
//	@NotEmpty(message = "代理商名称不能为空")
	private String companyName;

	private String regionalName;

	private String projectName;
	
	
//	public Integer getExpireSeconds() {
//		return expireSeconds;
//	}
//
//	public void setExpireSeconds(Integer expireSeconds) {
//		this.expireSeconds = expireSeconds;
//	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	public String getSalesmanMobile() {
		return salesmanMobile;
	}

	public void setSalesmanMobile(String salesmanMobile) {
		this.salesmanMobile = salesmanMobile;
	}

//	public String getSalesmanIdNo() {
//		return salesmanIdNo;
//	}
//
//	public void setSalesmanIdNo(String salesmanIdNo) {
//		this.salesmanIdNo = salesmanIdNo;
//	}

	public String getProvinceNo() {
		return provinceNo;
	}

	public void setProvinceNo(String provinceNo) {
		this.provinceNo = provinceNo;
	}

	public String getCityNo() {
		return cityNo;
	}

	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSalesmanNo() {
		return salesmanNo;
	}

	public void setSalesmanNo(String salesmanNo) {
		this.salesmanNo = salesmanNo;
	}

	public String getRegionalName() {
		return regionalName;
	}

	public void setRegionalName(String regionalName) {
		this.regionalName = regionalName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
