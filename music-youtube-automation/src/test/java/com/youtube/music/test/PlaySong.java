package com.youtube.music.test;

import org.testng.annotations.Test;

import com.youtube.music.base.BaseUI;

public class PlaySong extends BaseUI {

	@Test
	public void playSongFromTopSearchResult() {
		navigateToURL("baseURL");
		clickElement("searchIcon_xpath");
		enterText("searchField_xpath", "songTitle");
		assertElementDisplayed("topResultTitleSong_xpath");
		clickElement("topResultPlayButton_xpath");
		assertElementDisplayed("songControlPanel_id");
		assertElementDisplayed("pauseButton_xpath");
	}

	@Test
	public void playSongFromPlaylistSearchResult() {
		navigateToURL("baseURL");
		clickElement("searchIcon_xpath");
		enterText("searchField_xpath", "songTitle");
		scrollDownToElement("topResultPlaylist_xpath");
		assertElementDisplayed("topResultPlaylist_xpath");
		clickElement("fetauredPlaylistPlayButton_xpath");
		assertElementDisplayed("songControlPanel_id");
		assertElementDisplayed("pauseButton_xpath");
	}

	@Test
	public void playSongFromPlaylistScreen() {
		navigateToURL("baseURL");
		clickElement("searchIcon_xpath");
		enterText("searchField_xpath", "songTitle");
		scrollDownToElement("topResultPlaylist_xpath");
		assertElementDisplayed("topResultPlaylist_xpath");
		clickElement("topResultPlaylist_xpath");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement("playlistPlayButton_xpath");
		assertElementDisplayed("songControlPanel_id");
		assertElementDisplayed("pauseButton_xpath");
	}

	@Test
	public void shuflePlaylistFromHeaderButton() {
		navigateToURL("baseURL");
		clickElement("searchIcon_xpath");
		enterText("searchField_xpath", "songTitle");
		scrollDownToElement("topResultPlaylist_xpath");
		assertElementDisplayed("topResultPlaylist_xpath");
		clickElement("topResultPlaylist_xpath");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement("playlistShuffleButton_xpath");
		assertElementDisplayed("songControlPanel_id");
		assertElementDisplayed("pauseButton_xpath");
	}

	@Test
	public void pauseSong() {
		navigateToURL("baseURL");
		clickElement("searchIcon_xpath");
		enterText("searchField_xpath", "songTitle");
		assertElementDisplayed("topResultTitleSong_xpath");
		clickElement("topResultPlayButton_xpath");
		assertElementDisplayed("songControlPanel_id");
		assertElementDisplayed("pauseButton_xpath");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement("pauseButton_xpath");
	}

	@Test
	public void playNextSong() {
		navigateToURL("baseURL");
		clickElement("searchIcon_xpath");
		enterText("searchField_xpath", "songTitle");
		scrollDownToElement("topResultPlaylist_xpath");
		assertElementDisplayed("topResultPlaylist_xpath");
		clickElement("fetauredPlaylistPlayButton_xpath");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentTitleSong = getElementText("currentTitleSong_xpath");
		clickElement("nextSongButton_xpath");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String afterTitleSong = getElementText("currentTitleSong_xpath");
		assertTextNotEquals(currentTitleSong, afterTitleSong);
	}

	@Test
	public void playPreviousSong() {
		navigateToURL("baseURL");
		clickElement("searchIcon_xpath");
		enterText("searchField_xpath", "songTitle");
		scrollDownToElement("topResultPlaylist_xpath");
		assertElementDisplayed("topResultPlaylist_xpath");
		clickElement("fetauredPlaylistPlayButton_xpath");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentTitleSong = getElementText("currentTitleSong_xpath");
		clickElement("nextSongButton_xpath");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement("previousSongButton_xpath");
		String afterTitleSong = getElementText("currentTitleSong_xpath");
		assertTextEquals(currentTitleSong, afterTitleSong);
	}

}
