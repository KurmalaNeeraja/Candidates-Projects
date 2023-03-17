package bankApplication;

import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Arrays;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class BankApplication 
{
	
	String Acc_id ;
	String Cx_id ;
	WebDriver driver;
	WebElement element;
	 @BeforeClass
  public void beforeClass() 
  {
		 WebDriverManager.chromedriver().setup();
		 
		 ChromeOptions options=new ChromeOptions();
		 options.addExtensions(new File("C:\\adds\\extension_5_4_1_0.crx"));  
			options.addArguments("--remote-allow-origins=*"); 
		 options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));

		 driver = new ChromeDriver(options);
		 driver.switchTo().defaultContent();
		 
	
		  
  }
	 @Test(priority = 0 )
	 public void testCase1() 
	 {
		 System.out.println("Executing TestCase 1");
		 
		 driver.navigate().to("https://demo.guru99.com/V4/index.php");
		  driver.manage().window().maximize();
//	Login 
          driver.findElement(By.name("uid")).sendKeys("mngr482783");
          driver.findElement(By.name("password")).sendKeys("A@1235");
          driver.findElement(By.name("btnLogin")).click();
          
     
  	 
  }
	
  @Test(priority = 1)
  public void NweCustomer() throws InterruptedException 
  {	 
	 driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
  	
  	 driver.navigate().refresh();
  	 driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
	   
// TestCase 1 
	       
   driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")).sendKeys("Rashi");  
  
  //TestCase 2   Selecting gender
	 
	  driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")).click();
	  	
 // TestCase 3   Selecting date
	  
	  driver.findElement(By.id("dob")).sendKeys("01032023");
	  
//TestCase 4     Address
	  
	  driver.findElement(By.name("addr")).sendKeys("Neha nagar");

 //TestCase 5    City
	  
	  driver.findElement(By.name("city")).sendKeys("Pune");
	  
//TestCase 7    State
	
	  driver.findElement(By.name("state")).sendKeys("Maharashtra");
	  
//TestCase 8   Pin-code
	
	  driver.findElement(By.name("pinno")).sendKeys("425412");
	  
//TestCase 9  mobile NO
	
	  driver.findElement(By.name("telephoneno")).sendKeys("987654321");
	  
//TestCase 10  Email 
	
	  driver.findElement(By.name("emailid")).clear();
	  driver.findElement(By.name("emailid")).sendKeys("r5@mail.com");
	  
  
//TestCase 11  Password
	
	  driver.findElement(By.name("password")).clear();
	  driver.findElement(By.name("password")).sendKeys("A@123");
	  

//TestCase 12  Submitting 
	
	  driver.findElement(By.name("sub")).click();
	  
//After registration getting customer id
	
	  Cx_id =  driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
	 
	
  }
  @Test(priority = 2)
  public void editCustomer() 
  {
	  //Edit Cx details
	 //TestCase 13
	  
	  driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]/a")).click();
	 
	//TestCase 14	  
	  
	  driver.findElement(By.name("cusid")).sendKeys(Cx_id);
	  
	//TestCase 15
	  
	  driver.findElement(By.name("AccSubmit")).click();
	   
	//TestCase 17
	  
	  driver.findElement(By.name("addr")).clear();
	  driver.findElement(By.name("addr")).sendKeys("KGN Colony HouseNo-106");
	  
	//TestCase 18
	  
	  driver.findElement(By.name("sub")).click();
	  
	  //handling alert
	  
	  System.out.println("Executing TestCase 15");
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
  }
  @Test(priority = 3)
  public void newAccount() throws InterruptedException
  {
	  // click to new account
	  
	  driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[5]/a")).click();
	//TestCase 19
      driver.findElement(By.name("cusid")).sendKeys(Cx_id); 
      
    //TestCase 20
      Select type = new Select(driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td[2]/select")));
      type.selectByValue("Current");
      
    //TestCase 21
      driver.findElement(By.name("inideposit")).sendKeys("5000");
      
      driver.findElement(By.name("button2")).click();
      
      //After adding new account taking account no
      Acc_id = driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]")).getText();
      
  }
  @Test(priority =4)
  public void withdrawal() throws InterruptedException
  {
	  //Withdrawal module
	  
	  driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[9]/a")).click();
	  
	//TestCase 22
	  driver.findElement(By.name("accountno")).sendKeys(Acc_id);  
	  
	//TestCase 23
	  driver.findElement(By.name("ammount")).sendKeys("20");
	  
	//TestCase 24
	  driver.findElement(By.name("desc")).sendKeys("Automation");
	  
	  driver.findElement(By.name("AccSubmit")).click();
	  
  }
  @Test(priority = 5)
  public void fundTransfer() throws InterruptedException
  {
	  //Fund transfer 
	  driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[10]/a")).click();
	  
	//TestCase 25
	  driver.findElement(By.name("payersaccount")).sendKeys(Acc_id);
	  
	//TestCase 26
	  driver.findElement(By.name("payeeaccount")).sendKeys("119181");
	  
	//TestCase 27
	  driver.findElement(By.name("ammount")).sendKeys("100");
	  
	//TestCase 28
	  driver.findElement(By.name("desc")).sendKeys("Automation");
	  
	  driver.findElement(By.name("AccSubmit")).click();
	  
  }
  @Test(priority = 6)
  public void changePassword() throws InterruptedException
  {
//Changing password
	  
	  driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[11]/a")).click();
	  
	//TestCase 29
	  driver.findElement(By.name("oldpassword")).sendKeys("A@1235");
	  
	//TestCase 30
	  driver.findElement(By.name("newpassword")).sendKeys("A@1235");
	  
	//TestCase 31
	  driver.findElement(By.name("confirmpassword")).sendKeys("A@1235");
	  
	  driver.findElement(By.name("sub")).click();
	  
	  Alert al = driver.switchTo().alert();
	  al.accept();
	  
  }
  @Test(priority = 7)
  public void reLogin()
  {                      
	  //After changing password again login with new password
	
	  driver.findElement(By.name("uid")).sendKeys("mngr482783");
      driver.findElement(By.name("password")).sendKeys("A@1235");
      driver.findElement(By.name("btnLogin")).click();
	  
  }
  @Test(priority = 8)
  public void logout()
  
  {    
	  // Logging out 	 
	  driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
	  
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
  }
  

  @AfterClass
  public void afterClass()
  {
	  //driver.close();
  }

}
