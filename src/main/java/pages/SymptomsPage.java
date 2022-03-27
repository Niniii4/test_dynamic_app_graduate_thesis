package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import java.util.List;

import static java.util.Objects.isNull;

public class SymptomsPage extends BasePage {

    @FindBy(id = "fever")
    private WebElement feverRating;

    @FindBy(id = "throat")
    private WebElement throatRating;

    @FindBy(id = "nose")
    private WebElement noseRating;

    @FindBy(id = "cough")
    private WebElement coughRating;

    @FindBy(id = "breath")
    private WebElement breathingRating;

    @FindBy(id = "vomiting")
    private WebElement vomitingRating;

    @FindBy(id = "nausea")
    private WebElement nauseaRating;

    @FindBy(id = "diarrhea")
    private WebElement diarrheaRating;

    @FindBy(id = "backache")
    private WebElement backacheRating;

    @FindBy(id = "id_input_date_of_first_symptom_onset")
    private WebElement inputDate;

    @FindBy(id = "sq_354i_0")
    private WebElement noSymptomsCheckbox;

    @FindBy(id = "sq_354i_1")
    private WebElement unknownSymptomsCheckbox;

    public SymptomsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new SymptomsPage(driver);
    }

    public SymptomsPage rateFeverSymptoms(String rate) {
        if (!isNull(rate)) {
            chooseRatingFromRootElement(feverRating, rate);
        }
        return this;
    }

    public SymptomsPage rateSoreThroatSymptoms(String rate) {
        if (!isNull(rate)) {
            chooseRatingFromRootElement(throatRating, rate);
        }
        return this;
    }

    public SymptomsPage rateRunnyNoseSymptoms(String rate) {
        if (!isNull(rate)) {
            chooseRatingFromRootElement(noseRating, rate);
        }
        return this;
    }

    public SymptomsPage rateCoughSymptoms(String rate) {
        if (!isNull(rate)) {
            chooseRatingFromRootElement(coughRating, rate);
        }
        return this;
    }

    public SymptomsPage rateBreathingSymptoms(String rate) {
        if (!isNull(rate)) {
            chooseRatingFromRootElement(breathingRating, rate);
        }
        return this;
    }

    public SymptomsPage rateVomitingSymptoms(String rate) {
        if (!isNull(rate)) {
            chooseRatingFromRootElement(vomitingRating, rate);
        }
        return this;
    }

    public SymptomsPage rateNauseaSymptoms(String rate) {
        if (!isNull(rate)) {
            chooseRatingFromRootElement(nauseaRating, rate);
        }
        return this;
    }

    public SymptomsPage rateDiarrheaSymptoms(String rate) {
        if (!isNull(rate)) {
            chooseRatingFromRootElement(diarrheaRating, rate);
        }
        return this;
    }

    public SymptomsPage rateBackAcheSymptoms(String rate) {
        if (!isNull(rate)) {
            chooseRatingFromRootElement(backacheRating, rate);
        }
        return this;
    }

    public SymptomsPage insertFirstSymptomsDate(String date) {
        if (!isNull(date)) {
            clearAndSendKeys(inputDate, date);
        }
        return this;
    }

    public SymptomsPage checkNoSymptomsCheckbox() {
        waitForElementToBeClickableAndClick(noSymptomsCheckbox);
        return this;
    }

    public SymptomsPage checkUnknownSymptomsCheckbox() {
        waitForElementToBeClickableAndClick(unknownSymptomsCheckbox);
        return this;
    }

    public SymptomsPage isDateDisabled() {
        waitAndFindElement(By.cssSelector("input#id_input_date_of_first_symptom_onset[disabled]"));
        return this;
    }

    public SymptomsPage isNoSymptomsDisabled() {
        waitAndFindElement(By.cssSelector("input#sq_354i_0[disabled]"));
        return this;
    }

    public SymptomsPage isUnknownSymptomsDisabled() {
        waitAndFindElement(By.cssSelector("input#sq_354i_1[disabled]"));
        return this;
    }

    protected void chooseRatingFromRootElement(WebElement rootElement, String text) {
        List<WebElement> webElements = rootElement.findElements(By.className("sv_q_rating_item"));
        for (WebElement webElement : webElements) {
            if (webElement.getText().contains(text)) {
                waitForElementToBeClickableAndClick(webElement);
            }
        }
    }

}
