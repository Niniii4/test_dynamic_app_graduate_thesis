package utils;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssertionsUtil extends BasePage {

    @FindBy(className = "sv_progress-buttons__list-element--current")
    private WebElement newPageProgressButton;

    @FindBy(className = "sv_q_erbox")
    private WebElement alertErrorElement;

    @FindBy(className = "sv_completed_page")
    private WebElement surveyCompletedSuccessfully;

    public AssertionsUtil(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new AssertionsUtil(driver);
    }

    public String assertNewPage() {
        return waitAndCheckSuccessfulPassedPage(newPageProgressButton);
    }

    public Boolean assertErrorMessageShown(String error) {
        return waitAndCheckErrorElementsFromRoot(alertErrorElement, By.className("sv_qstn_error_top")).contains(error);
    }

    public String assertTextOfSurveyCompleted(){
        return waitAndCheckSuccessfullyCompletedSurvey(surveyCompletedSuccessfully);
    }

}
