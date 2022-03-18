package functionalTests;

import dataProviders.SymptomsPageDataProvider;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CollectorPage;
import pages.PersonPage;
import pages.SymptomsPage;
import utils.AssertionsUtil;
import utils.BaseTestPreconditionsClass;

public class SymptomsPageTest extends BaseTestPreconditionsClass {

    @Step("Executing before test")
    protected void beforeMethodExtended() {
        initializeWebDriver();
        collectorPage = new CollectorPage(driver);
        personPage = new PersonPage(driver);
        symptomsPage = new SymptomsPage(driver);
        assertions = new AssertionsUtil(driver);
        collectorPage.navigateTo(baseUrl, collectorPage);
    }

    @Test(priority = 1,
            dataProvider = "symptomsPageDataProvider", dataProviderClass = SymptomsPageDataProvider.class)
    public void functionalTestRatingSymptoms(String date, String fever, String throat, String nose, String cough,
                                             String breath, String vomit, String nausea, String diarrhea, String backache) {
        beforeMethodsPersonPreconditions();
        symptomsPage
                .insertFirstSymptomsDate(date)
                .rateFeverSymptoms(fever)
                .rateSoreThroatSymptoms(throat)
                .rateRunnyNoseSymptoms(nose)
                .rateCoughSymptoms(cough)
                .rateBreathingSymptoms(breath)
                .rateVomitingSymptoms(vomit)
                .rateNauseaSymptoms(nausea)
                .rateDiarrheaSymptoms(diarrhea)
                .rateBackAcheSymptoms(backache)
                .clickNextPage();
        Assert.assertTrue(assertions.assertNewPage().contains("Sample"));
    }

    @Test(priority = 2)
    public void functionalTestCheckNoSymptomsAndSeeDisabledDependantFields() {
        beforeMethodsPersonPreconditions();
        symptomsPage
                .checkNoSymptomsCheckbox()
                .isDateDisabled()
                .isUnknownSymptomsDisabled()
                .clickNextPage();
        Assert.assertTrue(assertions.assertNewPage().contains("Sample"));
    }

    @Test(priority = 3)
    public void functionalTestCheckUnknownSymptomsAndSeeDisabledDependantFields() {
        beforeMethodsPersonPreconditions();
        symptomsPage
                .checkUnknownSymptomsCheckbox()
                .isDateDisabled()
                .isNoSymptomsDisabled()
                .clickNextPage();
        Assert.assertTrue(assertions.assertNewPage().contains("Sample"));
    }

}
