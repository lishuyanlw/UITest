package com.tsc.data.pojos;

public class MutableCapabilities {
	private String platformName;
	private String browserVersion;
	/**
	 * @return the browserVersion
	 */
	public String getBrowserVersion() {
		return browserVersion;
	}
	/**
	 * @param browserVersion the browserVersion to set
	 */
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
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
}

