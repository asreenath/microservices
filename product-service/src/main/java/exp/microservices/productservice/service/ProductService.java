package exp.microservices.productservice.service;

/**
 * Created by Sairam on 7/9/17.
 */

import exp.microservices.productservice.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
@RequestMapping("/productservice/v1")
@Api(value="productservice", description="Operations pertaining to products in product service")
public class ProductService {

    *//**
     * Sample usage: curl $HOST:$PORT/product/1
     *
     * @param productId
     * @return
     *//*
    @ApiOperation(value = "View product details", response = Product.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved product"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/fetchProduct/{productId}", method= RequestMethod.GET,produces = "application/json")
    public Product getProduct(@PathVariable int productId) {
        return new Product(productId, "name", 123);
    }
}*/

@RestController
public class ProductService {//implements IProductService{
    /**
     * Sample usage: curl $HOST:$PORT/product/1
     *
     * @param productId
     * @return
     */
    @RequestMapping("/product/{productId}")
    public Product getProduct(@PathVariable int productId) {
        return new Product(productId, "name", 123);
    }
}