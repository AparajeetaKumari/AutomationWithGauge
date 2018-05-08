//import com.thoughtworks.gauge.Step;
//
//public class GoogleTest {
//
//    public void GoogleTest() {
//        DriverFactory.getReportiumClient().testStart(“Example Perfecto Gauge Google Test”, new TestContext(“Google”, “Gauge”));
//    }
//    @Step(“On the homepage”)
//    public void navigateToHomePage() {
//        try {
//            DriverFactory.getDriver().get(“https: //www.google.com”);
//        } catch (Exception e) {
//            setTestResultFailed(e);
//            e.printStackTrace();
//        }
//    }
//    private void setTestResultFailed(Exception e) {
//        DriverFactory.setExceptionInformation(e);
//    }
//}
