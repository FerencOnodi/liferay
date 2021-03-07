package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import pages.FormPage;
import pages.SuccessPage;

public class Tests {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programming\\Selenium\\chromeDriver\\chromeDriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testCase9() {
        FormPage formPage = new FormPage(driver);
        driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
        formPage.clickOnElement(formPage.nameInputField);
        formPage.clickOnElement(formPage.dateInputField);
        formPage.clickOnElement(formPage.textArea);
        Assert.assertEquals("This field is required.", formPage.getValue(formPage.feedbackForName));
        Assert.assertEquals("This field is required.", formPage.getValue(formPage.feedbackForDate));
        formPage.clickOnElement(formPage.nameInputField);
        Assert.assertEquals("This field is required.", formPage.getValue(formPage.feedbackForTextArea));
        Assert.assertEquals("#f48989", Color.fromString(formPage.getCssPropertyValue(formPage.feedbackForName, "border-color")).asHex());
        Assert.assertEquals("#feefef", Color.fromString(formPage.getCssPropertyValue(formPage.feedbackForName, "background-color")).asHex());
    }

    @Test
    public void testCase14() throws InterruptedException {
        //Fill out input fields and click on Submit button
        FormPage formPage = new FormPage(driver);
        driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
        formPage.enterText(formPage.nameInputField, "Test Name");
        Thread.sleep(1000);
        formPage.clickOnElement(formPage.dateInputField);
        formPage.clickOnElement(formPage.previousMonthButton);
        formPage.clickOnElement(formPage.previousMonthButton);
        formPage.clickOnElement(formPage.dayInCalendar);
        Thread.sleep(1000);
        formPage.enterText(formPage.textArea, "Test reason");
        Thread.sleep(1000);
        formPage.clickOnElement(formPage.submitButton);
        Thread.sleep(1000);

        //Check information page contents
        SuccessPage successPage = new SuccessPage(driver);
        Assert.assertEquals("Information sent",  successPage.getValueOfH1Element());
        Assert.assertEquals("Information sent successfully!",  successPage.getValueOfH5Element());
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
