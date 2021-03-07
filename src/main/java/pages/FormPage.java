package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {
    WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    public By nameInputField = By.xpath("//input[contains(@name, '$WhatIsYourName$')]");
    public By dateInputField = By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div[1]/input[1]");
    public By textArea = By.xpath("//textarea[contains(@name, '$WhyDidYouJoinTheTestingArea$')]");
    public By dayInCalendar = By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div[2]/div/div[3]/div[3]/div[4]");
    public By previousMonthButton = By.xpath("/html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div/button[1]");
    public By submitButton = By.xpath("//button[@type='submit']");


    //Methods
    public void enterText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }
}