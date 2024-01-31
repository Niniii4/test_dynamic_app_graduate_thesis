package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class PersonPage extends BasePage {

    @FindBy(id = "sq_184i_0")
    WebElement selectPatientAnswerTrue;

    @FindBy(id = "sq_184i_1")
    WebElement selectPatientAnswerFalse;

    @FindBy(id = "id_input_first_name_of_respondent")
    private WebElement inputRespondentFirstName;

    @FindBy(id = "id_input_last_name_of_respondent")
    private WebElement inputRespondentLastName;

    @FindBy(className = "sv_q_dropdown_control")
    private WebElement chooseRespondentRelationshipToPatient;

    @FindBy(id = "id_input_respondent_address")
    private WebElement inputRespondentAddress;

    @FindBy(id = "id_input_telephone_mobile_number")
    private WebElement inputRespondentTelephoneNumber;

    @FindBy(id = "id_input_first_name")
    private WebElement inputPatientFirstName;

    @FindBy(id = "id_input_last_name")
    private WebElement inputPatientLastName;

    @FindBy(id = "id_input_national_social_number__identifier")
    private WebElement inputPatientSocialNumber;

    @FindBy(className = "sv_q_dropdown_control")
    private WebElement choosePatientCountryOfResidence;

    @FindBy(id = "id_input_date_of_birth")
    private WebElement inputPatientBirthDate;

    @FindBy(id = "id_input_age")
    private WebElement inputPatientAge;

    @FindBy(id = "id_input_email")
    private WebElement inputPatientEmail;

    @FindBy(id = "id_input_address")
    private WebElement inputPatientAddress;

    @FindBy(id = "id_input_telephone_mobile_number")
    private WebElement inputPatientTelephoneNumber;

    @FindBy(id = "case_identifier_information_sex")
    private WebElement radioButtonPresentationPatientSex;

    @FindBy(id = "case_identifier_information_patient_case_status")
    private WebElement radioButtonPresentationPatientCaseStatus;

    public PersonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new PersonPage(driver);
    }

    public PersonPage selectIsPatientProvidingInformation(boolean selectAnswer) {
        if (selectAnswer) {
            waitForElementToBeClickableAndClick(selectPatientAnswerTrue);
        } else {
            waitForElementToBeClickableAndClick(selectPatientAnswerFalse);
        }
        return this;
    }

    public PersonPage insertRespondentFirstName(String name) {
        clearAndSendKeys(inputRespondentFirstName, name);
        return this;
    }

    public PersonPage insertRespondentLastName(String lastName) {
        clearAndSendKeys(inputRespondentLastName, lastName);
        return this;
    }

    public PersonPage chooseRespondentRelationshipToPatient(String respondentRelationshipChoice) {
        chooseFromDDOptionsContainingText(chooseRespondentRelationshipToPatient, respondentRelationshipChoice);
        return this;
    }

    public PersonPage insertRespondentAddress(String address) {
        clearAndSendKeys(inputRespondentAddress, address);
        return this;
    }

    public PersonPage insertRespondentTelephoneNumber(String telephoneNumber) {
        clearAndSendKeys(inputRespondentTelephoneNumber, telephoneNumber);
        return this;
    }

    public PersonPage insertPatientFirstName(String name) {
        clearAndSendKeys(inputPatientFirstName, name);
        return this;
    }

    public PersonPage insertPatientLastName(String lastName) {
        clearAndSendKeys(inputPatientLastName, lastName);
        return this;
    }

    public PersonPage insertPatientSocialNumber(String socialNumber) {
        clearAndSendKeys(inputPatientSocialNumber, socialNumber);
        return this;
    }

    public PersonPage choosePatientCountryOfResidence(String countryOfResidence) {
        chooseFromDDOptionsContainingText(choosePatientCountryOfResidence, countryOfResidence);
        return this;
    }

    public PersonPage insertPatientBirthDate(String date) {
        clearAndSendKeys(inputPatientBirthDate, date);
        return this;
    }

    public PersonPage insertPatientAge(String age) {
        clearAndSendKeys(inputPatientAge, age);
        return this;
    }

    public PersonPage insertPatientEmail(String email) {
        clearAndSendKeys(inputPatientEmail, email);
        return this;
    }

    public PersonPage insertPatientAddress(String address) {
        clearAndSendKeys(inputPatientAddress, address);
        return this;
    }

    public PersonPage insertPatientTelephoneNumber(String telephoneNumber) {
        clearAndSendKeys(inputPatientTelephoneNumber, telephoneNumber);
        return this;
    }

    public PersonPage selectPatientSex(String text) {
        clickRadioButtonContainingTextFromRootElement(radioButtonPresentationPatientSex, text);
        return this;
    }

    public PersonPage selectPatientCaseStatus(String text) {
        clickRadioButtonContainingTextFromRootElement(radioButtonPresentationPatientCaseStatus, text);
        return this;
    }

}
