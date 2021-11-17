package com.youtube.music.test;

import org.testng.annotations.Test;

import com.youtube.music.base.BaseUI;

public class SignInTest extends BaseUI {

	@Test
	public void signInTest() {
		navigateToURL("baseURL");
		clickElement("signInButton_xpath");
		enterText("emailField_id", "email");
		clickElement("emailNextButton_id");
		enterText("passwordField_id", "password");
		clickElement("passwordNextButton_id");
		
	}

}
