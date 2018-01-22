package com.valtech.gui.scenarios;

import com.valtech.TestSetup;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

/**
 * Create by olu.ogunbusola on 21/01/2018
 */

public class FirstScenario extends TestSetup implements BaseTestScenario {

    WebDriver driver;
    public FirstScenario() {
        setUpTest();
    }

    @Given("^I navigate to valtec")
    public void iOpenBrowserToValtech() throws Throwable {
        i_open_browser_to_valtech();
    }


    @Then("^I should see \"(.*?)\"$")
    public void iShoudSee(String pageItem) throws Throwable {
        i_should_see(pageItem);
    }

    @When("^I click on \"(.*?)\"$")
    public void iClickOn(String pageItem) throws Throwable {
        i_click_on(pageItem);
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Before
    public void startUp(){
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
