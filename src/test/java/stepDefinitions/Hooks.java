package stepDefinitions;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.configReader;

public class Hooks {

	
	  @Before
	    public void setup() {
	        configReader.loadProperties();
	        String browser = configReader.getProperty("browser");

	        if (browser.equalsIgnoreCase("chrome")) {
	           // BaseClass.driver = new ChromeDriver();
	            ChromeOptions options = new ChromeOptions();
	            //options.addArguments("--headless");
	            BaseClass.driver = new ChromeDriver(options);
	           //driver = new ChromeDriver(options);
	            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT)
	            
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            BaseClass.driver = new FirefoxDriver();
	        } else {
	            throw new RuntimeException("Browser not supported: " + browser);
	        }

	        BaseClass.driver.manage().window().maximize();
	        BaseClass.driver.get(configReader.getProperty("url"));

	        // Initialize page objects
	        BaseClass.lp = new pageObjects.LoginPage(BaseClass.driver);
	        BaseClass.addProduct = new pageObjects.AddProduct(BaseClass.driver);
	        BaseClass.cartCheckout = new pageObjects.CartCheckOut(BaseClass.driver);
	    }

	    @After
	    public void tearDown() {
	        if (BaseClass.driver != null) {
	            BaseClass.driver.quit();
	        }
	    }
	}

