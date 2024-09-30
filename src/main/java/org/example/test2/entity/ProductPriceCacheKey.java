package org.example.test2.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class ProductPriceCacheKey implements Serializable {
    private Long productId;
    private Long textureId;
    private Long workshopId; // optional

    public ProductPriceCacheKey(Long productId, Long textureId, Long workshopId) {
        this.productId = productId;
        this.textureId = textureId;
        this.workshopId = workshopId; // can be null
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPriceCacheKey that = (ProductPriceCacheKey) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(textureId, that.textureId) &&
                Objects.equals(workshopId, that.workshopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, textureId, workshopId);
    }

    @Override
    public String toString() {
        return productId + ":" + textureId + ":" + (workshopId != null ? workshopId : "null");
    }
}

