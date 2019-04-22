package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.entity.Course;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static final String COURSES_VIEW = "courses";
	
	private static final Log LOG = LogFactory.getLog(CourseController.class);

	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOG.info("Controlador " + "listAllCourses");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new Course());
		mav.addObject("courses",courseService.listAllCourses());
		return mav;
	}
	
	@PostMapping("/addcourse")
	//acá realmente debería recibir un CourseModel
	//la idea es que los controllers no manejen entities sino models
	//en el servicio recibiré este mismo model pero ahí lo convertiré en entity y luego trabajo con el
	//luego, para pasarlo del servicio al controller previamente lo transformo en model y lo paso
	public String addCourse(@ModelAttribute("course") Course course) {
		LOG.info("Controlador " + "addCourse" + " -- Parámetro: " + course);		
		courseService.addCourse(course);
		
		return "redirect:/courses/listcourses";
	}

}
