package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditCustomerModel 
{
	public WebDriver driver;
	
	By CustomerId  = By.name("cusid");
	By Address     = By.name("addr");
	By City        = By.name("city");
	By State       = By.name("state");
	By fSubmit     = By.name("AccSubmit");
	By lSubmit     = By.name("sub");
	
	public EditCustomerModel(WebDriver d)
	{
		driver = d;
	}
	public void setCustomerid(String cd)
	{
		driver.findElement(CustomerId).sendKeys(cd);
	}

	public void setAddress(String ad)
	{
		driver.findElement(Address).sendKeys(ad);
	}
	
	public void setCity(String ct)
	{
		driver.findElement(City).sendKeys(ct);
	}
	
	public void setState(String stt)
	{
		driver.findElement(State).sendKeys(stt);
	}
	
	public void clickBeforeEditSubmit()
	{
		driver.findElement(fSubmit).click();
	}
	
	public void clickAfterEditSubmit()
	{
		driver.findElement(lSubmit).click();
	}
}
