package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FundTransferModel 
{
	public WebDriver driver;
	
	By PayersAccNo  = By.name("payersaccount");
	By PayeeAccNo   = By.name("payeeaccount");
	By Amount       = By.name("ammount");
	By Description  = By.name("desc");
	By AcSubmit     = By.name("AccSubmit");
	
	public FundTransferModel(WebDriver wd)
	{
		driver = wd;
	}
	
	public void setPayerAccNo(String pa)
	{
		driver.findElement(PayersAccNo).sendKeys(pa);
	}
	
	public void setPayeeAccNo(String pe)
	{
		driver.findElement(PayeeAccNo).sendKeys(pe);
	}
	
	public void setAmount(String amt)
	{
		driver.findElement(Amount).sendKeys(amt);
	}
	
	public void setDescription(String desc)
	{
		driver.findElement(Description).sendKeys(desc);
	}
	
	public void clickSubmit()
	{
		driver.findElement(AcSubmit).click();
	}
	
	

}
