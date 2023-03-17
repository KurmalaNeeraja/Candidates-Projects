package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewCxModel {
	
	public WebDriver driver;
	
	By Name      =By.name("name");
	By gender    =By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]");
	By date      =By.id("dob");
	By address   =By.name("addr");
	By city      =By.name("city");
	By state     =By.name("state");
	By pin       =By.name("pinno");
	By MobileNo  =By.name("telephoneno");
	By email     =By.name("emailid");
	By password	 =By.name("password");
	By submit    =By.name("sub");
	
	public AddNewCxModel(WebDriver d)
	{
		driver = d;
	}
	
	public void setName(String n)
	{
		driver.findElement(Name).sendKeys(n);
	}

	
	public void selectGender() 
	{
		driver.findElement(gender).click();
	}
	
	public void setdate(String dt) 
	{
		driver.findElement(date).sendKeys(dt);
	}
	
	public void setaddress(String add) 
	{
		driver.findElement(address).sendKeys(add);
	}
	public void setcity(String c) 
	{
		driver.findElement(city).sendKeys(c);
	}
	public void setstate(String st) 
	{
		driver.findElement(state).sendKeys(st);
	}
	public void setpin(String pn) 
	{
		driver.findElement(pin).sendKeys(pn);
	}
	public void setMobileNo(String tp) 
	{
		driver.findElement(MobileNo).sendKeys(tp);
	}
	
	public void setemail(String em) 
	{
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(em);
	}
	public void setPassword(String pw) 
	{
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pw);
	}
	public void clickSubmit()
	{
		driver.findElement(submit).click();
	}
	
		

}
