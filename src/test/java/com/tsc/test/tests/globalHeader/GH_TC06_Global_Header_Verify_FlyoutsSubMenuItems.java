package com.tsc.test.tests.globalHeader;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class GH_TC06_Global_Header_Verify_FlyoutsSubMenuItems extends BaseTest {

	@Test(groups={"Home","Regression"})	    
	public void verifyFlyoutHeadings() {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		String lsBaseUrl=(new BasePage(this.getDriver())).getBaseURL();
		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(lsBaseUrl+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("Validating shop all brand links.");
		String headingName,categoryName,smHref,pbHref,pbSrc,ccHref;
		List<WebElement> headingsElements=getglobalheaderPageThreadLocal().headingLinks;
		List<WebElement> categoryElement=getglobalheaderPageThreadLocal().CategoriesLinks;
		List<WebElement> subMenuElement=getglobalheaderPageThreadLocal().subMenuLinks;
		List<WebElement> popularBrandElement=getglobalheaderPageThreadLocal().listPopularBrandsLinks;
		List<WebElement> curatedCollectionElement=getglobalheaderPageThreadLocal().listCuratedCollectionLinks;
		for (WebElement heading:headingsElements) {
			getglobalheaderPageThreadLocal().scrolltoWebElement(heading);
			getglobalheaderPageThreadLocal().staticwait();
			headingName=heading.getText();
			reporter.reportLog("Flyout heading "+headingName);
			for (WebElement category:categoryElement) {
				getglobalheaderPageThreadLocal().scrolltoWebElement(category);
				categoryName=category.getText();
				smHref=getglobalheaderPageThreadLocal().verifysubMenuhref(subMenuElement);
				reporter.softAssert(smHref=="","href is present for all elements of submenu > "+categoryName+" >  "+headingName,"href missing for "+headingName+" > "+categoryName+" > "+smHref);
			}
			ccHref=getglobalheaderPageThreadLocal().verifyBrand_Curated_Section(headingName,"CuratedCollection",curatedCollectionElement,null);
			reporter.softAssert(ccHref=="","href is present for all elements > "+headingName+" > Curated Collection","href missing for "+headingName+" > "+ccHref);
			pbHref=getglobalheaderPageThreadLocal().verifyBrand_Curated_Section(headingName,"PopularBrands",popularBrandElement,"href");
			reporter.softAssert(pbHref=="","href is present for all elements > "+headingName +" > Popular Brand","href missing for "+headingName+" > "+pbHref);
			pbSrc=getglobalheaderPageThreadLocal().verifyBrand_Curated_Section(headingName,"PopularBrands",popularBrandElement,null);
			reporter.softAssert(pbSrc=="","src is present for all elements > "+headingName +" > Popular Brand","src missing for "+headingName+" > "+pbSrc);
		}
			
	}
}	





//chHref=getglobalheaderPageThreadLocal().verifyCategoryhref(headingName,categoryElement);
//reporter.softAssert(chHref=="","href is present for all elements of category > "+headingName,"href missing for "+headingName+" > "+chHref);

