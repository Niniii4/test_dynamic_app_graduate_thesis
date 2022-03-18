package functionalTests;

import io.qameta.allure.Step;
import java.util.List;
import org.testng.annotations.Test;
import pages.CollectorPage;
import pages.ExposuresPage;
import pages.PersonPage;
import utils.AssertionsUtil;
import utils.BaseTestPreconditionsClass;
import utils.ProgressBar;

public class ExposuresPageTest extends BaseTestPreconditionsClass {

    private final List<List<String>> contactPersons = List.of(
        List.of("father", "Thomas", "Shelby", "today", "1"),
        List.of("brother", "Arthur", "Shelby", "yesterday", "2"),
        List.of("sister", "Ada", "Shelby", "04/04/2022", "3"),
        List.of("cousin", "Michael", "Gray", "an hour ago", "4")
    );

    @Step("Executing before test")
    protected void beforeMethodExtended() {
        initializeWebDriver();
        collectorPage = new CollectorPage(driver);
        personPage = new PersonPage(driver);
        exposuresPage = new ExposuresPage(driver);
        progressBar = new ProgressBar(driver);
        assertions = new AssertionsUtil(driver);
        collectorPage.navigateTo(baseUrl, collectorPage);
    }

    @Test(priority = 1)
    public void functionalTest() throws InterruptedException {
        beforeMethodsPersonPreconditions();
        progressBar.clickProgressBarButtonExposures();
        softAssert.assertTrue(assertions.assertNewPage().contains("Exposures"));
        exposuresPage
            .selectHasPatientBeenInContactWithOtherPerson(true)
            .removePersonInContactByRowId(1);
        addContactPersons();
        for (int i = contactPersons.size()-1; i > 0 ; i--) {
            exposuresPage.removePersonInContactByRowId(Integer.parseInt(contactPersons.get(i).get(4)));
        }
        exposuresPage.clickNextPage();
        softAssert.assertTrue(assertions.assertNewPage().contains("Completion"));
    }

    private void addContactPersons() throws InterruptedException {
        for (List<String> person : contactPersons) {
            exposuresPage.addPersonInContact()
                .fillRowWithInformation(person.get(0), person.get(1), person.get(2), person.get(3), person.get(4));
        }
    }

}
