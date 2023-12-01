package login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

public class GmailPage {
	
    private ChromeDriver driver;
    
    public GmailPage(ChromeDriver driver) {
        driver.get("https://mail.google.com");
        this.driver = driver;
    }
    
    
    public void clickSignUpButton() {
        WebElement signUpButton = driver.findElement(By.xpath("/html/body/header/div/div/div/a[2]"));
        signUpButton.click();
    }
    
    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
        signInButton.click();
    }
    
    public void enterEmail(String email) {
	WebElement emailInput = driver.findElement(By.xpath("//input[@id='identifierId']"));
	emailInput.sendKeys(email);
    }
    public void clickNext() {
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement nextButton = driver.findElement(By.xpath("//span[contains(text(), 'Next')]"));
        nextButton.click();
    }
    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        passwordInput.sendKeys(password);
    }
    public void clickSearchButton() {
    	WebElement searchButton = driver.findElement(By.cssSelector("[aria-label='Search mail']"));
        searchButton.click();
    }
    public void enterSubject(String subject) {
        WebElement subjectInput = driver.findElement(By.name("q"));
        subjectInput.sendKeys(subject);
    }

    public void clickSendButton() {
        WebElement sendButton = driver.findElement(By.cssSelector("button.gb_Ee.gb_Fe.bEP"));
        sendButton.click();
    }
    
        public void clickLatestOrRefresh() {
            // Try to find the latest email
            WebElement latestEmail = driver.findElement(By.xpath("(//div[@role='main']//tr[@jsmodel])[1]"));
            

            if (latestEmail != null) {
                latestEmail.click();
            } else {
                // If the latest email is not found, refresh the inbox
                WebElement refreshButton = driver.findElement(By.cssSelector("[aria-label='Refresh']"));
                refreshButton.click();
            }
        }
}