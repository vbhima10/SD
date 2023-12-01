package login;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is responsible for managing login operations.
 * 
 * Usage Example:
 * 
 * WebDriver driver = new ChromeDriver();
 * LoginPage login = new LoginPage(driver);
 * login.logAsAdmin();
 * // after log in, the drivers url will be in the home page
 * @author Rui Zhang
 * @created 2023/09/22
 */
public class LoginPage {
    private WebDriver driver;
    static final String LOGIN_URL = "https://event-management-67h6cuavza-uc.a.run.app/accounts/login/?next=/";
    static final int PAGE_RELOAD_WAIT_TIME = 10;//base on second
    // Web elements for the login page
    private WebElement emailInput;
    private WebElement passwordInput;
    private WebElement signInButton;
    private WebElement signInPageHeader;
    private WebElement logoutLink;

    // Selectors for the web elements
    private static final By emailInputSelector = By.name("login");
    private static final By passwordInputSelector = By.name("password");
    private static final By signInButtonSelector = By.className("primaryAction");
    private static final By signInPageHeaderSelector = By.xpath("//h1[text()='Existing User? Sign In Now']");
    private static final By logoutLinkSelector = By.xpath("//a[@href='/logout/']");


    /**
     * Constructor for LoginPage.
     * @param driver WebDriver instance.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        initializeWebElements();
    }

    /**
     * Initializes web elements.
     */
    private void initializeWebElements(){
        emailInput = driver.findElement(emailInputSelector);
        passwordInput = driver.findElement(passwordInputSelector);
        signInButton = driver.findElement(signInButtonSelector);
        signInPageHeader = driver.findElement(signInPageHeaderSelector);
    }

    /**
     * Logs in as admin.
     */
    public void loginAsAdmin() {
        login("admin@beulahworks.com","fall2023@pnw");
    }

    /**
     * Logs in with provided email and password.
     * @param emailAddress Email address.
     * @param password Password.
     */
    public void login(String emailAddress, String password) {
        if (!isOnLoginPage()) {
            throw new IllegalStateException("Not on the login page");
        }
        // enter the info
        enterEmail(emailAddress);
        enterPassword(password);
        //click the login button
        clickSignInButton();
        //wait for respond and get the top link elements
        waitForPageToLoad();

        if (!isLoginIn()) {
            throw new IllegalStateException("Login failed");
        }
    }

    /**
     * Enters email.
     * @param emailAddress Email address.
     */
    private void enterEmail(String emailAddress) {
        emailInput.sendKeys(emailAddress);
    }

    /**
     * Enters password.
     * @param password Password.
     */
    private void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    /**
     * Clicks login button.
     */
    private void clickSignInButton() {
        signInButton.click();
    }

    /**
     * Checks if on login page.
     * @return True if on login page, false otherwise.
     */
    public boolean isOnLoginPage() {
        return signInPageHeader != null;
    }

    /**
     * Checks if already log in. Depend on if the log out link exist
     * @return True if already log in, false otherwise.
     */
    public  boolean isLoginIn(){
        return isLogoutLinkPresent();
    }

    /**
     * Checks if logout link is present.
     * @return True if logout link is present, false otherwise.
     */
    private boolean isLogoutLinkPresent() {
        try{
            logoutLink = driver.findElement(logoutLinkSelector);
        }catch (NoSuchElementException e) {
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Waits for page to load.
     */
    private void waitForPageToLoad() {
        waitForPageToLoad(PAGE_RELOAD_WAIT_TIME);
    }

    /**
     * Waits for page to load for a specified duration.
     * @param sec The number of seconds to wait for the page to load.
     * @throws TimeoutException if the page does not load within the specified duration.
     */
    private void waitForPageToLoad(int sec) {
        // If the specified duration is less than or equal to 0, return immediately without waiting
        if(sec <=0 ){
            return;
        }
        // Use WebDriverWait to wait until the page's readyState is 'complete', indicating that the page has fully loaded
        // If the page does not load within the specified duration, a TimeoutException is thrown
        try {
            new WebDriverWait(driver, Duration.ofSeconds(PAGE_RELOAD_WAIT_TIME)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (TimeoutException e) {
            throw new TimeoutException("Page did not load within " + sec + " seconds.");
        }
    }
}
