package com.rf.api_examen_final_202020245.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
