package com.usuarios_hw.MS.Usuarios.HW.repository;

import com.usuarios_hw.MS.Usuarios.HW.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    @Query(value = "SELECT * FROM usuario WHERE numrun =:numrun", nativeQuery = true)
    Usuario findByRun(String run);



}
