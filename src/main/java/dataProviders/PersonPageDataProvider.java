package dataProviders;

import org.testng.annotations.DataProvider;

import java.util.List;

import static utils.messages.PersonPageErrorMessages.*;

public class PersonPageDataProvider {
    @DataProvider(name = "personPageNegativeScenariosDataProviderRespondent")
    public static Object[][] dataProviderMethodForRespondent() {
        return new Object[][]{
                {false, "En", "", "Child", "Address 1", "00385687",
                        List.of(SHORT_RESPONDENT_FIRST_NAME, EMPTY_RESPONDENT_LAST_NAME)},
                {false, "En33ie", "An", "Child", "Address 1", "00385687",
                        List.of(INVALID_RESPONDENT_FIRST_NAME, SHORT_RESPONDENT_LAST_NAME)},
                {false, "", "0scar", "Child", "Address 1", "00385687",
                        List.of(EMPTY_RESPONDENT_FIRST_NAME, INVALID_RESPONDENT_LAST_NAME)},
                {false, "", "", "", "", "",
                        List.of(EMPTY_RESPONDENT_FIRST_NAME, EMPTY_RESPONDENT_LAST_NAME)},
                {false, "An", "En", "", "", "",
                        List.of(SHORT_RESPONDENT_FIRST_NAME, SHORT_RESPONDENT_LAST_NAME)},
                {false, "En33ie", "0scar", "", "", "",
                        List.of(INVALID_RESPONDENT_FIRST_NAME, INVALID_RESPONDENT_LAST_NAME)}
        };
    }

    @DataProvider(name = "personPageNegativeScenariosDataProviderPatient")
    public static Object[][] dataProviderMethodForPatient() {
        return new Object[][]{
                {true, "", "", "", "", "", "", "", "", "", "Female", "Suspected",
                        List.of(EMPTY_PATIENT_FIRST_NAME, EMPTY_PATIENT_LAST_NAME, EMPTY_PATIENT_SOCIAL_NUMBER)},
                {true, "An", "En", "", "Morocco", "09/09/1990", "", "", "", "", "Female", "Probable",
                        List.of(SHORT_PATIENT_FIRST_NAME, SHORT_PATIENT_LAST_NAME, EMPTY_PATIENT_SOCIAL_NUMBER)},
                {true, "Ant0ni0", "$park", "3369", "Jordan", "", "28", "antony@smail.com", "", "", "Male", "Probable",
                        List.of(INVALID_PATIENT_FIRST_NAME, INVALID_PATIENT_LAST_NAME, INVALID_PATIENT_SOCIAL_NUMBER)},
                {true, "Ant0ni0", "", "3369857963157", "Tonga", "", "40", "bad@mail", "", "", "Male", "Confirmed",
                        List.of(INVALID_PATIENT_FIRST_NAME, EMPTY_PATIENT_LAST_NAME, INVALID_PATIENT_EMAIL)},
                {true, "Anto", "Johdos", "3369857963157", "", "", "40", "anto.jo@mail.com", "", "aPhone", "Male", "Suspected",
                        List.of(INVALID_PATIENT_TELEPHONE)},
                {true, "Anto", "Jo", "3369857963157", "", "", "40", "anto.jo@mail.com", "", "888", "Female", "Confirmed",
                        List.of(SHORT_PATIENT_LAST_NAME, SHORT_LONG_PATIENT_TELEPHONE)}
        };
    }
}
