package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginModelPage1
{
 public WebDriver driver;
 
 By Name        = By.name("uid");
 By Password    = By.name("password");
 By Button      = By.name("btnLogin");
 
 public LoginModelPage1(WebDriver d)
 {
	driver = d;
 }
 
 public void setName(String nm)
 {
	 driver.findElement(Name).sendKeys(nm);
 }

 public void setPassword(String pwd)
 {
	 driver.findElement(Password).sendKeys(pwd);
 }
 
 public void clickLoginButton()
 {
	 driver.findElement(Button).click();
 }
}
