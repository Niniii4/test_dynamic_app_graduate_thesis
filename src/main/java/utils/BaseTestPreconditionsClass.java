package utils;

import static enums.PresentDateEnum.PRESENT_DATE;

import io.qameta.allure.Step;
import org.testng.Assert;
import pages.CollectorPage;
import pages.PersonPage;

public class BaseTestPreconditionsClass extends BaseTestClass {

    @Step("Executing before test")
    protected void beforeMethodExtended() {
        collectorPage = new CollectorPage(driver);
        assertions = new AssertionsUtil(driver);
        personPage = new PersonPage(driver);
        collectorPage.navigateTo(baseUrl, collectorPage);
    }

    protected void beforeMethodsCollectorPreconditions() {
        collectorPage.insertUniqueCaseId("1")
                .insertCollectorName("John Doe")
                .insertCollectorInstitution("Health Care Institution")
                .insertCollectorTelephone("0038978222046")
                .insertCollectorEmail("john.doe@samplemail.com")
                .insertCompletionDate(PRESENT_DATE.toString())
                .insertSignature(xValuesCanvas, yValuesCanvas)
                .clickNextPage();
        String passedPage = assertions.assertNewPage();
        Assert.assertTrue(passedPage.contains("Person"));
    }

    protected void beforeMethodsPersonPreconditions() {
        beforeMethodsCollectorPreconditions();
        personPage.selectIsPatientProvidingInformation(false)
                .insertRespondentFirstName("Petra")
                .insertRespondentLastName("Doev")
                .clickNextPage();
        String passedPage = assertions.assertNewPage();
        Assert.assertTrue(passedPage.contains("Symptoms"));
    }

}
