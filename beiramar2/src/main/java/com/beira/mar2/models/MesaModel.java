package com.beira.mar2.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mesas")
@Data
public class MesaModel {

    @Id
    private Integer idMesa;

    private Double vlTotalPedido;
}