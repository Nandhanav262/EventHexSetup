package ticket; 
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 
public class Ticket extends Base 
{ 
	public void loginCredentials() 
 { 
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open Login Page
        driver.get("https://app.eventhex.ai");

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
        emailField.sendKeys("info@eventhex.ai");

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("Admin@EventHex");

        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
        loginBtn.click();

        System.out.println("Logined sucessfully");
        
        // Wait for DashBoard to load
        wait.until(ExpectedConditions.urlContains("https://app.eventhex.ai/event"));
        
        // Go to Event
        driver.get("https://app.eventhex.ai/event/68a7ea82d6b0d81e2fa6402");
        
        //Go to ticket section
        driver.get("https://app.eventhex.ai/event/68a7ea82d6b0d81e2fa6402e/configure/ticket");
        
     // Before clicking
        String originalWindow = driver.getWindowHandle();

        // Click button to open new tab
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@title='Navigate to URL']")));
        link.click();
        System.out.println("Clicked Navigate to URL button");

    

        wait.until(driver -> driver.getWindowHandles().size() > 1);

        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
        	    d -> ((JavascriptExecutor)d).executeScript("return document.readyState").equals("complete")
        	);

       

        // Wait for the page to fully load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Accept All']")));

        System.out.println("Switched to new registration tab");

     // Click Accept All button
        WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[contains(text(),'Accept')]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acceptBtn);

        // Wait until the popup is gone
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
            By.xpath("//button[contains(text(),'Accept')]")
        ));

        System.out.println("Popup accepted and closed.");


        // Enter first name
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Your Name']")));
        firstName.sendKeys("Nandhana");
        System.out.println("Entered first name successfully");
        
     // Enter lastName
        WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']")));
        lastName.sendKeys("V");
        System.out.println("Entered last name successfully");
        
    
        // Enter phone number
        // Click the country code dropdown
        WebElement countryCodeDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@aria-controls='radix-«r1»']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", countryCodeDropdown);
        // Type 91 in the search box
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search options...']")));
        searchBox.sendKeys("91");
        //Select +91 from search results
        WebElement selectIndia = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-value='🇮🇳 India (+91)']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectIndia);
        //enter mobile number
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//input[@placeholder='Mobile Number']"))); 
        phoneField.sendKeys("9746983352");
        System.out.println("Entered mobile number successfully");

        //Enter work e-mail id
        WebElement mail = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Email ID']"))); 
            mail.sendKeys("nandhanav262@gmail.com");
            System.out.println("Entered mail id successfully");
            
          //Enter Designation
            WebElement designation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@placeholder='Designation']"))); 
                designation.sendKeys("test");
                System.out.println("Entered designation successfully");
           
           //Enter Organisation
            WebElement organisation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@placeholder='Organisation']"))); 
            organisation.sendKeys("Obs");
                    System.out.println("Entered Organisation successfully");
                    
           //select country
                 // Click the country dropdown
                    WebElement country = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Please select your country')]")));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", country);
                    // Type india in the search box
                    	WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-slot='command-input-wrapper']//input")));
                    		search.sendKeys("india");

                    //Select india from search results
                    WebElement select = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-value='India']")));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", select);
                    System.out.println("selected country successfully");
                    
           //select industry
                 // Wait for the combobox button (the dropdown trigger)
                    WebElement dropdownBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@role='combobox']//span[contains(text(),'Select...')]")));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdownBtn);

                    WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("radix-«rcv»")));
                    	searchInput.sendKeys("Technology (software");
                    	searchInput.sendKeys(Keys.ENTER);
                    
                    System.out.println("industry option selected successfully!");
             //Register
                   // WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Register Now')]")));
                     //   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", register);
                      //  System.out.println("Registartion successfully!");
             
                 // Close the registration tab
                    String originalWindow1 = driver.getWindowHandle();
                    driver.close();
                    System.out.println("Closed the registration tab");
                    driver.switchTo().window(originalWindow1);
                    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
                    wait1.until(ExpectedConditions.urlContains("/configure/ticket"));
                    System.out.println("Switched back to ticket configuration page");;
          
              //Click form builder button   
                    WebElement formBuilder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='sc-dKKIkQ jvjGPx edit menu callBack button']")));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", formBuilder);
	} 
	

	public static void main(String[] args) 
{ 
	Ticket login=new Ticket(); 
	login.initialize_Browse(); 
	login. loginCredentials(); 
    // login.driver_QuitandClose(); } }
}
}