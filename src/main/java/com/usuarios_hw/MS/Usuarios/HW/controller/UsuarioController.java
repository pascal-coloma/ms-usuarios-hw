package com.usuarios_hw.MS.Usuarios.HW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.usuarios_hw.MS.Usuarios.HW.model.Usuario;
import com.usuarios_hw.MS.Usuarios.HW.service.PedidoClient;
import com.usuarios_hw.MS.Usuarios.HW.dto.PedidoDto;
import com.usuarios_hw.MS.Usuarios.HW.service.UsuarioService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/hoppyware/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private final PedidoClient pedidoClient;

    public UsuarioController(PedidoClient pedidoClient){
        this.pedidoClient = pedidoClient;
    }

    @GetMapping("/pedidos/buscarId/{id}")
    public ResponseEntity<PedidoDto> getPedido(@PathVariable Long id){
        PedidoDto pedido = pedidoClient.obtenerPedidoPorId(id);
        return ResponseEntity.ok(pedido);
    }
    

    @GetMapping()
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();   
        }
        return ResponseEntity.ok(usuarios);
    }
    
    @PostMapping("/guardarLista")
    public ResponseEntity<List<Usuario>> guardar(@RequestBody List<Usuario> listaUsuarios){
        List<Usuario> nuevaLista = usuarioService.saveLista(listaUsuarios);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLista);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Usuario> guardarUsr(@RequestBody Usuario usuario){
        Usuario newUsr = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUsr);
    
    }
    
    
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

    @GetMapping("/buscarRun")
    public ResponseEntity<Usuario> buscarRun(@RequestParam String run){
        try{
            Usuario usuario = usuarioService.findByRun(run);
            return ResponseEntity.ok(usuario);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            usuarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }


    
    
    

}
