package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By trggerAlertButton = By.xpath(".//button[text()='Click for JS Alert']");
    private By results = By.id("result");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");


    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerAlert(){
        driver.findElement(trggerAlertButton).click();
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }

    public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }

    public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public void alert_clickToDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public String getResult(){
        return driver.findElement(results).getText();
    }

}
