package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class DriverSetUp {

    public static String browserName= System.getProperty("browser","chrome");
      private  static final ThreadLocal<WebDriver> local_Browser=new ThreadLocal<>();

    public static WebDriver getBrowser() {
        return local_Browser.get();
    }

    public static void setBrowser(WebDriver browser) {
      DriverSetUp.local_Browser.set(browser);
    }

public WebDriver getBrowser(String browserName){
      if (browserName.equalsIgnoreCase("chrome"))
          return new ChromeDriver();
      else if (browserName.equalsIgnoreCase("firefox"))
          return new FirefoxDriver();
      else if (browserName.equalsIgnoreCase("edge"))
          return new EdgeDriver();
      else {
          throw new RuntimeException("use another browser ");
      }

}
    @BeforeSuite
    public void openBrowser(){

        WebDriver browser = getBrowser(browserName);
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        setBrowser(browser);
    }

    @AfterSuite
    public void quiteBrowser(){
        getBrowser().quit();
    }

}
