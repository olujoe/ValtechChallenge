package com.valtech.gui.scenarios;

import com.valtech.TestSetup;
import com.valtech.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public interface BaseTestScenario extends TestUtils {

    public default void i_open_browser_to_valtech() throws Throwable {
        TestSetup.setUpTest();
        System.out.println("Opening webpageItem to http://"+TestSetup.getHost());
        getDriver().get("http://"+TestSetup.getHost());
    }

    public default void i_should_see(String pageItem) throws Throwable {
        System.out.print("\r\n" + "The string I should see is " + pageItem);
        if (pageItem.equals("NewsHub")) {
            WebElement headerElement = getDriver().findElement(By.id("wrapper"));
            if (headerElement != null) {
                System.out.println("\r\n" + "I have found " + headerElement.getText());
            } else {
                System.out.println("\r\n" + "I can't find dom");
            }
        } else {
            System.out.print("\r\n" + "I am searching for " + pageItem.toLowerCase());
            Boolean pageItemElement = getDriver().getpageSource().contains(pageItem);
            System.out.println("\r\n" + "I have found " + pageItem);
            if (pageItemElement != null) {
                System.out.println("\r\n" + "I have found " + pageItemElement.getText());
            } else {
                System.out.println("\r\n" + "I can't find dom");
            }
        }
    }



    public default void i_click_on(String arg1) throws Throwable {
        System.out.print("\r\n"+"I am now going to click on "+ arg1);
        getDriver().findElement(By.linkText(arg1)).click();
        System.out.print("\r\n"+"I just clicked "+ arg1);
        assertTrue(true);

    }

    public WebDriver getDriver();
}
