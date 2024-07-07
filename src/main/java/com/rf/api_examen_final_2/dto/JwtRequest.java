package com.rf.api_examen_final_2.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
