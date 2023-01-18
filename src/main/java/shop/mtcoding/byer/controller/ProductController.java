package shop.mtcoding.byer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping({ "/", "/product" })
    public String home() {
        return "product/list";
    }
}
