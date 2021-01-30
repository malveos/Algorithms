package com.osm.OmkarSM.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestController.class, TestSampleRepository.class, TestSampleService.class })
public class AllTests {

}
