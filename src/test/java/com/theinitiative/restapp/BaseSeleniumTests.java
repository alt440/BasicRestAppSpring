package com.theinitiative.restapp;

import java.io.File;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseSeleniumTests {
    private static final String CHROMEDRIVER_EXE = "chromedriver.exe";
    private static final String CHROMEDRIVER = "chromedriver";
    private static final String CHROMEDRIVER_MAC = "chromedriverMac";
    protected WebDriver driver;

    @BeforeEach
    public void setUp(){
        String driverFile = findFile();
        ChromeDriverService service = 
            new ChromeDriverService.Builder()
                                   .usingDriverExecutable(new File(driverFile)).build();
                                   System.out.println(service.getUrl());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("start-maximized"); //takes full size screen
        this.driver = new ChromeDriver(service, options);
    }

    private String findFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        String OS = System.getProperty("os.name").toLowerCase();
        URL url;
        if(isWindows(OS)){
            url = classLoader.getResource(CHROMEDRIVER_EXE);
        } else if(isUnix(OS)){
            url = classLoader.getResource(CHROMEDRIVER);
        } else if(isMac(OS)){
            url = classLoader.getResource(CHROMEDRIVER_MAC);
        } else{
            throw new UnsupportedCommandException("The OS has not been recognized and has no driver");
        }
        
        return url.getFile();
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    private boolean isUnix(String OS) {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }

    private boolean isWindows(String OS) {
        return OS.contains("win");
    }
 
    private boolean isMac(String OS) {
        return OS.contains("mac");
    }
}
