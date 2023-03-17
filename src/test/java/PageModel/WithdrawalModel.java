package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithdrawalModel {

	public WebDriver driver;
	
	By AccountNo  = By.name("accountno");
	By Amount     = By.name("ammount");
	By Description = By.name("desc");
	By Submit      = By.name("AccSubmit");
	
	
	public WithdrawalModel(WebDriver dr) 
	{	
		driver = dr;
	}


	public void setAccountNo(String acn) 
	{
		driver.findElement(AccountNo).sendKeys(acn);
	}
	
	public void setAmount(String am)
	{
		driver.findElement(Amount).sendKeys(am);
	}
	
	public void setDescription(String dc)
	{
		driver.findElement(Description).sendKeys(dc);
	}
	
	public void clickwithdrawSubmit()
	{
		driver.findElement(Submit).click();
	}
	
	
}
