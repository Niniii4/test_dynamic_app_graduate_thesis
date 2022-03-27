package functionalTests;

import dataProviders.CollectorPageDataProvider;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CollectorPage;
import pages.PersonPage;
import utils.AssertionsUtil;
import utils.BaseTestClass;

import java.util.List;

import static enums.PresentDateEnum.PRESENT_DATE;
import static utils.messages.CollectorPageErrorMessages.EMPTY_SIGNATURE;

public class CollectorPageTest extends BaseTestClass {

    @Step("Executing before test")
    protected void beforeMethodExtended() {
        initializeWebDriver();
        collectorPage = new CollectorPage(driver);
        personPage = new PersonPage(driver);
        assertions = new AssertionsUtil(driver);
        collectorPage.navigateTo(baseUrl, collectorPage);
    }

    @Test(priority = 1,
            dataProvider = "collectorPageNegativeScenariosDataProvider", dataProviderClass = CollectorPageDataProvider.class)
    public void functionalTestNegativeScenarios(String id, String name, String institution, String phone, String email,
                                                String date, List<Integer> xSignatureValues,
                                                List<Integer> ySignatureValues, List<String> errorMessages) {

        collectorPage.insertUniqueCaseId(id)
                .insertCollectorName(name)
                .insertCollectorInstitution(institution)
                .insertCollectorTelephone(phone)
                .insertCollectorEmail(email)
                .insertCompletionDate(date)
                .insertSignature(xSignatureValues, ySignatureValues)
                .clickNextPage();
        errorMessages.forEach(error -> softAssert.assertTrue(assertions.assertErrorMessageShown(error)));
    }

    @Test(priority = 2)
    public void functionalTestPositiveScenario() {
        collectorPage.insertUniqueCaseId("1")
                .insertCollectorName("John Doe")
                .insertCollectorInstitution("Health Care Institution")
                .insertCollectorTelephone("0038978222046")
                .insertCollectorEmail("john.doe@samplemail.com")
                .insertCompletionDate(PRESENT_DATE.toString())
                .insertSignature(xValuesCanvas, yValuesCanvas)
                .clickNextPage();
        Assert.assertTrue(assertions.assertNewPage().contains("Person"));
    }

    @Test(priority = 3)
    public void clearSignatureTest() {
        collectorPage.insertSignature(xValuesCanvas, yValuesCanvas).clickNextPage();
        softAssert.assertFalse(assertions.assertErrorMessageShown(EMPTY_SIGNATURE));
        collectorPage.clearSignature().clickNextPage();
        softAssert.assertTrue(assertions.assertErrorMessageShown(EMPTY_SIGNATURE));
    }

}
