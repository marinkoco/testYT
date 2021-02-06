package testYT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectsYT.Home;
import objectsYT.Songs;



public class TestYoutube {
	
	private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority = 1)
	public void testSearch() {
		driver.navigate().to("https://www.youtube.com/");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Home.typeSong(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Home.pressSearch(driver);
		
		String current = driver.getCurrentUrl();
		String expected = Songs.URL;
		
		Assert.assertEquals(current, expected);
	}
	
	@Test(priority = 2)
	public void testPlay() {
		
		driver.navigate().to(Songs.URL);
		
		Songs.playSong(driver);
		
		try {
			Songs.skipAds(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		String current = driver.getCurrentUrl();
		String expected = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
		
		Assert.assertEquals(current, expected);
	}
	
	@Test(priority = 3)
	public void testPlayNext() {

		driver.navigate().to(Songs.URL);
		
		Songs.playSong(driver);
		
		try {
			Songs.skipAds(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Songs.playNextSong(driver);
		
		try {
			Songs.skipAds(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		String current = driver.getCurrentUrl();
		String expected = driver.getCurrentUrl();
		
		Assert.assertEquals(current, expected);
		
	}
		
}
