package com.rf.api_examen_final_2.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CertificacionSummaryDto {
    private int cantidad;
    private double precioTotal;
    private String certificadoMasUsado1;
    private long cantidadCertificadoMasUsado1;
    private String certificadoMasUsado2;
    private long cantidadCertificadoMasUsado2;
}
