package com.valtech;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by olu.ogunbusola on 05/01/2018.
 */
public class TestSetup {
    protected static String OS = System.getProperty("os.name").toLowerCase();
    private static String host = com.valtech.TestConstants.HOST;
    protected WebDriver driver = WEB_DRIVER_THREAD_LOCAL.get();

    public static void setUpTest(){
        if(isMac()) {
            System.setProperty("webdriver.chrome.driver", "./drivers/mac/chromedriver");
            System.setProperty("webdriver.gecko.driver", "./drivers/mac/geckodriver");
        }else if(isWindows()){
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
            System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.13.0-win32\\geckodriver.exe");
        }
    }

    private static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }
    private static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }
    public static String getHost() {
        return host;
    }
    public WebDriver getDriver() {
        return driver;
    }
    private static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }
    private boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }
    protected void debug(String msg,Class clazz){
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.debug(msg);
    }

    public static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL =
            new ThreadLocal<WebDriver>() {
            @Override
                protected WebDriver initialValue() {
                    return new ChromeDriver();
                }
    };
}
