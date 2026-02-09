package selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReport implements ITestListener {

    public ExtentSparkReporter sparkReporter; // UI of the report
    public ExtentReports extent; //populate common info on the report
    public ExtentTest test;  //Creating test cases entries in the report and update status of the test methods

    public void onStart(ITestContext context) {

         String timeStamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss"));

        sparkReporter = new ExtentSparkReporter("./reports/myRegressionReport_" + timeStamp + ".html");

        sparkReporter.config().setDocumentTitle("Regression Report");
        sparkReporter.config().setReportName("Regression Report ");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Edgar Flores Ovando");
        extent.setSystemInfo("os","Windows10");
        extent.setSystemInfo("Browser Name", "Chrome");
    }


    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName()); //Create a new enty in the report
        test.log(Status.PASS, "Test case Passed: "+result.getName());

    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case Failed: "+result.getName());
        test.log(Status.FAIL, "Test Case Failed cause: "+result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case Skipped: "+result.getName());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }


}
