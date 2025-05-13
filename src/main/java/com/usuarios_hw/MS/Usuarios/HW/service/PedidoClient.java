package com.usuarios_hw.MS.Usuarios.HW.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import com.usuarios_hw.MS.Usuarios.HW.dto.*;


@FeignClient(name = "pedido-service", url= "http://localhost:8080/hoppyware/v1/pedido")
public interface PedidoClient {

    // Busqueda de pedidos por ID de pedido, a traves del cliente, fijando endpoint al microservicio de pedidos
    @GetMapping("/buscarId/{id}")
    PedidoDto getPedidoPorId(@PathVariable("id") Long id);

    @GetMapping("/porUsuario")
    List<PedidoDto> getPedidoPorUsr(@RequestParam("id_usr") Long id);


    
}
