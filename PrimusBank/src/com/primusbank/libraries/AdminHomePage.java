package com.primusbank.libraries;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.primusbank.constant.PrimusBankConstants;

public class AdminHomePage extends PrimusBankConstants {
	public boolean adminlogout()
	{
		driver.findElement(By.xpath("//*[@src='images/admin_but_03.jpg']")).click();
		if(driver.findElement(By.id("login")).isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
				
	}
	
	

}
