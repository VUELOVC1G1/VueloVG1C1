package com.complexivo3.vuelovg1c1.mapper;

import com.complexivo3.vuelovg1c1.dto.PedidoRequest;
import com.complexivo3.vuelovg1c1.dto.PedidoResponse;
import com.complexivo3.vuelovg1c1.model.Pedido;

import java.util.Date;

public class PedidoMapper {

    public static Pedido topedido(PedidoRequest pedidoRequest){
        Pedido pedido=new Pedido();
        pedido.setId(pedidoRequest.getId());
        pedido.setEstado(pedidoRequest.isEstado());
        pedido.setFecha(new Date( pedidoRequest.getFecha().getTime()+(1000 * 60 * 60 * 24)));
        pedido.setRuta(pedidoRequest.getRuta());

        return pedido;
    }

    public static PedidoResponse topedidoResponse(Pedido pedido){
        PedidoResponse pedidoResponse=new PedidoResponse();
        pedidoResponse.setId(pedido.getId());
        pedidoResponse.setEstado(pedido.isEstado());
        pedidoResponse.setFecha(pedido.getFecha());
        pedidoResponse.setRuta(pedido.getRuta());
        pedidoResponse.setCharterId(pedido.getUsuarioCharter().getId());
        return pedidoResponse;
    }
}
