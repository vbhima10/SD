package login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import login.LoginPage;

public class LoginPageTest {

		    private ChromeDriver driver;
		    private final boolean enablePauses = true; // Set to false to disable pauses
		    private LoginPage loginPage;

		    @BeforeEach
		    public void setUp() {
		        // Set the path to the ChromeDriver executable on your local machine
//		        System.setProperty("webdriver.chrome.driver", "https://event-management-67h6cuavza-uc.a.run.app/accounts/login/?next=/");
		        
		        // Initialize the WebDriver instance
		        driver = new ChromeDriver();
		        
		        // Navigate to the login page URL
		        driver.get(LoginPage.LOGIN_URL);
		        
		        // Create an instance of the LoginPage class
		        loginPage = new LoginPage(driver);
		    }


		    @AfterEach
		    public void tearDown() {
		        if (driver != null) {
		        	driver.quit();
		        }
		    }

		    @Test
		    public void testLoginAsAdmin() throws InterruptedException {
		        // Step 1: Login as admin using the provided method
		        loginPage.loginAsAdmin();
		        pause();

		        // Step 2: Check if the user is logged in
		        assertTrue(loginPage.isLoginIn(), "Login as admin failed");
		        pause();
		    }

		    @Test
		    public void testLoginWithValidCredentials() throws InterruptedException {
		        // Step 1: Login with valid credentials
		        loginPage.login("admin@beulahworks.com", "fall2023@pnw");
		        pause();

		        // Step 2: Check if the user is logged in
		        assertTrue(loginPage.isLoginIn(), "Login with valid credentials failed");
		        pause();
		    }
		    private void pause() throws InterruptedException {
				// TODO Auto-generated method stub
		    	if (enablePauses) {
		    	      Thread.sleep(2000);
			}
		}
		}