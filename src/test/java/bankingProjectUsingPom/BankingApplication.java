package bankingProjectUsingPom;

import java.io.File;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import PageModel.AddNewCxModel;
import PageModel.ChangePwdModel;
import PageModel.EditCustomerModel;
import PageModel.FundTransferModel;
import PageModel.LoginModelPage1;
import PageModel.WithdrawalModel;
import PageModel.AddNewAccount;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BankingApplication
{
	String Acc_No ;
	String Cx_id ;
	WebDriver driver;
	WebElement element;
	WebDriverWait wait;
	
	AddNewCxModel      ac;
	LoginModelPage1    lm;
	EditCustomerModel  ec;
	AddNewAccount      na;
	WithdrawalModel     wd;
	FundTransferModel  ft;
	ChangePwdModel     cp;
	
	 @BeforeClass
	  public void beforeClass() throws InterruptedException 
	 {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		
	 options.addExtensions(new File("C:\\adds\\extension_5_4_1_0.crx"));  
		options.addArguments("--remote-allow-origins=*"); 
	options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		 driver = new ChromeDriver(options);	
		 
		  wait = new WebDriverWait(driver, Duration.ofSeconds(10))  ;  
     //    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		 
		 
		 ac = new AddNewCxModel(driver); // creating object 
		 lm = new LoginModelPage1(driver);	 
		 ec = new EditCustomerModel(driver);
		 na = new AddNewAccount(driver);
		 wd = new WithdrawalModel(driver);
		 ft = new FundTransferModel(driver);
		 cp = new ChangePwdModel(driver);
		 	 
	  }
	 @Test(priority = 1)
  public void lauchBrowser() 
  {		 
	
	driver.navigate().to("https://demo.guru99.com/V4/index.php");
	driver.manage().window().maximize();	
		 
	 lm.setName("mngr482783");
	 lm.setPassword("A@1235");
		  
	 lm.clickLoginButton();
	 
	System.out.println(lm.driver.getCurrentUrl());	
		       
  }
	
  @Test(priority = 2)
  public void addNewCustomer() throws InterruptedException 
  {
	 lm.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
	 driver.navigate().refresh();
	 lm.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
	  	 
	lm.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
//TesCase 1
	  ac.setName("Preeti");
	  
//TestCase 2
	  ac.selectGender();
	  
//TestCase 3
	  ac.setdate("01-03-2001");
	  
//TestCase 4	  
	  ac.setaddress("Kukdel123");	 
	  
//TestCase 5	  
	  ac.setcity("Mumbai");
	  
//TestCase 6	  
	  ac.setstate("Maharashtra");
	  
//TestCase 7	  
	  ac.setpin("332211");
	  
//TestCase 8	  
	  ac.setMobileNo("987654321");
	  
//TestCase 9
	  ac.setemail("P1@mail.com");
	  
//TestCase 10
      ac.setPassword("P@986");
    	
   
      ac.clickSubmit();   
	  
// taking customer registration message & printing to console
	  
	  String s = ac.driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[1]/td/p")).getText();
      System.out.println("Cx Regestered  : " +s);
  }
  
  @Test(priority = 3)
  public void editCustomerDetails()
  {                                  
	//Edit Customer details  
	  
	  //taking customer Id & printing it to console
	  
	  Cx_id =  ac.driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
	  System.out.println("Customer ID is  : " + Cx_id);
	  
	//  ec.driver.findElement(By.xpath("//a[normalize-space()='Edit Customer']")).click();
	//  ec.driver.navigate().refresh();
	  ec.driver.findElement(By.xpath("//a[normalize-space()='Edit Customer']")).click();
	  
	//  ec.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//TestCase 11 	  
	  ec.setCustomerid(Cx_id);
	  ec.clickBeforeEditSubmit();
	 
//TestCase 12 	
	  ec.setAddress("HouseNo 24");
	  
//TestCase 13 	 
	  ec.setCity("Bangalore");
	  
//TestCase 14 	 
	  ec.setState("Karnataka");
	  ec.clickAfterEditSubmit();
	  
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
  }
  @Test(priority = 4)
  public void addNewAccount()
  {     
	//  na.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[5]/a")).click();
	//  na.driver.navigate().refresh();
	  na.driver.findElement(By.xpath("//a[normalize-space()='New Account']")).click();
	  
//TestCase 15	 	  
	  na.setCustomerid(Cx_id);
	  
//TestCase 16 	 
	  na.setAccountType();
	  
//TestCase 17	 
	  na.setInitialDeposit("10000");
	  na.clickSubmit();
	  
	  // taking Creation message print it to console
	  
	  String msg = na.driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[1]/td/p")).getText();
	  System.out.println("Account Creation Message "+msg);
	   
	  // taking account no 
	  
	  Acc_No = na.driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]")).getText();
	  System.out.println("Customer Account Number :"+ Acc_No);
	  
  }
  @Test(priority = 5)
  public void withdrawal()
  {
	  // Withdrawal amount 
	  wd.driver.findElement(By.cssSelector("a[href='WithdrawalInput.php']")).click();
	  
//TestCase 18 	 
	  wd.setAccountNo(Acc_No);
	  
//TestCase 19	 
	  wd.setAmount("500");
	  
//TestCase 20 	 
	  wd.setDescription("withdraw money");
	  wd.clickwithdrawSubmit();
	  
	  //taking withdrawal details to console
	  
	  String Wdraw = wd.driver.findElement(By.cssSelector("#withdraw > tbody > tr:nth-child(1) > td > p")).getText();
	  System.out.println("Withdraw Details  :"+ Wdraw);	  
	  
  }
  @Test(priority = 6)
  public void fundTransfer()
  {
	  // Transferring Funds
	  ft.driver.findElement(By.xpath("//a[normalize-space()='Fund Transfer']")).click();
	  
//TestCase 21 	   
	  ft.setPayerAccNo(Acc_No);
	  
//TestCase 22 	 
	  ft.setPayeeAccNo("119474");
	  
//TestCase 23 	 
	  ft.setAmount("100");
	  
//TestCase 14	   
	  ft.setDescription("Money Transfer");
	  ft.clickSubmit();
	  
	  //Message printing to console 
	  
	  String ftd = ft.driver.findElement(By.className("heading3")).getText();
	  System.out.println(ftd);
	  
  }
  @Test(priority = 7,enabled = false)
  public void changePassword()
  {
	 cp.driver.findElement(By.xpath("//a[normalize-space()='Change Password']")).click();
	
//TestCase 25 	 
	 cp.setOldPwd("A@1235");
	 
//TestCase 26	 
	 cp.setNewPwd("A@1234");
	 
//TestCase 27	 
	 cp.setConformPwd("A@1234");
	 cp.clickSubmit();
	 
	 Alert alert = driver.switchTo().alert();
	 alert.accept();
	 
  }
  @Test(priority = 8,enabled = false)
  public void loginW()
  {
	  //After changing password again login
	  
	     lm.setName("mngr482783");
		 lm.setPassword("A@1234");
		  
		 lm.clickLoginButton();
		 
	//After login with new Password logging ot
		 
		 lm.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
		  
		  Alert alert = driver.switchTo().alert();
		  alert.accept();
	  
		 
  }
  
  
 

  @AfterClass
  public void afterClass()
  {
	 // lm.driver.close();
	 // ac.driver.close();
	//  ec.driver.close();
	//  na.driver.close();
	 // wd.driver.close();
	//  ft.driver.close();
	//  cp.driver.close();
  }

}
