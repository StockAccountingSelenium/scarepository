package com.primusbank.testng;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.primusbank.constant.PrimusBankConstants;
import com.primusbank.libraries.BrankerHomePage;
import com.primusbank.libraries.PrimusBankHomePage;

public class BankerLoginTest extends PrimusBankConstants{
	
@Parameters({"un","pwd","bname"})
@Test
public void check_banker_login(String un,String pwd,String bname)
{
	
	PrimusBankHomePage phome=new PrimusBankHomePage();
	boolean branchloginres = phome.branchlogin(un, pwd, bname);
	 Assert.assertTrue(branchloginres);
	 
	 BrankerHomePage bhomme=new BrankerHomePage();
	 bhomme.bankerLogout();
	
}
}
