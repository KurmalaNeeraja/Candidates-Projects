package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddNewAccount 
{
	 public WebDriver driver;
	
	By CustomerId  = By.name("cusid");
	By AccountType = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td[2]/select");
	By Ideposit    = By.name("inideposit");
	By Submit      = By.name("button2");

	public AddNewAccount(WebDriver dd)
	{
		driver =dd;
	}
	
	public void setCustomerid(String cid)
	{
		driver.findElement(CustomerId).sendKeys(cid);
	}
	
	public void setAccountType() //dropdown
	{
	   Select s = new Select(driver.findElement(AccountType));
	   s.selectByValue("Current");
	}
	
	public void setInitialDeposit(String id)
	{
		driver.findElement(Ideposit).sendKeys(id);
	}
	
	public void clickSubmit()
	{
		driver.findElement(Submit).click();
	}
	
}
