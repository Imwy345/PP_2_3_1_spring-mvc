package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired()
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String test(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }
    @GetMapping("/{id}")
    public String getUser (@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getIdUser(id));
        return "user";
    }

    @GetMapping("/new")
    public String addUser(User user) {
        return "newUser";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newUser";
        } else {
            userService.addUser(user);
            return "redirect:/";
        }
    }

    @GetMapping("{id}/update")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute(userService.getIdUser(id));
        return "updateUser";
    }

    @PatchMapping("/update")
    public String update( @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUser";
        } else {
            userService.updateUser(user);
            return "redirect:/";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }

}
