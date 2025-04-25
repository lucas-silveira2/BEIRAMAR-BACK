package com.beira.mar2.controllers;

import com.beira.mar2.models.MesaModel;
import com.beira.mar2.repositories.MesaRepository;
import com.beira.mar2.repositories.PedidoRepository;
import com.beira.mar2.models.PedidoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public String cadastrarMesa(@RequestBody MesaModel mesa) {
        mesaRepository.save(mesa);
        return "Mesa cadastrada com sucesso!";
    }

    @GetMapping
    public List<MesaModel> listarMesas() {
        return mesaRepository.findAll();
    }

    @GetMapping("/{id}/calcularTotalPedidos")
    public Double calcularTotalPedidos(@PathVariable Integer id) {
        List<PedidoModel> pedidos = pedidoRepository.findAll();
        double total = pedidos.stream()
                .filter(p -> p.getIdMesa().equals(id))
                .mapToDouble(PedidoModel::getVlPedido)
                .sum();
        return total;
    }
}