package com.rf.api_examen_final_202020245.dto;

import lombok.*;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CertificacionDto {
    private Long id;
    private String nombre;
    private LocalDate fecha;
    private String tipo;
    private Double precio;
    private Long userId;

}
