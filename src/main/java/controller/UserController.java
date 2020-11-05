package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import po.User;
import service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(@ModelAttribute User user, Model model, HttpSession session) {
        return userService.register(user, model, session);
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute User user,Model model, HttpSession session) {
        return userService.login(user, model, session);
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
