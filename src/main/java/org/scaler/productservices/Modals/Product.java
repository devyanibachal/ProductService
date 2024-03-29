package org.scaler.productservices.Modals;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private int id;
    private String title;
    private String price;
    private Category category;
    private String description;
    private String image;
}
