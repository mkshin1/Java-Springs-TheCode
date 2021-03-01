package com.mike.TheCode;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;



@Controller
public class Controller {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/codeSubmission", method=RequestMethod.POST)
	public String codeSubmission(@RequestParam(value="input") String input, RedirectAttributes redirectAttributes, HttpSession session) {

		session.setAttribute("input", input); 
		
		if (input.equals("shin")) {
			System.out.print("Correct!");
			return "redirect:/code"; 
		} else {

			System.out.print("Try again!");
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
		}
		return "redirect:/";
	}
	
	@RequestMapping("/code") 
	public String success(HttpSession session, Model model) {
		String input = (String) session.getAttribute("input");
		System.out.println("success!");
        return "code.jsp";
	}
}