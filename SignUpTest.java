package login;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import login.SignUpPage.VerificationPage;

import login.GmailPageTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

	public class SignUpTest {

	    private ChromeDriver driver;
	    private final String baseUrl = "https://event-management-67h6cuavza-uc.a.run.app/";
	    private boolean enablePauses = true; // Set this to true to enable waits, false to disable.
	    private login.GmailPage gmailPage;
	    
	    
	    
	    @BeforeEach
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.get(baseUrl);
	        SignUpPage  signup = new SignUpPage(driver);
	    }
	    
	    /**
	     * setup function.
	     */
	    
	    @AfterEach
	    public void tearDown() {
	    	if(driver!=null) {
		        driver.quit();
	    	}
	    }
	    
	    
	    @Test
	    public void signUpTestWithPauses() throws InterruptedException {
	        SignUpPage signUpPage = new SignUpPage(driver);
	        driver.get(baseUrl);
	        if (enablePauses) {
	            Thread.sleep(2000);
	        }

	        // Step 1: Click the sign-up link.
	        signUpPage.clickSignUpLink();
	        pauseIfNeeded();

	        // Step 2: Enter the email.
	        signUpPage.enterEmail("emspnwtest@gmail.com");
	        pauseIfNeeded();

	        // Step 3: Enter the password.
	        signUpPage.enterPassword("fall2023@pnw");
	        pauseIfNeeded();

	        // Step 4: Confirm the password.
	        signUpPage.confirmPassword("fall2023@pnw");
	        pauseIfNeeded();

	        // Step 5: Click the submit button.
	        signUpPage.clickSubmitButton();
	        pauseIfNeeded();
	        
	        // Step 6: Assert the second <h1> element text.
	        String secondH1Text = signUpPage.getSecondH1Text();
	        assertEquals("Verify Your E-mail Address", secondH1Text);
	        
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
	        
	        gmailPage.enterSubject("Please Confirm Your E-mail Address");
	        pauseIfNeeded();
	        
	        gmailPage.clickSendButton();
	        pauseIfNeeded();
	        
	        gmailPage.clickLatestOrRefresh();
	        pauseIfNeeded();
	    }
		private void pauseIfNeeded() throws InterruptedException {
			// TODO Auto-generated method stub
	        if (enablePauses) {
	            Thread.sleep(2000);
	        }
		}
	    }
	    
	    class EmailVerificationTest {

	        private WebDriver driver;
	        private boolean enablePauses = true; // Set this to true to enable waits, false to disable.

	        @BeforeEach
	        public void setUp() {
	            // Initialize the WebDriver (You may need to set the path to chromedriver.exe here).
	            driver = new ChromeDriver();
	        }

	        @Test
	        public void sendEmailVerificationLinkTest() throws InterruptedException {
	            // Assume that you have already signed up and are on a page where you can send a verification email.
	            
	            // Step 1: Find and click the "Send Verification Email" button.
	            WebElement sendEmailButton = driver.findElement(By.id("sendEmailButton"));
	            sendEmailButton.click();
	            pauseIfNeeded();

	            // Step 2: Check for a success message or confirmation that the email was sent.
	            login.SignUpPage signUpPage = new login.SignUpPage(driver);
	            SignUpPage.VerificationPage verificationPage = signUpPage.new VerificationPage(driver);	            
	            String messageText = verificationPage.getConfirmationMessage();
	            assertEquals("Email verification link sent successfully.", messageText);

	            // You would typically integrate with your email service to send the verification link.
	            // This example only simulates the process.
	        }
	 
	    private void pauseIfNeeded() throws InterruptedException {
	        if (enablePauses) {
	            Thread.sleep(2000);
	        }
	    }
	    }
