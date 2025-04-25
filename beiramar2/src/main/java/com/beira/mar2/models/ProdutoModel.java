package com.beira.mar2.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

public class ProdutoModel {
    @Entity
    @Table(name = "TBPRODUTO")
    public class ProductModel implements Serializable {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String NMProduto;
        private BigDecimal vlProduto;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}