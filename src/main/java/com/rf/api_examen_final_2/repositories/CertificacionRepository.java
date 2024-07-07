package com.rf.api_examen_final_2.repositories;

import com.rf.api_examen_final_2.entities.Certificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificacionRepository extends JpaRepository<Certificacion, Long> {
    List<Certificacion> findByUserId(Long userId);
}
