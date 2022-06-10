package com.complexivo3.vuelovg1c1.service;

import com.complexivo3.vuelovg1c1.dto.PedidoRequest;
import com.complexivo3.vuelovg1c1.dto.PedidoResponse;
import com.complexivo3.vuelovg1c1.exception.NotFoundException;
import com.complexivo3.vuelovg1c1.mapper.PedidoMapper;
import com.complexivo3.vuelovg1c1.model.*;
import com.complexivo3.vuelovg1c1.repository.IPedidoRepository;
import com.complexivo3.vuelovg1c1.repository.IUCharterRepository;
import jdk.internal.icu.lang.UCharacter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PedidoService implements IPedidoService{

    private final IPedidoRepository iPedidoRepository;
    private final IUCharterRepository iuCharterRepository;

    @Transactional(readOnly = true)
    @Override
    public PedidoResponse findByPedidoId(Long id) {
        Pedido pedido= iPedidoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un pedido con id: " + id));
        return PedidoMapper.topedidoResponse(pedido);
    }

    @Transactional
    @Override
    public void guardarPedido(PedidoRequest pedidoRequest) {
        Pedido p=PedidoMapper.topedido(pedidoRequest);
        UsuarioCharter uch= iuCharterRepository.findById(pedidoRequest.getId_charter())
                .orElseThrow(() -> new NotFoundException("No existe un cliente charter con id: " + pedidoRequest.getId_charter()));
        p.setUsuarioCharter(uch);
        Pedido v= iPedidoRepository.save(p);
    }

    @Transactional
    @Override
    public PedidoResponse deltevyIdPedido(Long id) {
        Pedido p= iPedidoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe un pedido  con id: " + id));
        iPedidoRepository.delete(p);
        return PedidoMapper.topedidoResponse(p);
    }

    @Transactional
    @Override
    public Boolean updatePedido(PedidoRequest pedidoRequest) {
        Optional<Pedido> ur=iPedidoRepository.findById(pedidoRequest.getId());
        if (ur.isPresent()) {
            ur.get().setFecha(new Date(pedidoRequest.getFecha().getTime()+(1000 * 60 * 60 * 24)));
            ur.get().setRuta(pedidoRequest.getRuta());
            ur.get().setEstado(pedidoRequest.isEstado());
            UsuarioCharter uch= iuCharterRepository.findById(pedidoRequest.getId_charter())
                    .orElseThrow(() -> new NotFoundException("No existe un cliente charter con id: " + pedidoRequest.getId_charter()));
            ur.get().setUsuarioCharter(uch);

            try {
                Pedido pedido = iPedidoRepository.save(ur.get());
                return true;
            } catch (Exception ex) {
                throw new  NotFoundException("No existe un pedido con id: " + pedidoRequest.getId());
            }
        }else{
            throw new  NotFoundException("No existe un pedido con id: " + pedidoRequest.getId());
        }
    }
}
