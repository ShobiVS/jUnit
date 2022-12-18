package org.samplejunit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

public class RunnerClass {
	@Test
	public void tc40() {
		Result rc = JUnitCore.runClasses(A.class,SampleProject.class,B.class);
		System.out.println("Total test case run count"  + rc.getRunCount());
		
		System.out.println("Total test case run time" +rc.getRunTime());
		System.out.println("Total test case failed count" +rc.getFailureCount());
		System.out.println("Ignored test case count" +rc.getIgnoreCount());
		List<Failure> f = rc.getFailures();
		for (Failure fail : f) {
			System.out.println(fail);
			
		}
		
        
         
	}
	
	
	

}
