package org.kgisl.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	
	  @Override
	    public void onTestFailure(ITestResult result) {
	        Object currentClass = result.getInstance();


	        // Call your custom screenshot method using test method name
	        String methodName = result.getName();  // e.g., TC001
	        try {
				BaseClass.screenShot(methodName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
