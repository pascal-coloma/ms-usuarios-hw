package com.usuarios_hw.MS.Usuarios.HW.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.usuarios_hw.MS.Usuarios.HW.repository.UsuarioRepository;
import com.usuarios_hw.MS.Usuarios.HW.model.Usuario;
import java.util.List;


@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findByRun(String run){
        return usuarioRepository.findByRun(run);
    }

    
}
