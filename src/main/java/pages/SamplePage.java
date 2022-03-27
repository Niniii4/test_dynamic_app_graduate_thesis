package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import static enums.PresentDateEnum.PRESENT_DATE;
import static java.util.Objects.isNull;

public class SamplePage extends BasePage {

    @FindBy(id = "id_input_date_respiratory_sample_collected")
    private WebElement inputDate;

    @FindBy(id = "what_type_of_respiratory_sample_was_collected")
    private WebElement typeOfRespiratorySampleCollected;

    @FindBy(id = "were_other_samples_collected_radio")
    private WebElement otherSamplesCollected;

    @FindBy(id = "id_input_specify")
    private WebElement specifyOtherTypeRespiratorySample;

    @FindBy(id = "id_input_which_samples")
    private WebElement specifyWhichOtherSample;

    @FindBy(id = "id_input_date_taken")
    private WebElement dateTakenSample;

    public SamplePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new SamplePage(driver);
    }


    public SamplePage insertDateOfSampleCollected(String date) {
        if (date.equals(PRESENT_DATE.toString())) {
            waitAndSendPresentDateOnCalendar(inputDate);
        } else {
            clearAndSendKeys(inputDate, date);
        }
        return this;
    }

    public SamplePage selectTypeOfRespiratorySample(String text) {
        if (!isNull(text)) {
            clickRadioButtonContainingTextFromRootElement(typeOfRespiratorySampleCollected, text);
        }
        return this;
    }

    public SamplePage selectIfOtherSamplesCollected(String text) {
        if (!isNull(text)) {
            clickRadioButtonContainingTextFromRootElement(otherSamplesCollected, text);
        }
        return this;
    }

    public SamplePage insertOtherTypeOfRespiratorySample(String specifyTypeRespiratorySample) {
        clearAndSendKeys(specifyOtherTypeRespiratorySample, specifyTypeRespiratorySample);
        return this;
    }

    public SamplePage insertOtherSpecifiedSample(String specifyOtherSample) {
        clearAndSendKeys(specifyWhichOtherSample, specifyOtherSample);
        return this;
    }

    public SamplePage insertDateTaken(String date) {
        if (date.equals(PRESENT_DATE.toString())) {
            waitAndSendPresentDateOnCalendar(dateTakenSample);
        } else {
            clearAndSendKeys(dateTakenSample, date);
        }
        return this;
    }

}
