package com.usuarios_hw.MS.Usuarios.HW.dto;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {

        private Long id;
        @JsonFormat(pattern = "dd-MM-yyyy")
        private Date fecha_pedido;
        private Integer estado;
        public String getEstado(){
                if (estado == null) return "Desconocido";
                return switch (estado) {
                        case 0 -> "Recibido";
                        case 1 ->"En proceso";
                        case 2 ->"Despachado";
                        default -> "Otro";              
                };
        }
        private List<DetallePedidoDTO> detalles;
        
}
