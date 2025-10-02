package ticket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
		WebDriver driver;
		
		public void initialize_Browse()
		{
		driver= new ChromeDriver();//loading the driver
		driver.get("https://app.eventhex.ai");
		driver.manage().window().maximize();

		}
		public void driver_QuitandClose()
		{
			//driver.close();
			//driver.quit();
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Base base =new Base();
	        base.initialize_Browse();
	}
	}