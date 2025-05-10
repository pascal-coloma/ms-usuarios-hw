package com.usuarios_hw.MS.Usuarios.HW.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.usuarios_hw.MS.Usuarios.HW.dto.PedidoDto;

@Service
public class PedidoClient {

    private final RestTemplate restTemplate;

    public PedidoClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public PedidoDto obtenerPedidoPorId(Long id){
        String url = "http://localhost:8080/hoppyware/v1/pedidos/buscarId/" + id;
        return restTemplate.getForObject(url, PedidoDto.class);
    }
}
