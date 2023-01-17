package shop.mtcoding.byer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/test")
    private String test() {
        return "test";
    }
}
