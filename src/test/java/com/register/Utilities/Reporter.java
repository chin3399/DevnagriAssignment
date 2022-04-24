package com.register.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter extends TestListenerAdapter {

	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;

	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSuccess(tr);
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed
																							// information to the report
																							// with GREEN color
																							// highlighted
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailure(tr);

		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed information
																							// to the report with GREEN
																							// color highlighted

		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";

		File f = new File(screenshotPath);

		if (f.exists()) {
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSkipped(tr);
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));

	}

	@Override
	public void onStart(ITestContext testContext) {

		super.onStart(testContext);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String repName = "Test-Report-" + timeStamp + ".html";
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName);
		try {
			spark.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Arpit");

		spark.config().setDocumentTitle("Devnagri"); // Tile of report
		spark.config().setReportName("Devnagri Assignment Report"); // name of the report
		spark.config().setTheme(Theme.DARK);

	}

	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);
		extent.flush();
	}

}
