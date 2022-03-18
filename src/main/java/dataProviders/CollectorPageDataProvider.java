package dataProviders;

import static enums.PresentDateEnum.PRESENT_DATE;
import static utils.messages.CollectorPageErrorMessages.*;

import java.util.List;
import org.testng.annotations.DataProvider;

public class CollectorPageDataProvider {

    @DataProvider(name = "collectorPageNegativeScenariosDataProvider")
    public static Object[][] dataProviderMethod() {
        return new Object[][] {
            {"", "John Doe", "Institute 7a", "557023", "john.doe@mail.com", PRESENT_DATE.toString(),
                List.of(20, 25, 55, 70), List.of(-30, 20, -35, 50),
                List.of(EMPTY_CASE_NUMBER_ID)},

            {"", "", "Institute 7b", "557023", "john.doe@mail.com", PRESENT_DATE.toString(),
                List.of(20, 30, 45, -130), List.of(0, -40, 25, 10),
                List.of(EMPTY_CASE_NUMBER_ID, EMPTY_NAME)},

            {"", "", "", "557023cc", "john.doe@mail.com",  PRESENT_DATE.toString(),
                List.of(-10, 0, 50, -150), List.of(-20, -40, 25, 80),
                List.of(EMPTY_CASE_NUMBER_ID, EMPTY_NAME, EMPTY_INSTITUTION, INVALID_TELEPHONE)},

            {"993", "", "Public Health Building Ro&Co", "557023", "john.doe@mail.com", "10/10/2022",
                List.of(20, 45, -55, 70), List.of(-40, 25, 35, -40),
                List.of(EMPTY_NAME, INVALID_INSTITUTION)},

            {"", "Jane Test", "Public Health Building", "557023", "", "01/01/2022",
                List.of(20, 25, 55, 70), List.of(-30, 20, -35, 50),
                List.of(EMPTY_EMAIL)},

            {"24", "Jane Doe", "CC 20 Inst/L #2", "557023cc", "jane doe",  PRESENT_DATE.toString(),
                List.of(0, -40, 45, -20), List.of(40, -10, -40, 40),
                List.of(INVALID_INSTITUTION, INVALID_TELEPHONE, INVALID_EMAIL)},

            {"5579", "J0hn D0e", "Inst", "623900", "john@doe.com",  PRESENT_DATE.toString(),
                List.of(-30, -10, 45, 60), List.of(0, 20, -20, 0),
                List.of(INVALID_NAME, SHORT_INSTITUTION)},

            {"12", "Jane", "", "", "",  PRESENT_DATE.toString(),
                List.of(-50, -20, 15, 50), List.of(-20, 50, -50, 20),
                List.of(SHORT_NAME, EMPTY_INSTITUTION, EMPTY_TELEPHONE, EMPTY_EMAIL)},

            {"4598", "", "", "", "", "",
                List.of(-70, -40, 15, 50), List.of(-30, 55, 65, 15),
                List.of(EMPTY_NAME, EMPTY_INSTITUTION, EMPTY_TELEPHONE, EMPTY_EMAIL, EMPTY_DATE)},

            {"", "", "", "", "", "",
                List.of(-90, -30, 15, 55), List.of(0, 55, 15, 20),
                List.of(EMPTY_CASE_NUMBER_ID, EMPTY_NAME, EMPTY_INSTITUTION, EMPTY_TELEPHONE, EMPTY_EMAIL, EMPTY_DATE)},

            {"24", "", "Hospital MT", "19", "",  PRESENT_DATE.toString(),
                null, null,
                List.of(EMPTY_NAME, SHORT_LONG_TELEPHONE, EMPTY_EMAIL, EMPTY_SIGNATURE)},

            {"1", "", "", "123456789123456789123456789", "", PRESENT_DATE.toString(),
                null, null,
                List.of(EMPTY_NAME, EMPTY_INSTITUTION, SHORT_LONG_TELEPHONE, EMPTY_EMAIL, EMPTY_SIGNATURE)},

            {"", "", "", "", "", "",
                null, null,
                List.of(EMPTY_CASE_NUMBER_ID, EMPTY_NAME, EMPTY_INSTITUTION, EMPTY_TELEPHONE, EMPTY_EMAIL, EMPTY_DATE, EMPTY_SIGNATURE)},

            {"25", "Elton John", "Institute 9/2 no#4", "tel.330450", "", "01/01/2020",
                null, null,
                List.of(INVALID_INSTITUTION, INVALID_TELEPHONE, EMPTY_EMAIL, BELOW_MIN_DATE, EMPTY_SIGNATURE)},

            {"", "Test John", "", "", "mail@test.com", "01/01/2030",
                List.of(20, 25, 55, 70), List.of(-30, 20, -35, 50),
                List.of(EMPTY_CASE_NUMBER_ID, EMPTY_INSTITUTION, EMPTY_TELEPHONE, OVER_MAX_DATE)},

            {"49", "Elton-John 99", "Health Center (99)", "phone:90899",  "mail.99.com", "02/12/2024",
                List.of(-10, 0, 50, -150), List.of(-20, -40, 25, 80),
                List.of(INVALID_NAME, INVALID_INSTITUTION, INVALID_TELEPHONE, INVALID_EMAIL, OVER_MAX_DATE)},

            {"25", "Jane Dose", "Health Care Center HEART", "225003", "jane_dose@mail.com", "01/01/1998",
                null, null,
                List.of(BELOW_MIN_DATE, EMPTY_SIGNATURE)}

        };
    }

}
