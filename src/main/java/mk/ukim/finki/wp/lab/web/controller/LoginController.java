package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.repository.jpa.UserRepositoryJPA;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserRepositoryJPA userRepositoryJPA;


    public LoginController(UserRepositoryJPA userRepositoryJPA){
        this.userRepositoryJPA = userRepositoryJPA;
    }

    @GetMapping
    public String getLoginPage(Model model) {

        return "login.html";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;
        try{

            if (request.getParameter("username")==null || request.getParameter("username").isEmpty()
                    || request.getParameter("password")==null || request.getParameter("password").isEmpty()) {
                throw new IllegalArgumentException();
            }
            user = userRepositoryJPA.findByUsernameAndPassword(request.getParameter("username"),
                    request.getParameter("password"));

            request.getSession().setAttribute("user", user);
            return "redirect:/balloons";
        }
        catch (IllegalArgumentException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }
    }
}

