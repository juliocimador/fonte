package com.crud.cadastro.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.crud.cadastro.controller.dto.UsuarioResponse;
import com.crud.cadastro.repository.UsuarioRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    //Não sei a anotação Autowired para falitar o processo de teste com construtor
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/")
    public List<UsuarioResponse> findAll(){
        var usuario = usuarioRepository.findAll();
        return usuario
                .stream()
                .map((u) -> UsuarioResponse.converter(u))
                .collect(Collectors.toList());   
    }
}
