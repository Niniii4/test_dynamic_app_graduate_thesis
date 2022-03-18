package utils;

import static enums.PresentDateEnum.PRESENT_DATE;

public class BaseTestE2eClass extends BaseTestClass {

    protected static final boolean TESTING_THROUGH_NAVIGATION = true;
    protected static final boolean TESTING_THROUGH_PROGRESS_BAR = false;

    protected void completeCollectorPage(boolean testingThroughNavigation) {
        collectorPage
                .insertUniqueCaseId("1")
                .insertCollectorName("Samantha")
                .insertCollectorInstitution("Hughes")
                .insertCollectorTelephone("550228")
                .insertCollectorEmail("samantha@mail.com")
                .insertCompletionDate(PRESENT_DATE.toString())
                .insertSignature(xValuesCanvas, yValuesCanvas);
        if (testingThroughNavigation)
            collectorPage.clickNextPage();
        else
            progressBar.clickProgressBarButtonPerson();
        softAssert.assertTrue(assertions.assertNewPage().contains("Person"));
    }

    protected void completePersonPagePatientProvidingInformation(boolean testingThroughNavigation) {
        personPage.selectIsPatientProvidingInformation(true)
                .insertPatientFirstName("Joana")
                .insertPatientLastName("Wreck")
                .insertPatientSocialNumber("1234567891234");
        if (testingThroughNavigation) {
            personPage.clickNextPage();
        } else {
            progressBar.clickProgressBarButtonSymptoms();
        }
        softAssert.assertTrue(assertions.assertNewPage().contains("Symptoms"));
    }

    protected void completePersonPageRespondentProvidingInformation(boolean testingThroughNavigation) {
        personPage.selectIsPatientProvidingInformation(false)
                .insertRespondentFirstName("Jonas")
                .insertRespondentLastName("Dose");
        if (testingThroughNavigation) {
            personPage.clickNextPage();
        } else {
            progressBar.clickProgressBarButtonSymptoms();
        }
        softAssert.assertTrue(assertions.assertNewPage().contains("Symptoms"));
    }

    protected void completeSymptomsPage(boolean testingThroughNavigation) {
        symptomsPage
                .insertFirstSymptomsDate("03/03/2022")
                .rateFeverSymptoms("10")
                .rateSoreThroatSymptoms("2")
                .rateRunnyNoseSymptoms("3")
                .rateCoughSymptoms("4")
                .rateBreathingSymptoms("5")
                .rateVomitingSymptoms("6")
                .rateNauseaSymptoms("7")
                .rateDiarrheaSymptoms("8")
                .rateBackAcheSymptoms("9");
        if (testingThroughNavigation) {
            symptomsPage.clickNextPage();
        } else {
            progressBar.clickProgressBarButtonSample();
        }
        softAssert.assertTrue(assertions.assertNewPage().contains("Sample"));
    }

    protected void completeSamplePage(boolean testingThroughNavigation) {
        samplePage
                .insertDateOfSampleCollected(PRESENT_DATE.toString())
                .selectTypeOfRespiratorySample("Nasal swab")
                .selectIfOtherSamplesCollected("No");
        if (testingThroughNavigation) {
            samplePage.clickNextPage();
        } else {
            progressBar.clickProgressBarButtonComplications();
        }
        softAssert.assertTrue(assertions.assertNewPage().contains("Complications"));
    }

    protected void completeComplicationsPage(boolean testingThroughNavigation) {
        complicationsPage
                .hospitalizationRequired("Yes")
                .hospitalizationNameOfHospital("National Hospital")
                .hospitalizationHealthRate("Excellent")
                .icuRequired("Yes")
                .icuNameOfHospital("Mother Tereza")
                .icuHealthRate("Good")
                .ardsRequired("Yes")
                .ardsNameOfHospital("Health care")
                .ardsHealthRate("Average")
                .pneumoniaRequired("Yes")
                .pneumoniaNameOfHospital("Deep breathing")
                .pneumoniaHealthRate("Poor")
                .ventilationRequired("Yes")
                .ventilationRequired("Hospital one")
                .ventilationHealthRate("Fair")
                .emoRequired("No")
                .emoHealthRate("Excellent");
        if (testingThroughNavigation) {
            complicationsPage.clickNextPage();
        } else {
            progressBar.clickProgressBarButtonExposures();
        }
        softAssert.assertTrue(assertions.assertNewPage().contains("Exposures"));
    }

    protected void completeExposuresPage(boolean testingThroughNavigation) throws InterruptedException {
        exposuresPage
                .selectHasPatientBeenInContactWithOtherPerson(true)
                .addPersonInContact()
                .fillRowWithInformation("father", "Thomas", "Shelby", "today", "1")
                .removePersonInContactByRowId(1);
        if (testingThroughNavigation) {
            exposuresPage.clickNextPage();
        } else {
            progressBar.clickProgressBarButtonCompletion();
        }
        softAssert.assertTrue(assertions.assertNewPage().contains("Completion"));
    }

    protected void completeCompletionPage() {
        completionPage.insertTimeNeededToCompleteSurvey("5")
                .clickComplete();
        softAssert.assertEquals(assertions.assertTextOfSurveyCompleted(), "Thank you for completing the survey!");
    }

}
