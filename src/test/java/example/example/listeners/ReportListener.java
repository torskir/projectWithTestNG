package example.example.listeners;

import com.relevantcodes.extentreports.LogStatus;
import example.example.report.ExtentReportManager;
import example.example.util.ReportUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ReportListener implements ITestListener {

	/**
	 * Gets the test name.
	 *
	 * @param result the result
	 * @return the test name
	 */
	public String getTestName(ITestResult result) {
		return result.getTestName() != null ? result.getTestName()
				: result.getMethod().getConstructorOrMethod().getName();
	}

	/**
	 * Gets the test description.
	 *
	 * @param result the result
	 * @return the test description
	 */
	public String getTestDescription(ITestResult result) {
		return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportManager.startTest(getTestName(result), getTestDescription(result));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ReportUtil.addScreenShot(LogStatus.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Throwable t = result.getThrowable();
		String cause = "";
		if (t != null)
			cause = t.getMessage();
		ReportUtil.addScreenShot(LogStatus.FAIL, "Test Failed : " + cause);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReportManager.endCurrentTest();
		ExtentReportManager.getExtentReports().flush();
	}

}
