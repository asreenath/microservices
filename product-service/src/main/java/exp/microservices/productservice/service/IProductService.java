package exp.microservices.productservice.service;

import exp.microservices.productservice.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sairam on 7/31/17.
 */
public interface IProductService {
    @RequestMapping(value = "/product/{productId}", method= RequestMethod.GET,produces = "application/json")
    Product getProduct(@PathVariable("productId") int productId);
}
