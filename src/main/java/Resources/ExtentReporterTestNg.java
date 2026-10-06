package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterTestNg {
	
	
	public static ExtentReports getReporterObject()
	{
	 String path= System.getProperty("user.dir")+"//reports//index.html";	
     ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	 reporter.config().setDocumentTitle("Test Result");
	 reporter.config().setReportName("Web Automation Results");
	 
	 ExtentReports extent=new ExtentReports();
	 extent.attachReporter(reporter);
	 extent.setSystemInfo("Tester", "Neeraj bhatia");
     return extent;
	
	//extent.createTest(filePath);
	//extent.flush();
}
	

}

