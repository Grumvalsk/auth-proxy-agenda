package com.grumvalsky.authagenda.controller;

import com.grumvalsky.authagenda.dto.ImpegnoDTO;
import com.grumvalsky.authagenda.service.ImpegnoService;
import com.grumvalsky.authagenda.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class ImpegnoController {

    @Autowired
    private ImpegnoService service;
    @RequestMapping(value = "/inserisci", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String inserisci(){
        String jwt= JwtUtil.generateToken("gino");
        return jwt;
    }
}
