package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.PedidoRequest;
import com.complexivo3.vuelovg1c1.dto.PedidoResponse;

import java.util.List;


public interface IPedidoService {
    PedidoResponse findByPedidoId(Long id);
    void guardarPedido(PedidoRequest pedidoRequest);
    PedidoResponse deltevyIdPedido(Long id);
    Boolean updatePedido(PedidoRequest pedidoRequest);

    List<PedidoResponse> findAll();
}
