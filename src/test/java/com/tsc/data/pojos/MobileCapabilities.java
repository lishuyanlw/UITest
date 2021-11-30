package com.tsc.data.pojos;

public class MobileCapabilities {
	private String platformName;
	private String platformVersion;
	private String appiumVersion;
	private String deviceName;
	private String deviceOrientation;
	private String deviceType;

	/**
	 * @return the deviceType
	*/
	public String getDeviceType() {	return deviceType;	}

	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(String deviceType) {	this.deviceType = deviceType;	}

	/**
	 * @return the platformVersion
	 */
	public String getPlatformVersion() {
		return platformVersion;
	}
	/**
	 * @param platformVersion the platformVersion to set
	 */
	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}
	/**
	 * @return the platformName
	 */
	public String getPlatformName() {
		return platformName;
	}
	/**
	 * @param platformName the platformName to set
	 */
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	/**
	 * @return the appiumVersion
	 */
	public String getAppiumVersion() {
		return appiumVersion;
	}
	/**
	 * @param appiumVersion the appiumVersion to set
	 */
	public void setAppiumVersion(String appiumVersion) {
		this.appiumVersion = appiumVersion;
	}
	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	/**
	 * @return the deviceOrientation
	 */
	public String getDeviceOrientation() {
		return deviceOrientation;
	}
	/**
	 * @param deviceOrientation the deviceOrientation to set
	 */
	public void setDeviceOrientation(String deviceOrientation) {
		this.deviceOrientation = deviceOrientation;
	}

}

