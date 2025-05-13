package com.usuarios_hw.MS.Usuarios.HW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.usuarios_hw.MS.Usuarios.HW.dto.PedidoDto;
import com.usuarios_hw.MS.Usuarios.HW.model.Usuario;
import com.usuarios_hw.MS.Usuarios.HW.service.UsuarioService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Controlador REST para definir endpoints del microservicio
// El uso de ResponseEntity afina las respuestas de estado HTTP
@RestController
@RequestMapping("/hoppyware/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Listado de todos los usuarios
    @CrossOrigin(origins = "http://localhost:5500")
    @GetMapping()
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();   
        }
        return ResponseEntity.ok(usuarios);
    }
    
    // Busqueda de Usuarios por su ID como variable en la URL
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> busquedaPorId(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioService.findById(id);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Guardado de usuarios en un cuerpo de JSON con mas de un elemento
    @PostMapping("/guardarLista")
    public ResponseEntity<List<Usuario>> guardar(@RequestBody List<Usuario> listaUsuarios){
        List<Usuario> nuevaLista = usuarioService.saveLista(listaUsuarios);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLista);
        // Usar HttpStatus.CREATED devolvera un codigo 201 que significa la creacion de un nuevo elemento 
    }

    // Guardado de usuario cuando el cuerpo contiene solo un usuario
    @PostMapping("/guardar")
    public ResponseEntity<Usuario> guardarUsr(@RequestBody Usuario usuario){
        Usuario newUsr = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUsr);
    
    }
    
    // Actualizacion de los campos de un usuario
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        try {
            Usuario usr = usuarioService.findById(id);
            usr.setId(usuario.getId());
            usr.setRun(usuario.getRun());
            usr.setDvrun(usuario.getDvrun());
            usr.setPnombre(usuario.getPnombre());
            usr.setSnombre(usuario.getSnombre());
            usr.setAppaterno(usuario.getAppaterno());
            usr.setApmaterno(usuario.getApmaterno());
            usr.setFecha_nacto(usuario.getFecha_nacto());
            usr.setCorreo(usuario.getCorreo());
            usr.setNum_telefono(usuario.getNum_telefono());
            
            usuarioService.save(usr);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Busqueda de usuarios por RUN, devuelve solo un resultado ya que no deben existir registros de RUT repetidos
    @GetMapping("/buscarRun")
    public ResponseEntity<Usuario> buscarRun(@RequestParam String run){
        try{
            Usuario usuario = usuarioService.findByRun(run);
            return ResponseEntity.ok(usuario);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminacion de usuarios por su ID 
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            usuarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    // Busqueda de pedidos por su ID, esto a traves de la comunicacion con el microservicio de pedidos
    @GetMapping("/pedidoPorId/{id}")
    public ResponseEntity<PedidoDto> getPedidoPorId(@PathVariable Long id) {
        try {
            PedidoDto pedido = usuarioService.getPedidoPorId(id);
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Busqueda de pedidos por id de usuario, comunicacion a traves de Feign Client
    @GetMapping("/pedidoPorUsr")
    public ResponseEntity<List<PedidoDto>> getPedidoPorUsr(@RequestParam Long id){
        try {
            List<PedidoDto> pedidosPorUsr = usuarioService.getPedidoPorUsr(id);
            return ResponseEntity.ok(pedidosPorUsr);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
