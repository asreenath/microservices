package exp.microservices.productservice.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Sairam on 7/9/17.
 */
public class Product {
    @ApiModelProperty(notes = "The product ID")
    private int productId;
    @ApiModelProperty(notes = "The product name")
    private String name;
    @ApiModelProperty(notes = "The product weight")
    private int weight;

    public Product() {

    }

    public Product(int productId, String name, int weight) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
