package com.newshub;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.fail;

public interface TestUtils {
    public default boolean waitForElememt(WebDriver driver, String dom) throws InterruptedException {
        boolean found = false;
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(driver,By.id("dashboard-admin-dashboard-link"))) {
                    found = true;
                    break;
                }
            } catch (Exception e) {}
            Thread.sleep(1000);
        }
        return found;
    }

    public default boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
