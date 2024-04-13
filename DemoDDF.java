package dempframework;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoDDF {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "/home/student/Desktop/Pooja/Driver/geckodriver");
		WebDriver wd=new FirefoxDriver(); //Interface
		Thread.sleep(2000);
		wd.get("https://www.saucedemo.com/v1/");
		//file reading
		FileInputStream fis=new FileInputStream("/home/student/Desktop/PNC/Driver/dataExcel2.xlsx"); //path/filename
		XSSFWorkbook wk=new XSSFWorkbook(fis);
		XSSFSheet sh=wk.getSheet("aaa");
		
		for(int i=0;i<=sh.getLastRowNum();i++)
		{
			XSSFRow rw=sh.getRow(i);
			XSSFCell un=rw.getCell(0);
			XSSFCell pw=rw.getCell(1);
		
			
			wd.findElement(By.id("user-name")).sendKeys(un.toString());
			wd.findElement(By.id("password")).sendKeys(pw.toString());
			wd.findElement(By.id("login-button")).click();
		
			wd.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/button")).click();
			wd.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
			
			//System.out.println(un.toString(),pw.toString());
		}
	}

}
