package com.hydrofuture.HydroFuture.service.impl;

import com.hydrofuture.HydroFuture.application.mapper.UsuarioMapperConverter;
import com.hydrofuture.HydroFuture.application.model.Usuario;
import com.hydrofuture.HydroFuture.application.model.entity.UsuarioEntity;
import com.hydrofuture.HydroFuture.repository.UsuarioRepository;
import com.hydrofuture.HydroFuture.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository cadastroUsuarioRepository;

    @Autowired
    private UsuarioMapperConverter usuarioConverter;

    @Override
    public HttpEntity<Object> cadastrarUsuario(Usuario usuario){
        if (!cadastroUsuarioRepository.findById(usuario.getId()).isPresent()){
            UsuarioEntity usuarioEntity = usuarioConverter.conversorEntidade(usuario);
            cadastroUsuarioRepository.save(usuarioEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(usuario);
        }
    }

    @Override
    public Optional<UsuarioEntity> consultarPeloId(String id) {
        return cadastroUsuarioRepository.findById(id);
    }

    @Override
    public void deletarUsuario(String id) {
        cadastroUsuarioRepository.deleteById(id);
    }

    @Override
    public void editarUsuario(String id, Usuario usuario) {

    }

}
