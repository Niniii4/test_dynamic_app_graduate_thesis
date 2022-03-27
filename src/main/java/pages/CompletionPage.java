package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class CompletionPage extends BasePage {

    @FindBy(id = "id_input_how_much_time_minutes_did_you_need_to_complete_the_survey")
    private WebElement inputTime;

    @FindBy(className = "sv_complete_btn")
    private WebElement completeButton;

    public CompletionPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new CompletionPage(driver);
    }

    public CompletionPage insertTimeNeededToCompleteSurvey(String time) {
        clearAndSendKeys(inputTime, time);
        return this;
    }

    public void clickComplete() {
        waitForElementToBeClickableAndClick(completeButton);
    }

}
