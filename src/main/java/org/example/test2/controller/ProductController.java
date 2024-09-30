package org.example.test2.controller;


import lombok.RequiredArgsConstructor;
import org.example.test2.entity.Product;
import org.example.test2.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get/all")
    ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);

    }

    @GetMapping("/get/{id}")
    ResponseEntity<Product> getById(@PathVariable int id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping("/get/property/{productId}/{textureId}/{workshopId}")
    ResponseEntity<Product> getById(@PathVariable Long productId, @PathVariable Long textureId, @PathVariable Long workshopId){

        return ResponseEntity.ok(productService.getProductPrice(productId,textureId,workshopId));
    }

    @PostMapping("/add")
    ResponseEntity<String> add(@RequestBody Product product){
        productService.add(product);
        return new ResponseEntity<>("Added",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable int id){
        productService.delete(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> update(@PathVariable int id,@RequestBody Product product){
        productService.update(id,product);
        return new ResponseEntity<>("Updated",HttpStatus.OK);

    }

}