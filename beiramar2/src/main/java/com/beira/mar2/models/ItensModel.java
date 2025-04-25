package com.beira.mar2.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "itens")
@Data
public class ItensModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItem;

    private Integer idPedido;

    private Integer qtItem;
}