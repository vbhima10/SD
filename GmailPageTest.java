package login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import login.GmailPage;

public class GmailPageTest {
    private ChromeDriver driver;
    private boolean enablePauses = true; // Control whether waits are enabled or not
    private GmailPage gmailPage;
    
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://mail.google.com");
        gmailPage = new GmailPage(driver);
    }
    
    @AfterEach
    public void tearDown() {
    	if (driver != null) {
    		driver.quit();
    	}
    }

    @Test
    public void gmailTest() throws InterruptedException {
    	gmailPage = new GmailPage(driver);
        if (enablePauses) {
            Thread.sleep(2000);
        }

        gmailPage.clickSignUpButton();
        Thread.sleep(5000);
        
    	gmailPage.enterEmail("emspnwtest@gmail.com");
        pauseIfNeeded();
        
        gmailPage.clickNext();
        pauseIfNeeded();
        
        gmailPage.enterPassword("fall2023@pnw");
        pauseIfNeeded();
        
        gmailPage.clickNext();
        pauseIfNeeded();

        // Add assertions or further test steps here as needed.
        gmailPage.clickSearchButton();
        pauseIfNeeded();
        
        gmailPage.enterSubject("Please Confirm Your E-mail Address");
        pauseIfNeeded();
        
        gmailPage.clickSendButton();
        pauseIfNeeded();
        
        gmailPage.clickLatestOrRefresh();
        pauseIfNeeded();
        
    }
	private void pauseIfNeeded() {
        if (enablePauses) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}