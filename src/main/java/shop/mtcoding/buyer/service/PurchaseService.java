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
    public int 구매하기(int principalId, int productId, int count) {
        // 2. 구매 히스토리 남기기(insert)
        int result = purchaseRepository.insert(principalId, productId, count);
        if (result != 1) {
            return -1;
        }

        // 3. 상품 존재 확인 -> 존재가 있는 걸로 변경이 가능하게 만든다
        // prodcutId를 아무거나 날릴 수 있다(신뢰할 수 없다)->검증이 필요하다
        Product product = productRepository.findById(productId);
        if (product == null) {
            return -1;
        }
        // 4. 수량 체크
        if (product.getQty() < count) {
            return -1;
        }
        // 5. 재고 수량 변경
        int result2 = productRepository.updateById(product.getId(), product.getName(), product.getPrice(),
                product.getQty() - count);

        if (result2 != 1) {
            return -1;
        }
        return 1;
    }
    // commit
}
