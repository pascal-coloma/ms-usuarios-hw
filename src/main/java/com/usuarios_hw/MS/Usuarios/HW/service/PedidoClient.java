package com.usuarios_hw.MS.Usuarios.HW.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

import com.usuarios_hw.MS.Usuarios.HW.dto.*;


@FeignClient(name = "pedido-service", url= "http://54.165.86.40:8081/hoppyware/v1/pedido")
public interface PedidoClient {

    // Busqueda de pedidos por ID de pedido, a traves del cliente, fijando endpoint al microservicio de pedidos
    @GetMapping("/{id}")
    PedidoDto getPedidoPorId(@PathVariable("id") Long id);

    @GetMapping("/{id}/pedidos-cliente")
    List<PedidoDto> getPedidoPorUsr(@PathVariable("id") Long id);


    
}
