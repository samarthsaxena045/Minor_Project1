package my_minor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my_minor.model.StatusUpdate;
import my_minor.model.StatusUpdateDao;

@Service
public class StatusUpdateService {
	
	@Autowired
	private StatusUpdateDao statusUpdateDao;
	
	
	public void save(StatusUpdate statusUpdate) {
		statusUpdateDao.save(statusUpdate);
	}
	
	public StatusUpdate getLatest() {
		return statusUpdateDao.findFirstByOrderByAddedDesc();
	}
}
