package com.hydrofuture.HydroFuture.rest;

import com.hydrofuture.HydroFuture.application.model.Usuario;
import com.hydrofuture.HydroFuture.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class CedenteController {

    @Autowired
    private UsuarioService cadastroUsuarioService;

    //TODO Cadastrar um Usuario
    @PostMapping("/cadastrar")
    public HttpEntity<Object> cadastrarUsuario(@RequestBody Usuario usuario){
        return cadastroUsuarioService.cadastrarUsuario(usuario);
    }

    @GetMapping("/status")
    public HttpStatus consultarStatus(){
        return HttpStatus.OK;
    }

    @GetMapping("/teste")
    public String teste(){
        return "Integração ok!";
    }
}
