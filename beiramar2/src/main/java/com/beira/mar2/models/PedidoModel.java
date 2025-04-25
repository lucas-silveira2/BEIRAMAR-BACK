package com.beira.mar2.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pedidos")
@Data
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    private Integer idMesa;

    private Integer formaPagamento;

    private Double vlPedido;

    private Boolean feedBack;
}