package com.rf.api_examen_final_202020245.service;

import com.rf.api_examen_final_202020245.dto.CertificacionSummaryDto;
import com.rf.api_examen_final_202020245.entities.Certificacion;
import com.rf.api_examen_final_202020245.repositories.CertificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return new CertificacionSummaryDto(cantidad, precioTotal);
    }

}
