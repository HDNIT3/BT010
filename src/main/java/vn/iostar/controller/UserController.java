package vn.iostar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import vn.iostar.entity.User;
import vn.iostar.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, 
                          BindingResult result, 
                          Model model) {
        // Kiểm tra validation errors
        if (result.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi!");
            return "register";
        }
        
        // Kiểm tra username đã tồn tại
        if (userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("message", "Tên đăng nhập đã tồn tại!");
            return "register";
        }
        
        // Lưu user
        try {
            userService.save(user);
            model.addAttribute("success", "Đăng ký thành công!");
            return "redirect:/login?success";
        } catch (Exception e) {
            model.addAttribute("message", "Có lỗi xảy ra: " + e.getMessage());
            return "register";
        }
    }
}