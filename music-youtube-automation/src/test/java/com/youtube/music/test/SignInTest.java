package com.youtube.music.test;

import org.testng.annotations.Test;

import com.youtube.music.base.BaseUI;

public class SignInTest extends BaseUI {

	@Test
	public void signInTest() {
		invokeBrowser();
		navigateToURL("https://music.youtube.com/");
		quitBrowser();
	}

}
