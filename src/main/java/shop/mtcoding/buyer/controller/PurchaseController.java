package shop.mtcoding.buyer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.buyer.model.ProductRepository;
import shop.mtcoding.buyer.model.PurchaseRepository;
import shop.mtcoding.buyer.model.User;
import shop.mtcoding.buyer.service.PurchaseService;

@Controller
public class PurchaseController {

    @Autowired
    private HttpSession session;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseService purchaseService;

    /*
     * 목적 : 1. 세션이 있는지 체크 / 2. 구매 히스토리 남기기(insert) / 3. 재고 수량 변경
     */

    @PostMapping("/purchase/insert")
    public String insert(int productId, int count) {
        // 1. 세션이 있는지 체크 => controller 역할
        // principal => 세션에서 들고오는 값(인증된 객체)
        // 아래 서비스파일로 비지니스로직을 옮기면 아래만 트렌젝션이 안걸리게된다
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/notfound";
        }
        // 2. 서비스 호출
        // 구매하기 정도만 트렌젝션 하겠다는 것(매우짧아짐)
        int result = purchaseService.구매하기(principal.getId(), productId, count);
        if (result == -1) {
            return "redirect:/notfound";
        }
        return "redirect:/";
    }
}
