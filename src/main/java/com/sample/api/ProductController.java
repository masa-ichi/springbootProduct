package com.sample.api;


import com.sample.entity.Product;
import com.sample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    List<Product> getProduct(){
        return productService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Product insertProduct(@Validated @RequestBody Product product){
        return productService.save(product);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    Product updateProduct(@PathVariable("id") Long id, @Validated @RequestBody Product product){
        product.setId(id);
        return productService.save(product);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Product getProduct(@PathVariable("id") Long id) {
        return productService.find(id);
    }

}
