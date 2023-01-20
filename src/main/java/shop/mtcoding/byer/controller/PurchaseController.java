package shop.mtcoding.byer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.byer.model.User;

@Controller
public class PurchaseController {

    @Autowired
    private HttpSession session;

    @PostMapping("/purchase/insert")
    public String insert(int productId, int count) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }
        return "redirect:/";
    }
}
