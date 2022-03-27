package dataProviders;

import org.testng.annotations.DataProvider;

import java.util.List;

import static utils.messages.SamplePageErrorMessages.*;

public class SamplePageDataProvider {

    @DataProvider(name = "samplePagePositiveScenariosDataProvider")
    public static Object[][] dataProviderMethodPositiveScenarios() {
        return new Object[][]{
                {null, "Unknown"},
                {"Nasopharyngeal swab", "Unknown"},
                {"Nasal swab", "No"},
                {"Throat swab", "No"},
                {null, null},
                {"Other", "Yes"},
                {"Other", "Unknown"},
                {"Nasal swab", "Yes"},
        };
    }

    @DataProvider(name = "samplePageNegativeScenariosDataProvider")
    public static Object[][] dataProviderMethodNegativeScenarios() {
        return new Object[][]{
                {"Other", "Yes", "", "", List.of(EMPTY_SAMPLE_TEXT, EMPTY_SAMPLE_TEXT)},
                {"Other", "Yes", "Ah", "Hi", List.of(SHORT_SAMPLE_TEXT, SHORT_SAMPLE_TEXT)},
                {"Other", "Yes", "4567", "1012", List.of(INVALID_SAMPLE_TEXT, INVALID_SAMPLE_TEXT)}
        };
    }

}
