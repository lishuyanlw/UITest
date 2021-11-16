package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.openqa.selenium.By;

public class ProductResultsPage_Tablet extends ProductResultsPage{
	public ProductResultsPage_Tablet(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//product-results//div[@id='tabletFilterBar']//*[contains(@class,'panel-heading')]")
	List<WebElement> productFilterList;

	@FindBy(xpath = "//product-results//div[@id='tabletFilterBar']//popper-content")
	List<WebElement> cntProductSecondlevelFilterListContainer;

	@FindBy(xpath = "//product-results//div[@id='tabletFilterBar']//popper-content//li//div[not(contains(@class,'checked'))]")
	List<WebElement> secondlevelFilterList;

	public By bySecondlevelFilterList=By.xpath(".//ul//li");

	public By byJudgeMoreButtonExistanceContainber=By.xpath(".//div[contains(@class,'ngxp__inner')]/div[@role='tabpanel']/div");

	public By byMoreButtonInSecondlevelFilter=By.xpath(".//span[contains(.,'See More')]/parent::div[not(@aria-expanded)]");

	public By byLessButtonInSecondlevelFilter=By.xpath(".//span[contains(.,'See Less')]/parent::div[@aria-expanded='true']");

	/**
	 * This method will select filter from left panel.
	 * @param String lsFirstLevelItem: header filter keyword
	 * @param String lsSecondLevelItem: subFilter keyword
	 * @return true/false
	 * @author Wei.Li
	 */
	@Override
	public boolean selectFilterItemInLeftPanel(String lsFirstLevelItem,String lsSecondLevelItem) {
		this.firstLevelFilter=lsFirstLevelItem;
		this.secondLevelFilter=lsSecondLevelItem;

		for(int i=0;i<this.productFilterList.size();i++) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			String lsHeader=this.productFilterList.get(i).getText();
			if(lsHeader.contains("(")) {
				lsHeader=lsHeader.split("\\(")[0].trim();
			}

			//If found lsFirstLevelItem
			if(lsHeader.equalsIgnoreCase(lsFirstLevelItem)) {
				this.productFilterList.get(i).click();
				getReusableActionsInstance().staticWait(300);
				WebElement judgeMoreButtonExistanceContainber=this.cntProductSecondlevelFilterListContainer.get(i).findElement(this.byJudgeMoreButtonExistanceContainber);
				if(this.judgeMoreButtonExistenceInLeftPanel(judgeMoreButtonExistanceContainber)) {
					WebElement moreButton=this.cntProductSecondlevelFilterListContainer.get(i).findElement(this.byMoreButtonInSecondlevelFilter);
					getReusableActionsInstance().javascriptScrollByVisibleElement(moreButton);
					moreButton.click();
					getReusableActionsInstance().staticWait(500);
				}

				List<WebElement> subItemList=this.cntProductSecondlevelFilterListContainer.get(i).findElements(this.bySecondlevelFilterList);
				System.out.println("subItemList size: "+subItemList.size());
				for(WebElement subItem : subItemList) {
					getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
					String lsSubItem=subItem.getText().trim();
					getReusableActionsInstance().staticWait(500);

					//If found lsSecondLevelItem
					if(lsSubItem.equalsIgnoreCase(lsSecondLevelItem)) {
						getReusableActionsInstance().staticWait(500);
						subItem.click();
						return this.waitForPageLoading();
					}
				}
			}
		}

		//If unable to find both lsFirstLevelItem and lsSecondLevelItem, then select the first choice
		this.bDefault=true;
		WebElement btnSecondlevelSelected=this.secondlevelFilterList.get(0);
		WebElement btnFirstlevelSelected=btnSecondlevelSelected.findElement(By.xpath("./ancestor::div[@class='panel']//*[contains(@class,'section-header')]"));
		getReusableActionsInstance().javascriptScrollByVisibleElement(btnFirstlevelSelected);
		this.firstLevelFilter=btnFirstlevelSelected.getText().trim();
		if(this.firstLevelFilter.contains("(")) {
			this.firstLevelFilter=this.firstLevelFilter.split("\\(")[0].trim();
		}

		btnFirstlevelSelected.click();
		getReusableActionsInstance().staticWait(300);

		getReusableActionsInstance().javascriptScrollByVisibleElement(btnSecondlevelSelected);
		this.secondLevelFilter=btnSecondlevelSelected.getText().trim();
		btnSecondlevelSelected.click();

		return this.waitForPageLoading();
	}

	@Override
	public String verifyFilterOptions(List<String> lstOptionYml) {
		String lsErrorMsg="";
		int listSize=this.productFilterList.size();
		if(listSize==0) {
			return lsErrorMsg="No product list";
		}

		for(int i=0;i<listSize;i++) {
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			if(lstOptionYml.contains(this.productFilterList.get(i).getText().trim())) {
				continue;
			}else {
				return lsErrorMsg = "Filter option headers in left panel contain "+this.productFilterList.get(i).getText().trim()+" that is not present in input list";
			}
		}
		return lsErrorMsg;
	}

}




	
