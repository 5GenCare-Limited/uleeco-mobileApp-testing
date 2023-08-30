package com.gencare.vo;

public class MobileConfigurationVO {

	private String clientApiKey= null;
	private String deviceName = null;
	private String udId = null;
	private String platformName = null;
	private String platformVersion = null;
	private String appPackage= null;
	private String appActivity= null;
	

	public MobileConfigurationVO(String clientApiKey, String deviceName, String udid, String platformName, String platformVersion, String appPackage, String appActivity) {
		
		this.clientApiKey= clientApiKey;
		this.deviceName = deviceName;
		this.udId = udid;
		this.platformName = platformName;
		this.platformVersion = platformVersion;
		this.appPackage= appPackage;
		this.appActivity=appActivity;
		
	}
		public String getClientApiKey() {
			return clientApiKey;
		}

		public void setClientApiKey(String clientApiKey) {
			this.clientApiKey = clientApiKey;
		}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getUdId() {
		return udId;
	}

	public void setUdid(String udId) {
		this.udId = udId;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}
	
	
	
	public String getAppPackage() {
		return appPackage;
		}
		
		public void setAppPackage(String appPackage) {
			this.appPackage= appPackage;
			}
		
		public String getAppActivity() {
			return appActivity;
		}
		
		public void setAppActivity(String appActivity) {
			this.appActivity= appActivity;
		}
		
		

}
