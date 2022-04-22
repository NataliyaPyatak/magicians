package ru.npyatak.magician.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ru.npyatak.magician.model.Role;
import ru.npyatak.magician.model.User;
import ru.npyatak.magician.repositiry.UserRepository;

/**
 *
 * @author npyatak
 * @since 26.02.2022
 */
@Controller
public class RegistrationController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String adduser(User user, Model model)
    {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null)
        {
            model.addAttribute("message", "User exists");
            return "registration";
        }
        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLoginPage()
    {
        return "login";
    }

    @GetMapping("/")
    public String getHomePage()
    {
        return "hello";
    }
}
