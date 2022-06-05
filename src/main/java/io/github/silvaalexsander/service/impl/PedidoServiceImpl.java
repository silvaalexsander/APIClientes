package io.github.silvaalexsander.service.impl;

import io.github.silvaalexsander.domain.entity.Cliente;
import io.github.silvaalexsander.domain.entity.ItemPedido;
import io.github.silvaalexsander.domain.entity.Pedido;
import io.github.silvaalexsander.domain.entity.Produto;
import io.github.silvaalexsander.domain.repository.Clientes;
import io.github.silvaalexsander.domain.repository.ItensPedidos;
import io.github.silvaalexsander.domain.repository.Pedidos;
import io.github.silvaalexsander.domain.repository.Produtos;
import io.github.silvaalexsander.dto.ItemPedidoDTO;
import io.github.silvaalexsander.dto.PedidoDTO;
import io.github.silvaalexsander.exception.RegraNegocioException;
import io.github.silvaalexsander.service.PedidoService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos pedidoRepository;
    private final Clientes clienteRepository;
    private final Produtos produtosRepository;
    private final ItensPedidos itemsPedidoRepository;

    public PedidoServiceImpl(Pedidos pedidoRepository, Clientes clienteRepository, Produtos produtosRepository, ItensPedidos itemsPedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtosRepository = produtosRepository;
        this.itemsPedidoRepository = itemsPedidoRepository;
    }
    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente =  clienteRepository
                .findById(idCliente)
                .orElseThrow(()-> new RegraNegocioException("Codigo cliente invalido"));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemPedidos =  converterItems(pedido, dto.getItems());
        pedidoRepository.save(pedido);
        itemsPedidoRepository.saveAll(itemPedidos);
        pedido.setItemPedidos(itemPedidos);
        return pedido;
    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Nao eh possivel realizar um pedido sem items");
        }
        return items
                .stream()
                .map(dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtosRepository
                            .findById(idProduto)
                            .orElseThrow(() -> new RegraNegocioException("Codigo de produto invalido: " + idProduto));
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());
    }
}
