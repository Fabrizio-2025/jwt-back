package com.rf.api_examen_final_202020245.controller;

import com.rf.api_examen_final_202020245.dto.CertificacionDto;
import com.rf.api_examen_final_202020245.entities.Certificacion;
import com.rf.api_examen_final_202020245.entities.User;
import com.rf.api_examen_final_202020245.service.CertificacionService;
import com.rf.api_examen_final_202020245.service.UserService;
import com.rf.api_examen_final_202020245.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificaciones")
public class CertificacionController {

    @Autowired
    private CertificacionService certificacionService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Certificacion>> getAllCertifications(Authentication authentication) {
        Long userId = ((UserDetailsImpl) authentication.getPrincipal()).getId();
        List<Certificacion> certificaciones = certificacionService.getCertificationsByUserId(userId);
        return ResponseEntity.ok(certificaciones);
    }

    @PostMapping
    public ResponseEntity<Certificacion> createCertification(@RequestBody CertificacionDto certificacionDto, Authentication authentication) {
        Long userId = ((UserDetailsImpl) authentication.getPrincipal()).getId();
        Certificacion certificacion = new Certificacion();
        certificacion.setNombre(certificacionDto.getNombre());
        certificacion.setFecha(certificacionDto.getFecha());
        certificacion.setTipo(certificacionDto.getTipo());
        certificacion.setPrecio(certificacionDto.getPrecio());
        User user = userService.getUserById(userId);
        certificacion.setUser(user);
        Certificacion newCertificacion = certificacionService.saveCertification(certificacion);
        return ResponseEntity.ok(newCertificacion);
    }
}