package com.primusbank.testng;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.primusbank.constant.PrimusBankConstants;
import com.primusbank.libraries.BrankerHomePage;
import com.primusbank.libraries.PrimusBankHomePage;

public class BankerLoginDDT extends PrimusBankConstants {
	
	public String xlfile="C:\\Users\\SURENDRA\\Documents\\testdata1.xlsx";
	public String xlsheet="logindata";
	 int j=1;
	 
	 @Test(dataProvider="testdata")
	 public void bankerloginTest(String username, String password, String branchname) throws IOException 
	 {
		 PrimusBankHomePage phome= new PrimusBankHomePage();
				boolean res= phome.branchlogin(username,password,branchname);
	            Assert.assertTrue(res);;
				
							
				if(res)
				{
					XLUtills.setCelldata(xlfile, xlsheet, j, 3, "pass");
					XLUtills.fillGreeencolor(xlfile, xlsheet, j, 3);
				}
				else {
					XLUtills.setCelldata(xlfile, xlsheet, j, 3, "fail");
					XLUtills.fillRedcolor(xlfile, xlsheet, j, 3);
				}
				/*try {
					driver.switchTo().alert().accept();
				} catch (Exception e) {
					// TODO: handle exception
				}*/
				
				
				
        BrankerHomePage bhome =new BrankerHomePage();
        bhome.bankerLogout();
        
        /* if (res) {
        	 bhome.bankerLogout();
		}*/
        
        j++;
         
	 }  
	 
        @DataProvider
        public Object[][] testdata() throws IOException
        {
           int rc=XLUtills.getrowCount(xlfile, xlsheet);
            Object[][] data = new Object[rc][3];
            for(int i=1; i<=rc; i++)
            {
            	data[i-1][0]= XLUtills.getCelldata(xlfile, xlsheet, i, 0);
            	data[i-1][1]= XLUtills.getCelldata(xlfile, xlsheet, i, 1);
            	data[i-1][2]=XLUtills.getCelldata(xlfile, xlsheet, i, 2);
            	
            }
            return data;
            
        	
        
	
	    }
	 
	 

}
