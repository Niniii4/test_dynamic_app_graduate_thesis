package pages;

import static enums.PresentDateEnum.PRESENT_DATE;

import com.epam.healenium.SelfHealingDriver;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class CollectorPage extends BasePage {

    @FindBy(id = "id_input_unique_case_number_id__cluster_number_if_applicable")
    private WebElement inputId;

    @FindBy(id = "id_input_name_of_data_collector")
    private WebElement inputName;

    @FindBy(id = "id_input_data_collector_institution")
    private WebElement inputInstitution;

    @FindBy(id = "id_input_data_collector_telephone_number")
    private WebElement inputTelephone;

    @FindBy(id = "id_input_email")
    private WebElement inputEmail;

    @FindBy(id = "id_input_date_of_form_completion_")
    private WebElement inputDate;

    @FindBy(tagName = "canvas")
    private WebElement inputSignature;

    @FindBy(className = "sjs_sp_clear")
    private WebElement clearSignatureButton;

    public CollectorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new CollectorPage(driver);
    }

    public CollectorPage insertUniqueCaseId(String id) {
        clearAndSendKeys(inputId, id);
        return this;
    }

    public CollectorPage insertCollectorName(String name) {
        clearAndSendKeys(inputName, name);
        return this;
    }

    public CollectorPage insertCollectorInstitution(String institution) {
        clearAndSendKeys(inputInstitution, institution);
        return this;
    }

    public CollectorPage insertCollectorTelephone(String telephone) {
        clearAndSendKeys(inputTelephone, telephone);
        return this;
    }

    public CollectorPage insertCollectorEmail(String email) {
        clearAndSendKeys(inputEmail, email);
        return this;
    }

    public CollectorPage insertCompletionDate(String date) {
        if (date.equals(PRESENT_DATE.toString())) {
            waitAndSendPresentDateOnCalendar(inputDate);
        } else {
            clearAndSendKeys(inputDate, date);
        }
        return this;
    }

    public CollectorPage insertSignature(List<Integer> xCoordinates, List<Integer> yCoordinates) {
        if (xCoordinates != null && yCoordinates != null) {
            waitAndInsertSignature(inputSignature, xCoordinates, yCoordinates);
        }
        return this;
    }

    public CollectorPage clearSignature() {
        waitForElementToBeClickableAndClick(clearSignatureButton);
        return this;
    }

}
