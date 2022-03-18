package functionalTests;

import dataProviders.PersonPageDataProvider;
import io.qameta.allure.Step;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CollectorPage;
import pages.PersonPage;
import utils.AssertionsUtil;
import utils.BaseTestPreconditionsClass;

public class PersonPageTest extends BaseTestPreconditionsClass {

    @Step("Executing before test")
    protected void beforeMethodExtended() {
        initializeWebDriver();
        collectorPage = new CollectorPage(driver);
        personPage = new PersonPage(driver);
        assertions = new AssertionsUtil(driver);
        collectorPage.navigateTo(baseUrl, collectorPage);
    }

    @Test(priority = 1,
        dataProvider = "personPageNegativeScenariosDataProviderRespondent", dataProviderClass = PersonPageDataProvider.class)
    public void functionalTestRespondentNegativeScenarios(Boolean isPatientProvidingInformation,
                                                          String respondentFirstName,
                                                          String respondentLastName,
                                                          String respondentRelationshipToPatient,
                                                          String respondentAddress,
                                                          String respondentTelephoneNumber,
                                                          List<String> errorMessages) {
        beforeMethodsCollectorPreconditions();
        personPage.selectIsPatientProvidingInformation(isPatientProvidingInformation)
            .insertRespondentFirstName(respondentFirstName)
            .insertRespondentLastName(respondentLastName)
            .chooseRespondentRelationshipToPatient(respondentRelationshipToPatient)
            .insertRespondentAddress(respondentAddress)
            .insertRespondentTelephoneNumber(respondentTelephoneNumber)
            .clickNextPage();
        errorMessages.forEach(error -> softAssert.assertTrue(assertions.assertErrorMessageShown(error)));
    }

    @Test(priority = 3,
        dataProvider = "personPageNegativeScenariosDataProviderPatient", dataProviderClass = PersonPageDataProvider.class)
    public void functionalTestPatientNegativeScenarios(Boolean isPatientProvidingInformation,
                                                       String patientFirstName,
                                                       String patientLastName,
                                                       String patientSocialNumber,
                                                       String patientCountryOfResidence,
                                                       String patientBirthDate,
                                                       String patientAge,
                                                       String patientEmail,
                                                       String patientAddress,
                                                       String patientTelephoneNumber,
                                                       String patientSex,
                                                       String patientCaseStatus,
                                                       List<String> errorMessages) {
        beforeMethodsCollectorPreconditions();
        personPage.selectIsPatientProvidingInformation(isPatientProvidingInformation)
            .insertPatientFirstName(patientFirstName)
            .insertPatientLastName(patientLastName)
            .insertPatientSocialNumber(patientSocialNumber)
            .choosePatientCountryOfResidence(patientCountryOfResidence)
            .insertPatientBirthDate(patientBirthDate)
            .insertPatientAge(patientAge)
            .insertPatientEmail(patientEmail)
            .insertPatientAddress(patientAddress)
            .insertPatientTelephoneNumber(patientTelephoneNumber)
            .selectPatientSex(patientSex)
            .selectPatientCaseStatus(patientCaseStatus)
            .clickNextPage();
        errorMessages.forEach(error -> softAssert.assertTrue(assertions.assertErrorMessageShown(error)));
    }

    @Test(priority = 2)
    public void functionalTestRespondentPositiveScenario() {
        beforeMethodsCollectorPreconditions();
        personPage.selectIsPatientProvidingInformation(false)
            .insertRespondentFirstName("Jonas")
            .insertRespondentLastName("Dose")
            .clickNextPage();
        Assert.assertTrue(assertions.assertNewPage().contains("Symptoms"));
    }

    @Test(priority = 4)
    public void functionalTestPatientPositiveScenario() {
        beforeMethodsCollectorPreconditions();
        personPage.selectIsPatientProvidingInformation(true)
            .insertPatientFirstName("Joana")
            .insertPatientLastName("Wreck")
            .insertPatientSocialNumber("1234567891234")
            .clickNextPage();
        Assert.assertTrue(assertions.assertNewPage().contains("Symptoms"));
    }
}
