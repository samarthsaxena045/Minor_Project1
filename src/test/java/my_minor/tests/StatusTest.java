package my_minor.tests;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.Assert;
import my_minor.App;
import my_minor.model.StatusUpdate;
import my_minor.model.StatusUpdateDao;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
@Transactional //will run the test as transaction
public class StatusTest {
	
	//reference to StatusUpdateDao interface to load the status
	//Autowired annotation will make the  Spring to create a bean for the interface though the definition is not provided manually
	@Autowired
	private StatusUpdateDao statusUpdateDao; 
	
	@Test
	public void testSave() {
		StatusUpdate status = new StatusUpdate("This is a test status update");
		
		//saves the status to the database
		statusUpdateDao.save(status);
		
		assertNotNull("Non Null ID",status.getId());
		assertNotNull("Non Null Date", status.getAdded());
		
		//retrieving from the database
		StatusUpdate retrieved = statusUpdateDao.findById(status.getId()).orElse(null);
		
		//checking if both saved and retrieved status are same
		assertEquals("Matching StatusUpdate", status, retrieved);
	}
	
	@Test
	public void testFindLatest() {
		Calendar calendar = Calendar.getInstance();
		
		StatusUpdate lastStatusUpdate = null;
		
		for(int i=0;i<10;i++) {
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			
			StatusUpdate status= new StatusUpdate("Status Update" + i, calendar.getTime());
			
			statusUpdateDao.save(status);
			
			lastStatusUpdate = status;
			
		}
		
		StatusUpdate retrieved = statusUpdateDao.findFirstByOrderByAddedDesc();
		
		assertEquals("Latest Status Update", lastStatusUpdate, retrieved);
	}
}
