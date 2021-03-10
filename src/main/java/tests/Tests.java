package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FormPage;
import pages.SuccessPage;

import java.util.List;

public class Tests {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testCase9() {
        FormPage formPage = new FormPage(driver);
        driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
        formPage.clickOnElement(formPage.nameInputField);
        formPage.clickOnElement(formPage.dateInputField);
        formPage.clickOnElement(formPage.textArea);
        formPage.clickOnElement(formPage.nameInputField);
        List<WebElement> feedbackList = driver.findElements(formPage.feedback);
        Assert.assertEquals(3, feedbackList.size());
        for (WebElement element : feedbackList) {
            Assert.assertEquals("This field is required.", element.getText());
        }
        Assert.assertEquals("#f48989", Color.fromString(formPage.getCssPropertyValue(formPage.nameInputField, "border-color")).asHex());
        Assert.assertEquals("#feefef", Color.fromString(formPage.getCssPropertyValue(formPage.nameInputField, "background-color")).asHex());

    }

    @Test
    //Automated test for interview
    public void testCase14() throws InterruptedException {
        //Fill out input fields and click on Submit button
        FormPage formPage = new FormPage(driver);
        driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
        formPage.enterText(formPage.nameInputField, "Test Name");
        Thread.sleep(500);
        formPage.clickOnElement(formPage.dateInputField);
        formPage.clickOnElement(formPage.previousMonthButton);
        formPage.clickOnElement(formPage.previousMonthButton);
        formPage.clickOnElement(formPage.getDayInCalendar(15));
        Thread.sleep(500);
        formPage.enterText(formPage.textArea, "Test reason");
        Thread.sleep(500);
        formPage.clickOnElement(formPage.submitButton);

        //Check information page contents
        SuccessPage successPage = new SuccessPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successPage.getElementByText("Information sent")));
        Assert.assertEquals("Information sent",  successPage.getValueOfH1Element());
        Assert.assertEquals("Information sent successfully!",  successPage.getValueOfH5Element());
    }

    @Test
    //Automated test for interview
    public void testCase15() throws InterruptedException {
        //Fill out input fields and click on Submit button
        FormPage formPage = new FormPage(driver);
        driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
        formPage.changeLanguage();
        Thread.sleep(500);
        formPage.enterText(formPage.nameInputField, "El catos negro");
        Thread.sleep(500);
        formPage.clickOnElement(formPage.dateInputField);
        formPage.clickOnElement(formPage.previousMonthButton);
        formPage.clickOnElement(formPage.previousMonthButton);
        formPage.clickOnElement(formPage.getDayInCalendar(13));
        Thread.sleep(500);
        formPage.enterText(formPage.textArea, "Sí, mucho grande!");
        Thread.sleep(500);
        formPage.clickOnElement(formPage.submitButton);

        //Check information page contents
        SuccessPage successPage = new SuccessPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successPage.getElementByText("Informações enviadas")));
        Assert.assertEquals("Informações enviadas", successPage.getValueOfH1Element());
        Assert.assertEquals("Informações enviadas com sucesso!", successPage.getValueOfH5Element());
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
