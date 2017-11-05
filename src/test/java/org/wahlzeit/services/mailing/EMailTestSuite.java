/*
* Classname: EMailTestSuite
*
* Version information: 1.0
*
* Date: 5.11.2017
*
* Copyright notice: Ask me
*/


package org.wahlzeit.services.mailing;



import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	
	org.wahlzeit.services.EmailAddressTest.class,
	
	EmailServiceTest.class,	
})



public class EMailTestSuite {

}
