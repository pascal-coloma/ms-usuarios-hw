package com.usuarios_hw.MS.Usuarios.HW.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.usuarios_hw.MS.Usuarios.HW.model.*;
import com.usuarios_hw.MS.Usuarios.HW.service.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/hoppyware/v1/productotest")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    
    
    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos(){
        List<Producto> listaProductos = productoService.listar();
        if (listaProductos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaProductos);
    }

    @PostMapping("/guardar")
    public ResponseEntity<List<Producto>> guardarLista(@RequestBody List<Producto> listaProductos){
        List<Producto> nuevaLista = productoService.saveLista(listaProductos);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLista);

    }
    
    
    
}
