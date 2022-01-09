package com.crud.cadastro.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.crud.cadastro.controller.dto.UsuarioResponse;
import com.crud.cadastro.model.Usuario;
import com.crud.cadastro.repository.UsuarioRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    //Não usei a anotação Autowired para falitar o processo de teste com construtor
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/")
    public List<UsuarioResponse> listarUsuarios(){
        var usuarios = usuarioRepository.findAll();
        return usuarios
                .stream()
                .map((u) -> UsuarioResponse.converter(u))
                .collect(Collectors.toList());   
    }

    @GetMapping("/{id}")
    public Optional<Object> pesquisarUsuPorId(@PathVariable("id") Long id){
        var usuario = usuarioRepository.findById(id);
        return usuario.map(Collections::singletonList);
    }

    @PostMapping
    public void cadastrarUsuario(@RequestBody Usuario u){
        usuarioRepository.save(u);
    }

    @PutMapping
    public void alterarUsuario(@RequestBody Usuario u){
        if (u.getIdUsuario()>0){
            usuarioRepository.save(u);
        }
    }

    @DeleteMapping
    public void excluirUsuario(@RequestBody Usuario u){
        usuarioRepository.delete(u);
    }
}
