package com.tsc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.openqa.selenium.By;

public class ProductResultsPage_iPad extends ProductResultsPage{
	public ProductResultsPage_iPad(WebDriver driver) {
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
	
	//ProductResultsPage productResultPage=new ProductResultsPage(this.getDriver());

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
		
		int loopSize=this.productFilterList.size();		
		for(int i=0;i<loopSize;i++) {			
			getReusableActionsInstance().javascriptScrollByVisibleElement(this.productFilterList.get(i));
			String lsHeader=this.productFilterList.get(i).getText().trim();
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
				}
								
				List<WebElement> subItemList=this.cntProductSecondlevelFilterListContainer.get(i).findElements(this.bySecondlevelFilterList);				
				for(WebElement subItem : subItemList) {
					getReusableActionsInstance().javascriptScrollByVisibleElement(subItem);
					String lsSubItem=subItem.getText().trim();	
					
					//If found lsSecondLevelItem
					if(lsSubItem.equalsIgnoreCase(lsSecondLevelItem)) {							
						subItem.click();
						return waitForCondition(Driver->{return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");},60000);
					}
				}	
			}
		}
		
		//If unable to find both lsFirstLevelItem and lsSecondLevelItem, then select the first choice
		this.bDefault=true;		
		WebElement btnSecondlevelSelected=this.secondlevelFilterList.get(0);
		WebElement btnFirstlevelSelected=btnSecondlevelSelected.findElement(By.xpath("./ancestor::div[@id='tabletFilterBar']//*[contains(@class,'panel-heading')]"));
		getReusableActionsInstance().javascriptScrollByVisibleElement(btnSecondlevelSelected);
		this.firstLevelFilter=btnFirstlevelSelected.getText().trim();
		if(this.firstLevelFilter.contains("(")) {
			this.firstLevelFilter=this.firstLevelFilter.split("\\(")[0].trim();				
		}
		
		btnSecondlevelSelected.click();
		getReusableActionsInstance().staticWait(300);
		
		getReusableActionsInstance().javascriptScrollByVisibleElement(btnSecondlevelSelected);
		this.secondLevelFilter=btnSecondlevelSelected.getText().trim();
		btnSecondlevelSelected.click();
				
		return waitForCondition(Driver->{return !this.productResultLoadingIndicator.getAttribute("style").equalsIgnoreCase("display: block;");},60000);
	}
  

}

	
