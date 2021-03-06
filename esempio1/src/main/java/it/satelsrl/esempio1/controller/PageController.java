/**
 * 
 */
package it.satelsrl.esempio1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author master
 *
 */
@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("greeting","Benvenuto to spring");
		mv.addObject("title","Home");
		// passing la lista delle categorie
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickHome",true);
		return mv;
	}
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("title","Chi siamo noi...");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("title","Contatti");
		mv.addObject("userClickContact",true);
		return mv;
	}

//	@RequestMapping(value= "/test")
//	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting) {
//		if (greeting == null) {
//			greeting = "Ciao a tutti";
//		}
//		ModelAndView mv = new ModelAndView ("page");
//		mv.addObject("greeting",greeting);
//		
//		return mv;
//		
//	}
	@RequestMapping(value= "/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String greeting) {
		if (greeting == null) {
			greeting = "Ciao a tutti";
		}
		ModelAndView mv = new ModelAndView ("page");
		mv.addObject("greeting",greeting);
		
		return mv;
		
	}
}
