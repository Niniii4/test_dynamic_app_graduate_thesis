package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import java.util.List;

public class ExposuresPage extends BasePage {

    @FindBy(id = "sq_224i_0")
    private WebElement selectContactAnswerTrue;

    @FindBy(id = "sq_224i_1")
    private WebElement selectContactAnswerFalse;

    @FindBy(css = "#contact_people > div:nth-child(2) > div > div:nth-child(1) > table > tbody > tr")
    private WebElement removePersonContact;

    @FindBy(className = "sv_q_footer")
    private WebElement footerAddElement;

    @FindBy(className = "sv_q_matrix_dynamic")
    private WebElement matrixRows;

    public ExposuresPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new ExposuresPage(driver);
    }

    public ExposuresPage selectHasPatientBeenInContactWithOtherPerson(boolean selectAnswer) {
        if (selectAnswer) {
            waitForElementToBeClickableAndClick(selectContactAnswerTrue);
        } else {
            waitForElementToBeClickableAndClick(selectContactAnswerFalse);
        }
        return this;
    }

    public ExposuresPage addPersonInContact() {
        clickButtonFromRootElement(footerAddElement, "Add a person in contact");
        return this;
    }

    public ExposuresPage fillRowWithInformation(String relation,
                                                String firstName,
                                                String lastName,
                                                String lastContact,
                                                String rowNumber) throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> webElements = matrixRows.findElements(By.className("sv_matrix_row"));
        for (int i = 0; i < webElements.size(); i++) {
            if (i == Integer.parseInt(rowNumber) - 1) {
                chooseRelationToContactPersonFromRootElement(webElements.get(i), relation);
                insertFirstNameOfContactFromRootElement(webElements.get(i), firstName);
                insertLastNameOfContactFromRootElement(webElements.get(i), lastName);
                insertLastContactWithContactFromRootElement(webElements.get(i), lastContact);
            }
        }
        return this;
    }

    protected void chooseRelationToContactPersonFromRootElement(WebElement rootElement, String text) {
        List<WebElement> webElements = rootElement.findElements(By.className("sv_q_dropdown_control"));
        for (WebElement webElement : webElements) {
            chooseFromDDOptionsContainingText(webElement, text);
        }
    }

    protected void insertFirstNameOfContactFromRootElement(WebElement rootElement, String text) {
        List<WebElement> webElements = rootElement.findElements(By.id("id_input_first_name"));
        for (WebElement webElement : webElements) {
            if (webElement.getText().isEmpty()) {
                clearAndSendKeys(webElement, text);
            }
        }
    }

    protected void insertLastNameOfContactFromRootElement(WebElement rootElement, String text) {
        List<WebElement> webElements = rootElement.findElements(By.id("id_input_last_name"));
        for (WebElement webElement : webElements) {
            if (webElement.getText().isEmpty()) {
                clearAndSendKeys(webElement, text);
            }
        }
    }

    protected void insertLastContactWithContactFromRootElement(WebElement rootElement, String text) {
        List<WebElement> webElements = rootElement.findElements(By.id("id_input_last_contact"));
        for (WebElement webElement : webElements) {
            if (webElement.getText().isEmpty()) {
                clearAndSendKeys(webElement, text);
            }
        }
    }

    public ExposuresPage removePersonInContactByRowId(int rowId) throws InterruptedException {
        Thread.sleep(1000);
        if (removePersonContact.isDisplayed()) {
            removePersonInContact(removePersonContact);
        } else {
            removePersonInContact(getDriver().findElement(
                    By.cssSelector(
                            "#contact_people > div:nth-child(2) > div > div:nth-child(1) > table > tbody > tr:nth-child(" +
                                    rowId + ")")));
        }
        return this;
    }

    protected void removePersonInContact(WebElement rootElement) {
        List<WebElement> webElements = rootElement.findElements(By.id("remove-row"));
        for (WebElement webElement : webElements) {
            waitForElementToBeClickableAndClick(webElement);
        }
    }

}
