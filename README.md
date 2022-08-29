# TSCWF-WebTestAutomation

Repository for TSC WebFactory Regression Test Automation project

----------------------------------------------------------------------
#Running test on different devices and browsers
----------------------------------------------------------------------
In order to run tests for modules on different browsers and devices, below is the 
configuration that is needed to be done in gradle.properties

For Desktop:
test_device = Desktop
test_browser = saucechrome/saucefirefox/saucesafari

For Mobile: Android
test_device = Mobile
test_browser = sauceandroidchrome

For Mobile: ios
test_device = Mobile
test_browser = sauceioschrome

For Tablet: Android
test_device = Tablet
test_browser = sauceandroidchrome

For Tablet: ios
test_device = Tablet
test_browser = sauceioschrome

Property "chromeMobileDevice" should always be empty as below in master branch as below to initialize different object for devices
chromeMobileDevice=
