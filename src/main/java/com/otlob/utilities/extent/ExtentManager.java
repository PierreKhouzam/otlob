package com.otlob.utilities.extent;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            // set HTML report file location
            extent = new ExtentReports(System.getProperty("user.dir")
                    + "\\extentreports\\ExtentReportResults.html", true);
        }
        return extent;
    }
}