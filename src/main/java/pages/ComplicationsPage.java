package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import java.util.List;

public class ComplicationsPage extends BasePage {

    @FindBy(css = "#clinical_course_complications_panel > div:nth-child(2) > div > table > tbody > tr:nth-child(1)")
    private WebElement hospitalizationRow;

    @FindBy(css = "#clinical_course_complications_panel > div:nth-child(2) > div > table > tbody > tr:nth-child(2)")
    private WebElement icuRow;

    @FindBy(css = "#clinical_course_complications_panel > div:nth-child(2) > div > table > tbody > tr:nth-child(3)")
    private WebElement ardsRow;

    @FindBy(css = "#clinical_course_complications_panel > div:nth-child(2) > div > table > tbody > tr:nth-child(4)")
    private WebElement pneumoniaRow;

    @FindBy(css = "#clinical_course_complications_panel > div:nth-child(2) > div > table > tbody > tr:nth-child(5)")
    private WebElement ventilationRow;

    @FindBy(css = "#clinical_course_complications_panel > div:nth-child(2) > div > table > tbody > tr:nth-child(6)")
    private WebElement emoRow;

    public ComplicationsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new ComplicationsPage(driver);
    }

    public ComplicationsPage hospitalizationRequired(String text) {
        clickRadioButtonContainingTextFromRootElement(hospitalizationRow, text);
        return this;
    }

    public ComplicationsPage icuRequired(String text) {
        clickRadioButtonContainingTextFromRootElement(icuRow, text);
        return this;
    }

    public ComplicationsPage ardsRequired(String text) {
        clickRadioButtonContainingTextFromRootElement(ardsRow, text);
        return this;
    }

    public ComplicationsPage pneumoniaRequired(String text) {
        clickRadioButtonContainingTextFromRootElement(pneumoniaRow, text);
        return this;
    }

    public ComplicationsPage ventilationRequired(String text) {
        clickRadioButtonContainingTextFromRootElement(ventilationRow, text);
        return this;
    }

    public ComplicationsPage emoRequired(String text) {
        clickRadioButtonContainingTextFromRootElement(emoRow, text);
        return this;
    }

    public ComplicationsPage hospitalizationNameOfHospital(String text) {
        insertNameOfHospitalFromRootElement(hospitalizationRow, text);
        return this;
    }

    public ComplicationsPage icuNameOfHospital(String text) {
        insertNameOfHospitalFromRootElement(icuRow, text);
        return this;
    }

    public ComplicationsPage ardsNameOfHospital(String text) {
        insertNameOfHospitalFromRootElement(ardsRow, text);
        return this;
    }

    public ComplicationsPage pneumoniaNameOfHospital(String text) {
        insertNameOfHospitalFromRootElement(pneumoniaRow, text);
        return this;
    }

    public ComplicationsPage ventilationNameOfHospital(String text) {
        insertNameOfHospitalFromRootElement(ventilationRow, text);
        return this;
    }

    public ComplicationsPage emoNameOfHospital(String text) {
        insertNameOfHospitalFromRootElement(emoRow, text);
        return this;
    }

    public ComplicationsPage hospitalizationHealthRate(String text) {
        chooseHealthRateFromRootElement(hospitalizationRow, text);
        return this;
    }

    public ComplicationsPage icuHealthRate(String text) {
        chooseHealthRateFromRootElement(icuRow, text);
        return this;
    }

    public ComplicationsPage ardsHealthRate(String text) {
        chooseHealthRateFromRootElement(ardsRow, text);
        return this;
    }

    public ComplicationsPage pneumoniaHealthRate(String text) {
        chooseHealthRateFromRootElement(pneumoniaRow, text);
        return this;
    }

    public ComplicationsPage ventilationHealthRate(String text) {
        chooseHealthRateFromRootElement(ventilationRow, text);
        return this;
    }

    public ComplicationsPage emoHealthRate(String text) {
        chooseHealthRateFromRootElement(emoRow, text);
        return this;
    }

    protected void insertNameOfHospitalFromRootElement(WebElement rootElement, String text) {
        List<WebElement> webElements = rootElement.findElements(By.id("id_input_name_of_hospital"));
        for (WebElement webElement : webElements) {
            if (webElement.getText().isEmpty()) {
                clearAndSendKeys(webElement, text);
            }
        }
    }

    protected void chooseHealthRateFromRootElement(WebElement rootElement, String text) {
        List<WebElement> webElements = rootElement.findElements(By.className("sv_q_dropdown_control"));
        for (WebElement webElement : webElements) {
            chooseFromDDOptionsContainingText(webElement, text);
        }
    }
}
