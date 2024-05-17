package com.facebook.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.facebook.page.MasterPage;

public class LoginPage extends MasterPage{

	//Login, forgot Password,create account,change language etc.
	
	public LoginPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

     public boolean login(String uname, String pwd) {
		
    	sendkeys("emailOrPh_txtfield", uname);
    	sendkeys("password_txtfield", pwd);
    	clickbutton("login_button");
    	edgeacts();
    	return isLinkPresent("home_hyperlink");
    	
		
		
	}
     
     public void forgotPassword() {
 		
 		System.out.println("Forgot Password");
 		
 	}
}
