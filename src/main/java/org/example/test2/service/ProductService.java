package org.example.test2.service;

import lombok.RequiredArgsConstructor;
import org.example.test2.entity.Product;
import org.example.test2.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final PriceCashService priceCashService;

    @CacheEvict(cacheNames = "products", allEntries = true)
    public void add(Product product){
        productRepository.save(product);
    }

    @Caching(evict = { @CacheEvict(cacheNames = "product", key = "#id"), @CacheEvict(cacheNames = "products", allEntries = true) })
    public void delete(int id){
        productRepository.deleteById(id);
    }

    @Caching(evict = { @CacheEvict(cacheNames = "product", key = "#id"), @CacheEvict(cacheNames = "products", allEntries = true) })
    public void update(int id,Product product){
        Product productToUpdate = productRepository.findById(id).get();
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productRepository.save(productToUpdate);
    }

    public Product getProductPrice(Long productId, Long textureId, Long workshopId) {

        String str = productId+":"+textureId+":"+workshopId;

        return priceCashService.getProductPriceFromCache(str);
    }

    @Cacheable(cacheNames = "products")
    public List<Product> getAll(){
        System.out.println("DB");
        return productRepository.findAll();
    }


    @Cacheable(cacheNames = "product",key = "#id")
    public Product getById(int id){
        System.out.println("DB");
        return productRepository.findById(id).get();
    }
}
