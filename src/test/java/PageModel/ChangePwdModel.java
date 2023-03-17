package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePwdModel 
{
	public WebDriver driver;
	
	By oldPwd       = By.name("oldpassword");
	By newPwd       = By.name("newpassword");
    By conformPwd	= By.name("confirmpassword");		
    By ClickSubmit  = By.name("sub");

    
    public ChangePwdModel(WebDriver d)
    {
    	driver = d;
    }
    
    public void setOldPwd(String op)
    {
    	driver.findElement(oldPwd).sendKeys(op);
    }
    
    public void setNewPwd(String np)
    {
    	driver.findElement(newPwd).sendKeys(np);
    }
    
    public void setConformPwd(String cp)
    {
    	driver.findElement(conformPwd).sendKeys(cp);
    }
    
    public void clickSubmit()
    {
    	driver.findElement(ClickSubmit).click();
    }
    
    
}

