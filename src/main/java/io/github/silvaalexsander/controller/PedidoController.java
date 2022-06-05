package io.github.silvaalexsander.controller;

import io.github.silvaalexsander.domain.entity.Pedido;
import io.github.silvaalexsander.domain.repository.Pedidos;
import io.github.silvaalexsander.dto.PedidoDTO;
import io.github.silvaalexsander.service.PedidoService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody PedidoDTO dto) {
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }

//    //Buscar pedido por ID
//    @GetMapping(path = "{id}")
//    public Pedido getPedidoPorId(@PathVariable("id") Integer id){
//        return pedidos
//                .findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido nao encontrado"));
//    }
//
//    //Adicionar pedido
//    @PostMapping("{id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Pedido save(@RequestBody Pedido pedido){
//        return pedidos.save(pedido);
//    }
//
//    //Deletando Pedido
//    @DeleteMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable("id") Integer id){
//        pedidos.findById(id)
//                .map(pedido -> {
//                    pedidos.delete(pedido);
//                    return pedido;
//                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Pedido nao encontrado"));
//    }
//
//    //Atualizar Pedido
//    @PutMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void update(@PathVariable("id") Integer id, @RequestBody Pedido pedido){
//        pedidos
//                .findById(id)
//                .map(pedidoExistente ->{
//                    pedido.setId(pedidoExistente.getId());
//                    pedidos.save(pedido);
//                    return pedidoExistente;
//                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido nao encontrado"));
//    }
//
//    //Listando todos os pedidos
//    @GetMapping
//    public List<Pedido> find(Pedido filtro){
//        ExampleMatcher matcher = ExampleMatcher
//                .matching()
//                .withIgnoreCase()
//                .withStringMatcher(
//                        ExampleMatcher.StringMatcher.CONTAINING);
//        Example example = Example.of(filtro, matcher);
//        return pedidos.findAll(example);
//    }
}
