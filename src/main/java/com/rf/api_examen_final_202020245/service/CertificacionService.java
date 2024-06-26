package com.rf.api_examen_final_202020245.service;

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
}
