package uo.asw.login;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import uo.asw.dbmanagement.GetParticipant;
import uo.asw.dbmanagement.GetUser;
import uo.asw.dbmanagement.model.Citizen;
import uo.asw.dbmanagement.model.User;

@Controller
public class LoginController {

	@Autowired
	private GetParticipant getParticipant;

	@Autowired
	private GetUser getUser;

	/**
	 * Recibe los datos de login del usuario, busca si exite ese usuario y en
	 * caso de exitir pasa a la siguiente página que muestra la informacion en
	 * caso contrario muestra la página de error, en caso de no ser un
	 * participante se comprueba si es otro usuario (politico o admin) y se
	 * reeenvia a la vista adecuada
	 * 
	 * @param session
	 *            mantiene la sesion
	 * @param user
	 *            nombre del login
	 * @param password
	 *            contresena del usuario
	 * @param model
	 * @return view si exito, error si fracaso
	 */
	@RequestMapping(value = "/acceso", method = RequestMethod.POST)
	public String showInfo(HttpSession session, @RequestParam String user,
			@RequestParam String password, Model model) {

		Citizen c = null;
		User u = null;

		if (user != null && password != null) {
			c = getParticipant.getParticipant(user, password);
			if (c != null) {
				session.setAttribute("citizen", c);
				model.addAttribute("resultado", "Bienvenid@ " + c.getName());
				return "viewParticipant";
			} else {
				// Buscamos si es politico/admin
				u = getUser.getUser(user, password);
				if (u != null) {
					session.setAttribute("user", u);
					return "redirect:/dashboard";
				}
			}
		}
		return "error";

	}
}
