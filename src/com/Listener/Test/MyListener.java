package com.Listener.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyListener extends TestListenerAdapter {
	
	 public void onTestSuccess(ITestResult tr)  {
		 File scrFile = ((TakesScreenshot)Properties.driver).getScreenshotAs(OutputType.FILE);
	       // Now you can do whatever you need to do with it, for example copy somewhere
	       try {
	              FileUtils.copyFile(scrFile, new File("D:\\Workspace\\TestFailureScreenshot\\SuccessScreenshot\\Success"+timestamp()+".png"));
	       } catch (IOException e) {
	              // TODO Auto-generated catch block
	              e.printStackTrace();
	       }
         System.out.println("TestPassed");
        }

//Am going to take screenshot on failure
public void onTestFailure(ITestResult itr)
{
      
      
       File scrFile = ((TakesScreenshot)Properties.driver).getScreenshotAs(OutputType.FILE);
       // Now you can do whatever you need to do with it, for example copy somewhere
       try {
              FileUtils.copyFile(scrFile, new File("D:\\Workspace\\TestFailureScreenshot\\FailureScreenshot\\failure"+timestamp()+".png"));
       } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
       }
       System.out.println("Taken screenshot because testcase failed");
      
}

public static String timestamp() {
	
	Date date = new Date();
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_h_mm_ss");
	
	String formattedDate = sdf.format(date);
	
	// System.out.println(formattedDate); // 12/01/2011 4:48:16 PM
	String dt = formattedDate;
	
	return dt;

}


}


