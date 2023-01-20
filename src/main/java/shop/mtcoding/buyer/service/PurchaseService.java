package shop.mtcoding.buyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.buyer.model.Product;
import shop.mtcoding.buyer.model.ProductRepository;
import shop.mtcoding.buyer.model.PurchaseRepository;

/*
 * @Controller, @RestController, @Mapper, @Service, @Component
 */
@Service // IoC 컨테이너 등록
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    // 독립성을 가진다
    // 비지니스로직은 순서도도 중요하다
    // 구매가 되고 히스토리가 남겨져야한다
    public int 구매하기(int principalId, int productId, int count) {
        // 1. 상품 존재 확인
        Product product = productRepository.findById(productId);
        if (product == null) {
            return -1;
        }
        // 2. 수량 체크
        if (product.getQty() < count) {
            throw new RuntimeException();
        }
        // 3. 재고 수량 변경
        int result2 = productRepository.updateById(product.getId(), product.getName(), product.getPrice(),
                product.getQty() - count);

        if (result2 != 1) {
            return -1;
        }
        // 4. 구매 히스토리 남기기(insert)
        int result = purchaseRepository.insert(principalId, productId, count);
        if (result != 1) {
            return -1;
        }
        return 1;
    }
    // commit
}
