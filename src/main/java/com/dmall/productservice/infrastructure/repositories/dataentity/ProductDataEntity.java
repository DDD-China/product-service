
package com.dmall.productservice.infrastructure.repositories.dataentity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@Entity
@Table(name = "product")
public class ProductDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name = null;

    @Column
    private String description = null;

    @Column
    private BigDecimal price = null;

    @Column
    private Boolean isOnSale = null;
}

