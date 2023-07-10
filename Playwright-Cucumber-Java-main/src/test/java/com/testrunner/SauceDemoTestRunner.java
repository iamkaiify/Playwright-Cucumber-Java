package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


        @RunWith(Cucumber.class)
		@CucumberOptions(
		features = "src/test/java/features/XYZ.feature",
		glue = {"stepdefinitions"},
	    dryRun=false,
	    plugin = {"pretty", "junit:target/JunitReports/report.xm1",
	    		   "json:target/JReports/report.json",
	    		    "html:target/HtmlReports"}
	    		         )
	    		
     //Deniz babayaka 
		
		public class SauceDemoTestRunner{
        	
        	
        }
        
