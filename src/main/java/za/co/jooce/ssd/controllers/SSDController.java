package za.co.jooce.ssd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import za.co.jooce.ssd.domain.User;
import za.co.jooce.ssd.repository.UserRepository;
import za.co.jooce.ssd.util.PasswordEncoderUtil;

import java.util.List;

@Controller
public class SSDController {

    private final UserRepository userRepository;

    public SSDController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/process_registration")
    public String processRegistration(User user) {
        user.setPassword(PasswordEncoderUtil.encodePassword(user.getPassword()));
        userRepository.save(user);
        return "registration_success";
    }

    @GetMapping("/list_users")
    public String viewUsersList(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "users";
    }
}
