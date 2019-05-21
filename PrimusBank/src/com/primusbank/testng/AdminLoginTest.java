package com.primusbank.testng;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.primusbank.constant.PrimusBankConstants;
import com.primusbank.libraries.AdminHomePage;
import com.primusbank.libraries.PrimusBankHomePage;



public class AdminLoginTest extends PrimusBankConstants{
	
	@Parameters({"uid","pwd"})
    @Test
	public  void checkadminlogin(String username,String password)
	{
		PrimusBankHomePage phome= new PrimusBankHomePage();
	   boolean res= phome.adminlogin(username,password);
	   Assert.assertTrue(res);
	   
		AdminHomePage ahome=new AdminHomePage();
		ahome.adminlogout();
				
	}
	

}
