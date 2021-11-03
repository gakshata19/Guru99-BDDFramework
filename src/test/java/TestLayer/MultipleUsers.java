package TestLayer;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.BaseClass.BaseClass;
import Com.UtilsLayer.ExcelReader1;


public class MultipleUsers extends BaseClass{
	
	@Test(dataProvider= "Guru99")
	public void validateMultipleUsers (String uname, String password) throws InterruptedException {
	
		BaseClass.setUp();
		driver.findElement(By.name("uid")).sendKeys(uname);
    	driver.findElement(By.name("password")).sendKeys(password);
    	driver.findElement(By.name("btnLogin")).click();
    	
    	try {
    		Alert act= driver.switchTo().alert();
    		System.out.println("Message in alert: "+act.getText());
    		act.accept();
    	}
    	catch(NoAlertPresentException e) {
    		System.out.println(driver.getTitle());
    	}
    	Thread.sleep(2000);
	    driver.close();
	}
	
	@DataProvider(name="Guru99")
	public Object[][] passData(){
		ExcelReader1 excel=new ExcelReader1();
		int rcount=excel.rowcount(0);
		Object [][] obj=new Object[rcount][2];
		for(int i=0; i<rcount; i++) {
			obj[i][0]=excel.getData(0,i,0);
			obj[i][1]=excel.getData(0, i,1);
		}
		return obj;
	}
}
