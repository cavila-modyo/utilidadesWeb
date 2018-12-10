package com.tresit.automation.utilidad.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebSelector {

    static WebDriver driver = null;

    public static WebDriver ChomeBrowser(String url){

        // Predefinir carpeta de descarga  (SERA UNA MEJORA)
        //String downloadFilepath = carpetaDescarga;
        //Map<String, Object> preferences = new Hashtable<String, Object>();
        //preferences.put("profile.default_content_settings.popups", 0);
        //preferences.put("download.default_directory", downloadFilepath);
        //ChromeOptions options = new ChromeOptions();
        //options.setExperimentalOption("prefs", preferences);

        System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }

    public static WebDriver EdgeBrowser(String url){

        // Predefinir carpeta de descarga  (SERA UNA MEJORA)
        //String downloadFilepath = carpetaDescarga;
        //Map<String, Object> preferences = new Hashtable<String, Object>();
        //preferences.put("profile.default_content_settings.popups", 0);
        //preferences.put("download.default_directory", downloadFilepath);
        //EdgeOptions options = new EdgeOptions();
        //options.setExperimentalOption("prefs", preferences);
        //options.setCapability("","");

        System.setProperty("webdriver.edge.driver", "C://Selenium//MicrosoftWebDriver.exe");
        EdgeDriver driver = new EdgeDriver();
        driver.get(url);
        return driver;

    }

    public static WebDriver MozilaBrowser(String url){

        // Predefinir carpeta de descarga  (SERA UNA MEJORA)
        //FirefoxProfile profile = new FirefoxProfile();
        //profile.setPreference("browser.download.folderList", 2);
        //profile.setPreference("browser.download.dir", carpetaDescarga);   // System.getProperty("user.dir")
        //FirefoxOptions option = new FirefoxOptions();
        //option.setProfile(profile);

        System.setProperty("webdriver.gecko.driver", "C://Selenium//geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get(url);
        return driver;
    }

    /*
    public static void main(String[] args) {
        //ChomeBrowser("http://qa.cajachile.3it.corp");
        //EdgeBrowser("http://qa.cajachile.3it.corp");
        //MozilaBrowser("http://qa.cajachile.3it.corp");
    }
*/


}
