package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {
    WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    public By nameInputField = By.xpath("//input[contains(@name, \"$WhatIsYourName$\")]");
    public By dateInputField = By.xpath("//input[@ref=\"inputElement\"]");
    public By textArea = By.xpath("//textarea[contains(@name, \"$WhyDidYouJoinTheTestingArea$\")]");
    public By previousMonthButton = By.xpath("//button[@aria-label=\"angle-left\"]");
    public By submitButton = By.xpath("//button[@type=\"submit\"]");
    public By languageSelectButton = By.id("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_kldx___menu");
    public By changeLanguageButton = By.xpath("//li[@role=\"presentation\"]");
    public By feedback = By.className("form-feedback-item");

    //Functions
    public void enterText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }

    public void changeLanguage() {
        driver.findElement(languageSelectButton).click();
        driver.findElement(changeLanguageButton).click();
    }

    public String getCssPropertyValue(By locator, String propertyName) {
        return driver.findElement(locator).getCssValue(propertyName);
    }

    public By getDayInCalendar(int day) {
        return By.xpath("//div[text()=\"" + day + "\"]");
    }
}