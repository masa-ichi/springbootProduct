package com.sample.service;

import com.sample.entity.Product;
import com.sample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product>findAll(){
        return productRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.delete(id);
    }

    public Product find(Long id){
        return productRepository.findOne(id);
    }

}
