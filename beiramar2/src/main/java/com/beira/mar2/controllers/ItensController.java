package com.beira.mar2.controllers;

import com.beira.mar2.dto.ItensDTO;
import com.beira.mar2.models.ItensModel;
import com.beira.mar2.repositories.ItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/itens")
public class ItensController {

    @Autowired
    private ItensRepository itensRepository;

    @PostMapping
    public String adicionarItem(@RequestBody ItensDTO dto) {
        ItensModel item = new ItensModel();
        item.setIdPedido(dto.idPedido());
        item.setQtItem(dto.qtItem());
        itensRepository.save(item);
        return "Item adicionado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String removerItem(@PathVariable Integer id) {
        Optional<ItensModel> item = itensRepository.findById(id);
        if (item.isPresent()) {
            itensRepository.deleteById(id);
            return "Item removido com sucesso!";
        } else {
            return "Item não encontrado.";
        }
    }
}