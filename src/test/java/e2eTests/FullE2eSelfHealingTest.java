package e2eTests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.CollectorPage;
import pages.PersonPage;
import utils.AssertionsUtil;
import utils.BaseTestPreconditionsClass;
import utils.ProgressBar;

public class FullE2eSelfHealingTest extends BaseTestPreconditionsClass {

    @Step("Executing before test")
    protected void beforeMethodExtended() {
        initializeSelfHealingDriver();
        collectorPage = new CollectorPage(driver);
        personPage = new PersonPage(driver);
        assertions = new AssertionsUtil(driver);
        progressBar = new ProgressBar(driver);
        collectorPage.navigateTo(baseUrl, collectorPage);
    }

    @Test(priority = 1, description = "E2e self healing test")
    public void selfHealingTestMandatoryPages() {
        beforeMethodsPersonPreconditions();
    }

}
