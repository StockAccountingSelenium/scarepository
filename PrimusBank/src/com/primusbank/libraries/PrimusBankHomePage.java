package com.primusbank.libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.primusbank.constant.PrimusBankConstants;

public class PrimusBankHomePage extends PrimusBankConstants{

	static String expurl, acturl;
	
	public boolean adminlogin(String uid,String pwd)
	{
		
		expurl="adminflow";
	
		driver.findElement(By.id("txtuId")).sendKeys(uid);
		driver.findElement(By.id("txtPword")).sendKeys(pwd);
		driver.findElement(By.id("login")).click();
		
		acturl=driver.getCurrentUrl();
		if(acturl.toLowerCase().contains(expurl.toLowerCase()))
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	public boolean branchlogin(String uid,String pwd,String branchname)
	{
		
		
		expurl="Bankers_flow";
	     WebElement blist = driver.findElement(By.id("drlist"));
	     
	     Select branchlistnames=new Select(blist);
	     branchlistnames.selectByVisibleText(branchname);
	     
		driver.findElement(By.id("txtuId")).sendKeys(uid);
		driver.findElement(By.id("txtPword")).sendKeys(pwd);
		driver.findElement(By.id("login")).click();
		
		acturl=driver.getCurrentUrl();
		if(acturl.toLowerCase().contains(expurl.toLowerCase()))
		{
			return true;
		
		}else
		{
			return false;
		}
	}
	
	

	
}
