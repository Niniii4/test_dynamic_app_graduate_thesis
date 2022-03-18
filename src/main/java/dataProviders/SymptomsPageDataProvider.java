package dataProviders;

import org.testng.annotations.DataProvider;

public class SymptomsPageDataProvider {

    @DataProvider(name = "symptomsPageDataProvider")
    public static Object[][] dataProviderMethod() {
        return new Object[][] {
            {"03/03/2022", "2", "4", "7", "10", "3", "1", "4", "5", "6"},
            {"02/02/2022", "8", null, "7", null, "9", null, "6", null, "10"},
            {null, null, "1", null, "2", null, "3", null, "4", null},
            {null, null, null, null, null, null, null, null, null, null}
        };
    }
}
