package com.rf.api_examen_final_202020245.service;

import com.rf.api_examen_final_202020245.dto.CertificacionSummaryDto;
import com.rf.api_examen_final_202020245.entities.Certificacion;
import com.rf.api_examen_final_202020245.repositories.CertificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CertificacionService {

    @Autowired
    private CertificacionRepository certificacionRepository;

    public List<Certificacion> getCertificationsByUserId(Long userId) {
        return certificacionRepository.findByUserId(userId);
    }

    public Certificacion saveCertification(Certificacion certificacion) {
        return certificacionRepository.save(certificacion);
    }

    public List<Certificacion> getAllCertifications() {
        return certificacionRepository.findAll();
    }

    public CertificacionSummaryDto getUserCertificationsSummary(Long userId) {
        List<Certificacion> certificaciones = certificacionRepository.findByUserId(userId);

        int cantidad = certificaciones.size();
        double precioTotal = certificaciones.stream().mapToDouble(Certificacion::getPrecio).sum();

        Map<String, Long> certificadoCounts = certificaciones.stream()
                .collect(Collectors.groupingBy(Certificacion::getNombre, Collectors.counting()));

        List<Map.Entry<String, Long>> topCertificados = certificadoCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(2)
                .collect(Collectors.toList());

        String certificadoMasUsado1 = topCertificados.size() > 0 ? topCertificados.get(0).getKey() : null;
        long cantidadCertificadoMasUsado1 = topCertificados.size() > 0 ? topCertificados.get(0).getValue() : 0;

        String certificadoMasUsado2 = topCertificados.size() > 1 ? topCertificados.get(1).getKey() : null;
        long cantidadCertificadoMasUsado2 = topCertificados.size() > 1 ? topCertificados.get(1).getValue() : 0;

        return new CertificacionSummaryDto(cantidad, precioTotal, certificadoMasUsado1, cantidadCertificadoMasUsado1, certificadoMasUsado2, cantidadCertificadoMasUsado2);
    }

}
