package login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import login.ForgotPassword;


public class ForgotPasswordTest {

    private ChromeDriver driver;
    private boolean enablePauses = true; // Set this to true to enable waits, false to disable.
    private ForgotPassword forgotPassword;
    private login.GmailPage gmailPage;
    @BeforeEach
    public void setUp() {
        // Initialize the ChromeDriver
    	driver = new ChromeDriver();
        // Navigate to the web page
        driver.get("https://event-management-67h6cuavza-uc.a.run.app/"); 
        forgotPassword = new ForgotPassword(driver); // Initialize ForgotPassword class
    }
    
    @AfterEach
    public void tearDown() {
        // Close the WebDriver after the test
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testForgotPassword() throws InterruptedException {
        // Example test scenario for the "ForgotPassword" page:
        if (enablePauses) {
            Thread.sleep(2000);
        }
    	
        // Step 1: Find and click the "Password Reset" link
        // Find the "Forgot Password?" link by CSS selector
        WebElement passwordResetLink = driver.findElement(By.linkText("Forgot Password?"));
        passwordResetLink.click();
        pauseIfNeeded();

        // Step 2: Enter the email
        forgotPassword.enterEmail("emspnwtest@gmail.com");
        pauseIfNeeded();

        // Step 3: Click the "Reset My Password" button
        forgotPassword.clickResetButton();
        pauseIfNeeded();

        // Step 4: Assert the text of the second <h1> element on the page
        String secondH1Text = forgotPassword.getSecondH1Text();
        assertEquals("Password Reset", secondH1Text);
        pauseIfNeeded();
        
    	gmailPage = new login.GmailPage(driver);
    	gmailPage.enterEmail("emspnwtest@gmail.com");
    	pauseIfNeeded();
        
        gmailPage.clickNext();
        pauseIfNeeded();
        
        gmailPage.enterPassword("fall2023@pnw");
        pauseIfNeeded();

        gmailPage.clickSignInButton();
        Thread.sleep(5000);

        // Add assertions or further test steps here as needed.
        gmailPage.clickSearchButton();
        pauseIfNeeded();
        
        gmailPage.enterSubject("Password Reset E-mail");
        pauseIfNeeded();
        
        gmailPage.clickSendButton();
        pauseIfNeeded();
        
        gmailPage.clickLatestOrRefresh();
        pauseIfNeeded();

    }

    private void pauseIfNeeded() throws InterruptedException {
    if (enablePauses) {
        Thread.sleep(2000); // Pause for 2 second
    }
}
}