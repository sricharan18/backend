package com.simplify.marketplace.service.dto;

import java.io.Serializable;
import java.util.Objects;
import lombok.Data;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.simplify.marketplace.domain.Category} entity.
 */
 @Data
 public class CategoryDTO implements Serializable {

    private Long id;

    private String name;

    private Boolean isParent;

    private Boolean isActive;

    private CategoryDTO parent;

    private String createdBy;

    private LocalDate createdAt;

    private String updatedBy;

    private LocalDate updatedAt;
    
}
