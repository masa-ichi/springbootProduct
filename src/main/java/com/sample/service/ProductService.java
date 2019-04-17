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

    //全件検索
    public List<Product>findAll(){
        return productRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

    //登録
    public Product save(Product product){
        return productRepository.save(product);
    }

    //削除
    public void delete(Long id){
        productRepository.delete(id);
    }

    //1件検索（id指定）
    public Product find(Long id){
        return productRepository.findOne(id);
    }

}
