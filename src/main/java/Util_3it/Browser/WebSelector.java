package Util_3it.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebSelector {

    static WebDriver driver = null;

    public static WebDriver ChomeBrowser(String url){

        System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);  //driver.navigate().to("http://www.google.com");

        return driver;
    }

    public static WebDriver EdgeBrowser(String url){

        System.setProperty("webdriver.edge.driver", "C://Selenium//MicrosoftWebDriver.exe");
        driver = new EdgeDriver();
        driver.get(url);
        return driver;

    }

    public static WebDriver MozilaBrowser(String url){

        System.setProperty("webdriver.gecko.driver", "C://Selenium//geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
        return driver;
    }

    /*
    public static void main(String[] args) {
        //ChomeBrowser("http://qa.cajachile.3it.corp");
        //EdgeBrowser("http://qa.cajachile.3it.corp");
        MozilaBrowser("http://qa.cajachile.3it.corp");
    }
*/


}
