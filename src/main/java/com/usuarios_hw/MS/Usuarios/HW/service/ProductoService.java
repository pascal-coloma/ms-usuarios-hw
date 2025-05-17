package com.usuarios_hw.MS.Usuarios.HW.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.usuarios_hw.MS.Usuarios.HW.repository.*;
import org.springframework.stereotype.Service;
import java.util.List;
import com.usuarios_hw.MS.Usuarios.HW.model.*;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listar(){
        return productoRepository.findAll();
    }

    public Producto findById(Long id){
        return productoRepository.findById(id).get();
    }

    public List<Producto> findByProveedor(String proveedor){
        return productoRepository.findByProveedor(proveedor);
    }

    public List<Producto> saveLista(List<Producto> listaProductos){
        return productoRepository.saveAll(listaProductos);
    }
    
}
