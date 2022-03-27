package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressBar extends BasePage {

    @FindBy(id = "pb_collector")
    private WebElement collectorProgressButton;

    @FindBy(id = "pb_person")
    private WebElement personProgressButton;

    @FindBy(id = "pb_symptoms")
    private WebElement symptomsProgressButton;

    @FindBy(id = "pb_sample")
    private WebElement sampleProgressButton;

    @FindBy(id = "pb_complications")
    private WebElement complicationsProgressButton;

    @FindBy(id = "pb_exposures")
    private WebElement exposuresProgressButton;

    @FindBy(id = "pb_completion")
    private WebElement completionProgressButton;

    public ProgressBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new ProgressBar(driver);
    }

    public void clickProgressBarButtonCollector() {
        waitForElementToBeClickableAndClick(collectorProgressButton);
    }

    public void clickProgressBarButtonPerson() {
        waitForElementToBeClickableAndClick(personProgressButton);
    }

    public void clickProgressBarButtonSymptoms() {
        waitForElementToBeClickableAndClick(symptomsProgressButton);
    }

    public void clickProgressBarButtonSample() {
        waitForElementToBeClickableAndClick(sampleProgressButton);
    }

    public void clickProgressBarButtonComplications() {
        waitForElementToBeClickableAndClick(complicationsProgressButton);
    }

    public void clickProgressBarButtonExposures() {
        waitForElementToBeClickableAndClick(exposuresProgressButton);
    }

    public void clickProgressBarButtonCompletion() {
        waitForElementToBeClickableAndClick(completionProgressButton);
    }
}
