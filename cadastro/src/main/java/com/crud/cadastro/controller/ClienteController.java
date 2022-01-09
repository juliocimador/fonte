package com.crud.cadastro.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Collections;

import com.crud.cadastro.controller.dto.ClienteResponse;
import com.crud.cadastro.model.Cliente;
import com.crud.cadastro.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/")
    public List<ClienteResponse> listarClientes(){
        var clientes = clienteRepository.findAll();
        return clientes
                .stream()
                .map((c) -> ClienteResponse.converter(c))
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public Optional<Object> pesquisarClienteId(@PathVariable("id") Long id){
        var cliente = clienteRepository.findById(id);
        return cliente.map(Collections::singletonList);
    }

    @GetMapping("/cpf/{cpfcliente}")
    public ResponseEntity<Optional<Cliente>> pesquisarClienteCPF(@PathVariable("cpfcliente") String cpfCliente){
        try {
            Cliente c = new Cliente();
            c = clienteRepository.findBycpfcliente(cpfCliente);
            return new ResponseEntity(c,HttpStatus.OK);            
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity("Erro: Usuário não encontrado!",HttpStatus.EXPECTATION_FAILED);  
        }
    }


    @PutMapping
    public String cadastrarCliente(@RequestBody Cliente c){
        if(getClienteCPF(c.getCpfCliente())){
            return "CPF já cadastrado";
        };
        try {
            c.setDtAtualizacaoCadastroCliente(new Date());
            c.setDtCadastroCliente(new Date());
            clienteRepository.save(c);    
            return "Usuario cadastrado com sucesso";
        } catch (Exception e) {
            //TODO: handle exception
            return e.toString();
        }
    }    
    @DeleteMapping
    public void excluirUsuario(@RequestBody Cliente c){
        try {
            clienteRepository.delete(c);    
        } catch (Exception e) {
            
        }
        
    }

    private boolean getClienteCPF(String cpf){
        Cliente c = new Cliente();
        c = clienteRepository.findBycpfcliente(cpf);
        if(c.getIdcliente()>0){
            return true;
        }else{
            return false;
        }

    }
}
