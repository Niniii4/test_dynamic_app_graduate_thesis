package functionalTests;

import static enums.PresentDateEnum.PRESENT_DATE;
import static java.util.Objects.isNull;

import dataProviders.SamplePageDataProvider;
import io.qameta.allure.Step;
import java.util.List;
import org.testng.annotations.Test;
import pages.CollectorPage;
import pages.PersonPage;
import pages.SamplePage;
import utils.AssertionsUtil;
import utils.BaseTestPreconditionsClass;
import utils.ProgressBar;

public class SamplePageTest extends BaseTestPreconditionsClass {

    @Step("Executing before test")
    protected void beforeMethodExtended() {
        initializeWebDriver();
        collectorPage = new CollectorPage(driver);
        personPage = new PersonPage(driver);
        samplePage = new SamplePage(driver);
        progressBar = new ProgressBar(driver);
        assertions = new AssertionsUtil(driver);
        collectorPage.navigateTo(baseUrl, collectorPage);
    }

    @Test(priority = 1,
        dataProvider = "samplePagePositiveScenariosDataProvider", dataProviderClass = SamplePageDataProvider.class)
    public void functionalTestPositiveScenarios(String respiratorySample, String otherSample) {
        beforeMethodsPersonPreconditions();
        progressBar.clickProgressBarButtonSample();
        softAssert.assertTrue(assertions.assertNewPage().contains("Sample"));
        samplePage
            .insertDateOfSampleCollected(PRESENT_DATE.toString())
            .selectTypeOfRespiratorySample(respiratorySample)
            .selectIfOtherSamplesCollected(otherSample);
        if (!isNull(respiratorySample) && respiratorySample.equals("Other")) {
            samplePage.insertOtherTypeOfRespiratorySample("NBC swab");
        }
        if (!isNull(otherSample) && otherSample.equals("Yes")) {
            samplePage
                .insertOtherSpecifiedSample("NBC swab")
                .insertDateTaken(PRESENT_DATE.toString());
        }
        samplePage.clickNextPage();
        softAssert.assertTrue(assertions.assertNewPage().contains("Complications"));
    }

    @Test(priority = 2,
        dataProvider = "samplePageNegativeScenariosDataProvider", dataProviderClass = SamplePageDataProvider.class)
    public void functionalTestNegativeScenarios(String respiratorySample,
                                                String otherSample,
                                                String textRespiratorySample,
                                                String textOtherSample,
                                                List<String> errorMessages) {
        beforeMethodsPersonPreconditions();
        progressBar.clickProgressBarButtonSample();
        softAssert.assertTrue(assertions.assertNewPage().contains("Sample"));
        samplePage
            .insertDateOfSampleCollected(PRESENT_DATE.toString())
            .selectTypeOfRespiratorySample(respiratorySample)
            .insertOtherTypeOfRespiratorySample(textRespiratorySample)
            .selectIfOtherSamplesCollected(otherSample)
            .insertOtherSpecifiedSample(textOtherSample)
            .clickNextPage();
        errorMessages.forEach(error -> softAssert.assertTrue(assertions.assertErrorMessageShown(error)));
    }
}
