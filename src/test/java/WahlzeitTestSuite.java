/*
* Classname: WahlzeitTestSuite
*
* Version information: 1.0
*
* Date: 5.11.2017
*
* Copyright notice: Ask me
*/


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	org.wahlzeit.handlers.TellFriendTest.class,
	
	org.wahlzeit.model.AccessRightsTest.class,
	org.wahlzeit.model.FlagReasonTest.class,
	org.wahlzeit.model.GenderTest.class,
	org.wahlzeit.model.GuestTest.class,
	org.wahlzeit.model.PhotoFilterTest.class,
	org.wahlzeit.model.PhotoLocationTest.class,
	org.wahlzeit.model.TagsTest.class,
	org.wahlzeit.model.UserStatusTest.class,
	org.wahlzeit.model.ValueTest.class,
	
	org.wahlzeit.model.persistence.AbstractAdapterTest.class,
	org.wahlzeit.model.persistence.DatastoreAdapterTest.class,
	
	org.wahlzeit.services.EmailAddressTest.class,
	org.wahlzeit.services.LogBuilderTest.class,
	
	org.wahlzeit.services.mailing.EmailServiceTest.class,
	
	org.wahlzeit.utils.StringUtilTest.class,
	org.wahlzeit.utils.VersionTest.class,
	
})


public class WahlzeitTestSuite {

}
