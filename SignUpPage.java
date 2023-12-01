package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Page Object Model representing SignUp Page
 */
public class SignUpPage {

	private WebDriver driver;

	    public SignUpPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void clickSignUpLink() {
	        WebElement signUpLink = driver.findElement(By.linkText("Sign up"));
	        signUpLink.click();
	    }

	    public void enterEmail(String email) {
	        WebElement emailInput = driver.findElement(By.id("id_email"));
	        emailInput.sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        WebElement passwordInput1 = driver.findElement(By.id("id_password1"));
	        passwordInput1.sendKeys(password);
	    }

	    public void confirmPassword(String password) {
	        WebElement passwordInput2 = driver.findElement(By.id("id_password2"));
	        passwordInput2.sendKeys(password);
	    }

	    public void clickSubmitButton() {
	        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
	        submitButton.click();
	    }

	    public String getSecondH1Text() {
	        WebElement secondH1 = driver.findElements(By.tagName("h1")).get(1);
	        return secondH1.getText();
	    }

		class VerificationPage {

			private WebDriver driver;

			public VerificationPage(WebDriver driver) {
				this.driver = driver;
			}

			public String getConfirmationMessage() {
				WebElement confirmationMessage = driver.findElement(By.id("confirmationMessage"));
				return confirmationMessage.getText();
			}
		}
		
class GmailTest {
	
	private ChromeDriver driver;

	public GmailTest(ChromeDriver driver) {
		this.driver = driver;
	}

	
		public void enterMail(String email) {
	        WebElement emailInput = driver.findElement(By.id("identifierId"));
	        emailInput.sendKeys(email);
	    }
	    
	    public void clickNext() {
	        WebElement nextButton = driver.findElement(By.xpath("//span[contains(text(), 'Next')]"));
	        nextButton.click();
	    }
	    public void enterPasswd(String password) {
	        WebElement passwordInput = driver.findElement(By.name("Passwd"));
	        passwordInput.sendKeys(password);
	    }

	    public void clickSignUpButton() {
	        WebElement signUpButton = driver.findElement(By.xpath("//span[contains(text(), 'Next')]"));
	        signUpButton.click();
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
	            WebElement latestEmail = driver.findElement(By.id(":l1"));
	            

	            if (latestEmail != null) {
	                latestEmail.click();
	            } else {
	                // If the latest email is not found, refresh the inbox
	                WebElement refreshButton = driver.findElement(By.cssSelector("[aria-label='Refresh']"));
	                refreshButton.click();
	            }
	        }
		
		}
}