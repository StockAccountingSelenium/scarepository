package com.primusbank.testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Nimble {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\surendrawebdriverrs\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://primusbank.qedgetech.com");
		Select brlist = new Select(driver.findElement(By.id("drlist")));
		List<WebElement> links = brlist.getOptions();
		System.out.println(links.size());
		String actres = "abc";
		
		boolean flag= false;
		for(int i=0; i<links.size(); i++)
		{
			String s=links.get(i).getText();
			//System.out.println(s);
		    if(s.equals(actres))
		    {
		    	flag=true;
		    	break;
		    }
		}
	    if(flag){
	    	System.out.println("pass");
	    }else
	    {
	    	System.out.println("fail");
	    }
	    
	    
	// 2nd way of initializing 
	/*	boolean flag = true;
		for (int i = 0; i < links.size(); i++) {
			String s =links.get(i).getText();
			//System.out.println(s);
			if (s.equals(actres)) {
				flag=false;
				break;
				}
			}
		if (!flag) {
			System.out.println("pass");
			
		} else {
			System.out.println("fail");

		}*/
		
		
		 	}

}
