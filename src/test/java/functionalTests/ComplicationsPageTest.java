package functionalTests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.CollectorPage;
import pages.ComplicationsPage;
import pages.PersonPage;
import utils.AssertionsUtil;
import utils.BaseTestPreconditionsClass;
import utils.ProgressBar;

public class ComplicationsPageTest extends BaseTestPreconditionsClass {

    @Step("Executing before test")
    protected void beforeMethodExtended() {
        initializeWebDriver();
        collectorPage = new CollectorPage(driver);
        personPage = new PersonPage(driver);
        complicationsPage = new ComplicationsPage(driver);
        progressBar = new ProgressBar(driver);
        assertions = new AssertionsUtil(driver);
        collectorPage.navigateTo(baseUrl, collectorPage);
    }

    @Test(priority = 1)
    public void functionalTest() {
        beforeMethodsPersonPreconditions();
        progressBar.clickProgressBarButtonComplications();
        softAssert.assertTrue(assertions.assertNewPage().contains("Complications"));
        complicationsPage
            .hospitalizationRequired("Yes")
            .hospitalizationNameOfHospital("National Hospital")
            .hospitalizationHealthRate("Excellent")
            .icuRequired("Yes")
            .icuNameOfHospital("Mother Tereza")
            .icuHealthRate("Good")
            .ardsRequired("Yes")
            .ardsNameOfHospital("Health care")
            .ardsHealthRate("Average")
            .pneumoniaRequired("Yes")
            .pneumoniaNameOfHospital("Deep breathing")
            .pneumoniaHealthRate("Poor")
            .ventilationRequired("Yes")
            .ventilationRequired("Hospital one")
            .ventilationHealthRate("Fair")
            .emoRequired("No")
            .emoHealthRate("Excellent")
            .clickNextPage();
        softAssert.assertTrue(assertions.assertNewPage().contains("Exposures"));
    }

}
