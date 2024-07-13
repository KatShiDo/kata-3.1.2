package kata.__1_2.controller;

import kata.__1_2.domain.User;
import kata.__1_2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String home(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/users/save")
    public String addUserForm(ModelMap model) {
        var user = new User();
        model.addAttribute("user", user);
        return "users.save";
    }

    @PostMapping("/users/save")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/update")
    public String updateUserForm(ModelMap model, @RequestParam Long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "users.update";
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
