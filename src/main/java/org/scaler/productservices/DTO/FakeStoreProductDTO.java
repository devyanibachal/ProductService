package org.scaler.productservices.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {

    int id;
    String title;
    String price;
    String category;
    String description;
    String image;
}
