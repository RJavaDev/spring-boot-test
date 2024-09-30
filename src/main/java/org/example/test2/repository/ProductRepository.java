package org.example.test2.repository;

import org.example.test2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByProductIdAndTextureIdAndWorkshopId(Long productId, Long textureId, Long workshopId);
}
