package shop.mtcoding.byer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.byer.model.Product;
import shop.mtcoding.byer.model.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping({ "/", "/product" })
    public String findAll(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        return "product/list";
    }

    @GetMapping("/product/{id}")
    public String detail(Model model, @PathVariable int id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            return "redirect:/notfound";
        } else {
            model.addAttribute("product", product);
            return "product/detail";
        }
    }

    @PostMapping("/product/{id}/update")
    public String update(@PathVariable int id, int qty) {

        Product product = productRepository.findById(id);
        int productQty = product.getQty() - qty;
        int rerult = productRepository.update(id, productQty);
        if (rerult == 1) {
            return "redirect:/";
        } else {
            return "redirect:/product/" + id;
        }
    }
}
