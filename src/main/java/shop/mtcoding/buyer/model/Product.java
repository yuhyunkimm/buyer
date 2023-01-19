package shop.mtcoding.buyer.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.buyer.util.DataUtil;

@Setter
@Getter
public class Product {
    private int id;
    private String name;
    private int price;
    private int qty;
    private Timestamp createdAt;

    // createdAtString
    public String getCreatedAtString() {
        return DataUtil.format(createdAt);

    }
}
