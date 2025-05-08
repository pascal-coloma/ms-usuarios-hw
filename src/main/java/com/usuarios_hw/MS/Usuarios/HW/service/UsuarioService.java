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

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).get();
    }

    public Usuario findByRun(String run){
        return usuarioRepository.findByRun(run);
    }

    public List<Usuario> saveLista(List<Usuario> listUsuarios){
        return usuarioRepository.saveAll(listUsuarios);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }
    
}
