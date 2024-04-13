package Daylaunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lunch_browser {

	public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.gecko.driver", "/home/student/Desktop/Anuja/Driver/geckodriver");
	Thread.sleep(2000);
	WebDriver wd=new FirefoxDriver();
	wd.get("https://web.whatsapp.com");

	}

}
