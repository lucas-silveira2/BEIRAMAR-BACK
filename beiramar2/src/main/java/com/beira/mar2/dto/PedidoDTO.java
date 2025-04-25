package com.beira.mar2.dto;

public record PedidoDTO(
        Integer idMesa,
        Integer formaPagamento,
        Double vlPedido,
        Boolean feedBack
) {}