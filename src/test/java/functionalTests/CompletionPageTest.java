package functionalTests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.CollectorPage;
import pages.CompletionPage;
import pages.PersonPage;
import utils.AssertionsUtil;
import utils.BaseTestPreconditionsClass;
import utils.ProgressBar;

public class CompletionPageTest extends BaseTestPreconditionsClass {

    @Step("Executing before test")
    protected void beforeMethodExtended() {
        initializeWebDriver();
        collectorPage = new CollectorPage(driver);
        personPage = new PersonPage(driver);
        completionPage = new CompletionPage(driver);
        progressBar = new ProgressBar(driver);
        assertions = new AssertionsUtil(driver);
        collectorPage.navigateTo(baseUrl, collectorPage);
    }

    @Test(priority = 1)
    public void functionalTest() {
        beforeMethodsPersonPreconditions();
        progressBar.clickProgressBarButtonCompletion();
        softAssert.assertTrue(assertions.assertNewPage().contains("Completion"));
        completionPage.insertTimeNeededToCompleteSurvey("15")
            .clickComplete();
        softAssert.assertEquals(assertions.assertTextOfSurveyCompleted(), "Thank you for completing the survey!");
    }

}
