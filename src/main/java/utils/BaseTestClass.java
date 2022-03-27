package utils;

import com.epam.healenium.SelfHealingDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.io.IOException;
import java.util.List;

public class BaseTestClass extends BaseTest {

    public List<Integer> xValuesCanvas = List.of(20, 25, 55, 70);
    public List<Integer> yValuesCanvas = List.of(-30, 20, -35, 50);
    protected WebDriver driver;
    protected String baseUrl;
    protected SoftAssert softAssert;
    protected CollectorPage collectorPage;
    protected PersonPage personPage;
    protected SymptomsPage symptomsPage;
    protected SamplePage samplePage;
    protected ComplicationsPage complicationsPage;
    protected ExposuresPage exposuresPage;
    protected CompletionPage completionPage;
    protected ProgressBar progressBar;
    protected AssertionsUtil assertions;

    @BeforeClass
    protected void beforeClass() {
        System.out.println("Before Class");
        baseUrl = PropertiesReader.readFromProperties(TestConfigurationConstants.MY_PROPERTIES_PATH,
                TestConfigurationConstants.BASE_URL_PROPERTY);
    }

    @Step("Executing before test")
    protected void beforeMethodExtended() {
    }

    @Step("Initialize self healing driver")
    protected void initializeSelfHealingDriver() {
        driver = SelfHealingDriver.create(initDriver());
    }

    @Step("Initialize web driver")
    protected void initializeWebDriver() {
        driver = initDriver();
    }

    private WebDriver initDriver() {
        String driverType = PropertiesReader.readFromProperties(TestConfigurationConstants.MY_PROPERTIES_PATH,
                TestConfigurationConstants.DRIVER_TYPE_PROPERTY);
        return DriverFactory.createDriverForBrowserWithValue(driverType);
    }

    @BeforeMethod(alwaysRun = true)
    protected void beforeMethod() throws IOException {
        System.out.println("Before Method has started");
        softAssert = new SoftAssert();
        beforeMethodExtended();
    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod() {
        System.out.println("After Method");
        softAssert.assertAll();
        driver.close();
        driver.quit();
    }

    @AfterClass(alwaysRun = true)
    protected void afterClass() {
        System.out.println("After Class");
    }

}
