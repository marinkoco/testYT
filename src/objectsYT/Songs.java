package objectsYT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Songs {
	
	public static final String URL = "https://www.youtube.com/results?search_query=Rick+Astley+Never+gonna+give+you+up";
	private static final String SONG_XPATH = "//*[@id=\"video-title\"]/yt-formatted-string";
	private static final String SONG_AD_XPATH = "//*[@id=\"skip-button:6\"]/span/button";
	private static final String NEXT_SONG_XPATH = "//*[@id=\"movie_player\"]/div[33]/div[2]/div[1]/a[2]";
	
	public static void playSong(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(SONG_XPATH));
		we.click();
	}
	
	public static void skipAds(WebDriver driver) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ad = driver.findElement(By.xpath(SONG_AD_XPATH));
		ad.click();
	}
	
	public static void playNextSong(WebDriver driver) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement we1 = driver.findElement(By.xpath(NEXT_SONG_XPATH));
		we1.click();
	}

}
