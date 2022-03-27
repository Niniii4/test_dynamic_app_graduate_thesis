package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    @FindBy(className = "sv_next_btn")
    private WebElement nextPageButton;

    @FindBy(className = "sv_prev_btn")
    private WebElement prevPageButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,
                TestConfigurationConstants.MAX_RETRY_FOR_LOCATING_ELEMENT_AJAX_FACTORY);
        PageFactory.initElements(factory, this);
        wait = new WebDriverWait(driver, TestConfigurationConstants.MAX_RETRY_FOR_LOCATING_ELEMENT);
        actions = new Actions(driver);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    protected void moveToElement(WebElement element) {
        actions.moveToElement(element);
        actions.perform();
    }

    public abstract BasePage newInstance(WebDriver driver);

    public <T extends BasePage> BasePage navigateTo(String url, T type) {
        driver.get(url);
        return type.newInstance(driver);
    }

    protected void clearAndSendKeys(WebElement element, String text) {
        moveToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(text);
    }

    protected void waitForElementToBeClickableAndClick(WebElement elem) {
        moveToElement(elem);
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    protected void waitAndFindElement(By byLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }

    protected List<WebElement> waitAndFindElements(WebElement root, By byLocator) {
        wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(root, byLocator));
        return root.findElements(byLocator);
    }

    protected void waitAndSendPresentDateOnCalendar(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        actions.sendKeys(Keys.SPACE)
                .pause(1000)
                .sendKeys(Keys.ENTER);
    }

    protected void waitAndInsertSignature(WebElement element, List<Integer> xOffsets, List<Integer> yOffsets) {
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.clickAndHold(element)
                .moveToElement(element, xOffsets.get(0), yOffsets.get(0))
                .moveByOffset(xOffsets.get(1), yOffsets.get(1))
                .moveByOffset(xOffsets.get(2), yOffsets.get(2))
                .moveByOffset(xOffsets.get(3), yOffsets.get(3))
                .release(element)
                .build()
                .perform();
    }

    protected String waitAndCheckSuccessfulPassedPage(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    protected String waitAndCheckSuccessfullyCompletedSurvey(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    protected List<String> waitAndCheckErrorElementsFromRoot(WebElement element, By byLocator) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        List<WebElement> errors = driver.findElements(byLocator);
        List<String> errorsText = new ArrayList<>();
        errors.forEach(error -> errorsText.add(error.getText()));
        return errorsText;
    }

    protected void chooseFromDDOptionsContainingText(WebElement ddList, String itemText) {
        ddList.click();
        List<WebElement> ddlOptionsFrom = waitAndFindElements(ddList, By.tagName("option"));
        for (WebElement option : ddlOptionsFrom) {
            String optionText = option.getText();
            if (optionText.contains(itemText)) {
                option.click();
                break;
            }
        }
    }

    protected void clickRadioButtonContainingTextFromRootElement(WebElement rootElement, String text) {
        List<WebElement> webElements = rootElement.findElements(By.className("sv_q_radiogroup"));
        for (WebElement webElement : webElements) {
            if (webElement.getText().contains(text)) {
                waitForElementToBeClickableAndClick(webElement);
            }
        }
    }

    protected void clickButtonFromRootElement(WebElement rootElement, String text) {
        List<WebElement> webElements = rootElement.findElements(By.className("sv_matrix_dynamic_button"));
        for (WebElement webElement : webElements) {
            if (webElement.getText().contains(text)) {
                waitForElementToBeClickableAndClick(webElement);
            }
        }
    }

    public void clickNextPage() {
        waitForElementToBeClickableAndClick(nextPageButton);
    }

    public void clickPreviousPage() {
        waitForElementToBeClickableAndClick(prevPageButton);
    }

}
