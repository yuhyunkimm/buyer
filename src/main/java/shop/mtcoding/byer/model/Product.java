package shop.mtcoding.byer.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.byer.util.DataUtil;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private int price;
    private int qty;
    private Timestamp createdAt;

    public String getCreatedAtToString() {
        return DataUtil.format(createdAt);
    }
}
