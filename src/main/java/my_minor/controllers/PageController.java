package my_minor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import my_minor.model.StatusUpdate;
import my_minor.service.StatusUpdateService;
@Controller
public class PageController {
	
	@Autowired
	private StatusUpdateService statusUpdateService;
	
	
	@RequestMapping("/")
	//@ResponseBody
	String home() {
		return "app.homepage";
	}
	
	@RequestMapping("/about")
	//@ResponseBody
	String about() {
		return "app.about";
	}
	
	@RequestMapping(value="/addStatus", method=RequestMethod.GET)
	ModelAndView addStatus(ModelAndView mav) {
		
		mav.setViewName("app.addStatus");
		
		StatusUpdate statusUpdate = new StatusUpdate();
		
		//mapping the status update object to the model
		mav.getModel().put("statusUpdate", statusUpdate);
		
		
		
		return mav;
	}
	
	
	@RequestMapping(value="/addStatus", method=RequestMethod.POST)
	ModelAndView addStatus(ModelAndView mav, StatusUpdate statusUpdate) {
		
		mav.setViewName("app.addStatus");
		
		statusUpdateService.save(statusUpdate);
		
		return mav;
	}
	

}
