package com.youtube.music.test;

import org.testng.annotations.Test;

import com.youtube.music.base.BaseUI;

public class SearchSong extends BaseUI {

	@Test
	public void searchSong() {
		navigateToURL("baseURL");
		clickElement("searchIcon_xpath");
		enterText("searchField_xpath", "songTitle");
		assertElementDisplayed("topResultTitleSong_xpath");
	}

	@Test
	public void searchNotExistSong() {
		navigateToURL("baseURL");
		clickElement("searchIcon_xpath");
		enterText("searchField_xpath", "notExistSongTitle");
		assertElementDisplayed("noResultFoundText_xpath");
	}

	@Test
	public void searchPlaylist() {
		navigateToURL("baseURL");
		clickElement("searchIcon_xpath");
		enterText("searchField_xpath", "songTitle");
		scrollDownToElement("topResultPlaylist_xpath");
		assertElementDisplayed("topResultPlaylist_xpath");
	}

}
