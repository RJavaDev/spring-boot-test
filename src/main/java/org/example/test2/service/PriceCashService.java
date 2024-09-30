package org.example.test2.service;

import lombok.RequiredArgsConstructor;
import org.example.test2.entity.Product;
import org.example.test2.repository.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceCashService {

    private final ProductRepository productRepository;

    @Cacheable(cacheNames = "product", key = "#key", sync = true)
    public Product getProductPriceFromCache(String key) {
        return fetchProductPriceFromDatabase(key);
    }

    public Product fetchProductPriceFromDatabase(String key) {
        String[] parts = key.split(":");
        Long productId = Long.valueOf(parts[0]);
        Long textureId = Long.valueOf(parts[1]);
        Long workshopId = parts.length > 2 && !parts[2].equals("null") ? Long.valueOf(parts[2]) : null;

        return productRepository.findByProductIdAndTextureIdAndWorkshopId(productId, textureId, workshopId);
    }
}
