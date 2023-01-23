package com.luma.testutil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ProjExtentReport {
	public static ExtentReports extent;

	public static ExtentReports getReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
		reporter.config().setDocumentTitle("LUMA Report");
		reporter.config().setReportName("Test Automation Report");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Vishal Kachale", "Test Engineer");

		return extent;
	}
}