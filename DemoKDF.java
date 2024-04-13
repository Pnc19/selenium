package dempframework;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoKDF {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "/home/student/Desktop/Pooja/Driver/geckodriver");
		WebDriver wd=new FirefoxDriver(); //Interface
		Thread.sleep(2000);
		wd.get("https://www.saucedemo.com/v1/");
		//file reading
		FileInputStream fis=new FileInputStream("/home/student/Desktop/PNC/Driver/dataExcel2.xlsx"); //path/filename
		XSSFWorkbook wk=new XSSFWorkbook(fis);
		XSSFSheet sh=wk.getSheet("kdf");
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			XSSFRow rw=sh.getRow(i);
			String key=rw.getCell(1).toString();
			System.out.println(key);
			
			switch (key)
			{
				case "username":
				wd.findElement(By.id("user-name")).sendKeys("standard_user");
				break;
				
				case "password":
					wd.findElement(By.id("password")).sendKeys("secret_sauce");
					break;
					
				case "login":
					wd.findElement(By.id("login-button")).click();
					break;
				
				case "addtocart":
					wd.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[3]/button")).click();
					break;
					
				case "clklogout":
					wd.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/button")).click();
					break;
				
				case "logout":
					wd.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
					break;
					
					
			}
		}
	}
}
