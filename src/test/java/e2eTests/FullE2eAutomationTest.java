package e2eTests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import pages.*;
import utils.AssertionsUtil;
import utils.BaseTestE2eClass;
import utils.ProgressBar;

public class FullE2eAutomationTest extends BaseTestE2eClass {

    @Step("Executing before test")
    protected void beforeMethodExtended() {
        initializeWebDriver();
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

    @Test(priority = 1, description = "Full e2e test testing happy path scenario through footer navigation buttons")
    public void e2eHappyPathScenarioNavBar() throws InterruptedException {
        completeCollectorPage(TESTING_THROUGH_NAVIGATION);
        completePersonPagePatientProvidingInformation(TESTING_THROUGH_NAVIGATION);
        symptomsPage.clickPreviousPage();
        completePersonPageRespondentProvidingInformation(TESTING_THROUGH_NAVIGATION);
        completeSymptomsPage(TESTING_THROUGH_NAVIGATION);
        completeSamplePage(TESTING_THROUGH_NAVIGATION);
        completeComplicationsPage(TESTING_THROUGH_NAVIGATION);
        completeExposuresPage(TESTING_THROUGH_NAVIGATION);
        completeCompletionPage();
    }

    @Test(priority = 2, description = "Full e2e test testing happy path scenario through header progress bars")
    public void e2eHappyPathScenarioProgressBar() throws InterruptedException {
        completeCollectorPage(TESTING_THROUGH_PROGRESS_BAR);
        completePersonPagePatientProvidingInformation(TESTING_THROUGH_PROGRESS_BAR);
        completeSymptomsPage(TESTING_THROUGH_PROGRESS_BAR);
        completeSamplePage(TESTING_THROUGH_PROGRESS_BAR);
        completeComplicationsPage(TESTING_THROUGH_PROGRESS_BAR);
        progressBar.clickProgressBarButtonCollector();
        progressBar.clickProgressBarButtonExposures();
        completeExposuresPage(TESTING_THROUGH_PROGRESS_BAR);
        progressBar.clickProgressBarButtonPerson();
        completePersonPageRespondentProvidingInformation(TESTING_THROUGH_PROGRESS_BAR);
        progressBar.clickProgressBarButtonCompletion();
        completeCompletionPage();
    }

}
