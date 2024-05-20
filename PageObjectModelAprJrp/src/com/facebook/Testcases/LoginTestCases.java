package com.facebook.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.Pages.LoginPage;
import com.facebook.utilities.ExcelReadingUtility;

public class LoginTestCases {
	
	@Test(dataProvider="data")
	public void loginTest (String uname, String pwd) throws IOException {
		// TODO Auto-generated method stub
		
		LoginPage lp = new LoginPage();

		//lp.forgotPassword();
		
		Assert.assertTrue(lp.login(uname,pwd), "Login Not Successfully done");
		
		

	}
	
	@DataProvider
    public Object[][] data() throws IOException{
		
	ExcelReadingUtility eu = new ExcelReadingUtility();
    	

    return eu.readData("Test Data");
    
    }
}
