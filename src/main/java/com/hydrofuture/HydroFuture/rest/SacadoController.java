package com.hydrofuture.HydroFuture.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class SacadoController {

    @GetMapping("/status")
    public HttpStatus consultarStatus(){
        return HttpStatus.OK;
    }
}
