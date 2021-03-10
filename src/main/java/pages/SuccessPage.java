package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage {
    WebDriver driver;

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    //Functions
    public String getValueOfH1Element() {
        return driver.findElement(By.xpath("//h1[@class='ddm-form-name']")).getText();
    }

    public String getValueOfH5Element() {
        return driver.findElement(By.xpath("//h5[@class='ddm-form-description']")).getText();
    }

    public By getElementByText(String text) {
        return By.xpath("//h1[text()=\"" + text + "\"]");
    }
}
