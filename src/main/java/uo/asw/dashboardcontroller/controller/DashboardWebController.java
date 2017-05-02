package uo.asw.dashboardcontroller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



import uo.asw.dbmanagement.GetComments;
import uo.asw.dbmanagement.GetSuggestions;
import uo.asw.dbmanagement.model.Comment;
import uo.asw.dbmanagement.model.Suggestion;


@Controller
public class DashboardWebController {

	@Autowired
	private GetSuggestions getSuggestions;

	@Autowired
	private GetComments getComments;
	
    @RequestMapping("/dashboard")
    public String enterDashboard(Model model){
    	List<Suggestion> suggestions = getSuggestions
				.getSuggestions();
		List<Comment> comments = getComments.getComments();
		model.addAttribute("suggestions", suggestions);
		model.addAttribute("comments", comments);
        return "panel";
    }

	@RequestMapping(value = "/dashboard/suggestion/{id}")
	public String getDashboardSuggestion(@PathVariable(value = "id") Long id,
			Model model) {
		Suggestion s = getSuggestions.getSuggestionById(id);
		model.addAttribute("suggestion", s);
		return "/detailSuggestion";
	}

	@RequestMapping(value = "/dashboard/comment/{id}")
	public String getDashboardComment(@PathVariable(value = "id") Long id,
			Model model) {
		Comment c = getComments.getCommentById(id);
		model.addAttribute("comment", c);
		return "/detailComment";
	}
    
}
