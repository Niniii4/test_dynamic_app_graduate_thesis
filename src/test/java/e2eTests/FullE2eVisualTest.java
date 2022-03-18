package e2eTests;

import com.applitools.eyes.selenium.Eyes;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.*;
import utils.AssertionsUtil;
import utils.BaseTestE2eClass;
import utils.ProgressBar;

public class FullE2eVisualTest extends BaseTestE2eClass {

    protected Eyes eyes;

    @Step("Executing before test")
    protected void beforeMethodExtended() {
        initializeWebDriver();
        eyes = new Eyes();
        eyes.setApiKey("SP6rA95xDvBI06ZuwdgGJ103LerqMrhN0mpbvKxtIOMDw110");
        eyes.open(driver, "E2E Test", "Visual test e2e");
        collectorPage = new CollectorPage(driver);
        personPage = new PersonPage(driver);
        symptomsPage = new SymptomsPage(driver);
        samplePage = new SamplePage(driver);
        complicationsPage = new ComplicationsPage(driver);
        exposuresPage = new ExposuresPage(driver);
        completionPage = new CompletionPage(driver);
        assertions = new AssertionsUtil(driver);
        progressBar = new ProgressBar(driver);
        collectorPage.navigateTo(baseUrl, collectorPage);
    }

    @Test(description = "E2e visual test")
    public void e2eVisualTesting() throws InterruptedException {
        eyes.checkWindow("Collector Page");
        completeCollectorPage(TESTING_THROUGH_NAVIGATION);
        eyes.checkWindow("Patient Page");
        completePersonPagePatientProvidingInformation(TESTING_THROUGH_NAVIGATION);
        eyes.checkWindow("Symptoms Page");
        completeSymptomsPage(TESTING_THROUGH_NAVIGATION);
        progressBar.clickProgressBarButtonSymptoms();
        eyes.checkWindow("Symptoms Page Completed");
        progressBar.clickProgressBarButtonSample();
        eyes.checkWindow("Sample Page");
        completeSamplePage(TESTING_THROUGH_NAVIGATION);
        eyes.checkWindow("Complications Page");
        completeComplicationsPage(TESTING_THROUGH_NAVIGATION);
        eyes.checkWindow("Exposures Page");
        completeExposuresPage(TESTING_THROUGH_NAVIGATION);
        eyes.checkWindow("Completion Page");
        completeCompletionPage();
        eyes.checkWindow("Final Page");
        eyes.close();
    }

}
