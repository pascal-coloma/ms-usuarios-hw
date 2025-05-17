package com.usuarios_hw.MS.Usuarios.HW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.usuarios_hw.MS.Usuarios.HW.model.*;
import java.util.List;


public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByProveedor(String proveedor);
}
