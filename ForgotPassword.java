package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword {


	private ChromeDriver driver;

    public ForgotPassword(ChromeDriver driver) {
        this.driver = driver;
    }

    // Method to enter the email for password reset
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("id_email"));
        emailInput.sendKeys(email);
    }

    // Method to click the reset button
    public void clickResetButton() {
        WebElement resetButton = driver.findElement(By.cssSelector("input[value='Reset My Password']"));
        resetButton.click();
    }
    // Method to get text from the second h1 element
    public String getSecondH1Text() {
        WebElement secondH1 = driver.findElements(By.tagName("h1")).get(1);
        return secondH1.getText();
    }

    public class Verification {
        private WebDriver driver;

        public Verification(WebDriver driver) {
            this.driver = driver;
        }

        // Method to get the confirmation message
        public String getConfirmationMessage() {
            WebElement confirmationMessage = driver.findElement(By.id("confirmationMessage"));
            return confirmationMessage.getText();
        }
    }
 	public class GmailPage {

 	    private ChromeDriver driver;
		public Object nextButton;

 	    public GmailPage(ChromeDriver driver) {
 	    	ForgotPassword.this.driver = driver;
 	    }

 	    // Method to enter Gmail email
 	    public void enterEmail(String email) {
 	        WebElement emailInput = driver.findElement(By.id("identifierId"));
 	        emailInput.sendKeys(email);
 	    }

 	    // Method to click "Next" button
 	    public void clickNext() {
 	        WebElement nextButton = driver.findElement(By.xpath("//span[contains(text(), 'Next')]"));
 	        nextButton.click();
 	    }

 	    // Method to enter Gmail password
 	    public void enterPassword(String password) {
 	        WebElement passwordInput = driver.findElement(By.name("Passwd"));
 	        passwordInput.sendKeys(password);
 	    }

 	    // Method to click "Sign Up" button
 	    public void clickSignUpButton() {
 	        WebElement signUpButton = driver.findElement(By.xpath("//span[contains(text(), 'Sign Up')]"));
 	        signUpButton.click();
 	    }

 	    // Method to click the search button
 	    public void clickSearchButton() {
 	        WebElement searchButton = driver.findElement(By.cssSelector("[aria-label='Search mail']"));
 	        searchButton.click();
 	    }

 	    // Method to enter the subject in the search bar
 	    public void enterSubject(String subject) {
 	        WebElement subjectInput = driver.findElement(By.name("q"));
 	        subjectInput.sendKeys(subject);
 	    }

 	    // Method to click the "Send" button
 	    public void clickSendButton() {
 	        WebElement sendButton = driver.findElement(By.cssSelector("div[data-tooltip='Send']"));
 	        sendButton.click();
 	    }

 	    // Method to click the latest email or refresh the inbox
 	    public void clickLatestOrRefresh() {
 	        // Try to find the latest email
 	        WebElement latestEmail = driver.findElement(By.cssSelector("div.T-I.T-I-KE.L3"));

 	        if (latestEmail != null) {
 	            latestEmail.click();
 	        } else {
 	            // If the latest email is not found, refresh the inbox
 	            WebElement refreshButton = driver.findElement(By.cssSelector(".asa"));
 	            refreshButton.click();
 	        }
 	        
 	        // Once the mail is found, open the mail
 	        // Assuming you can open the mail by clicking a link or button in the email body
 	        // You would need to identify the specific element to click
 	        WebElement openMailButton = driver.findElement(By.cssSelector("a.link-in-email"));
 	        openMailButton.click();

 	        // Close the browser
 	        driver.quit();
 	    }
 	}
}