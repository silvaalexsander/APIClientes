package io.github.silvaalexsander.service;

import io.github.silvaalexsander.domain.entity.Pedido;
import io.github.silvaalexsander.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
}
