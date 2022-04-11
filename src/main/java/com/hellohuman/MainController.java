
package com.hellohuman;

//import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(HttpSession session)
	{
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount += 1;
			session.setAttribute("count", currentCount);
		}
		return "index";
	}
	@GetMapping("/counter")
	public String showCount(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "showCount";
	}
	@GetMapping("/counterby2")
	public String show2(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		currentCount += 2;
		model.addAttribute("countToShow", currentCount);
		return "showCount2";
	}
}

