package com.crud.cadastro.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Collections;

import com.crud.cadastro.controller.dto.ClienteResponse;
import com.crud.cadastro.model.Cliente;
import com.crud.cadastro.repository.ClienteRepository;

import org.apache.catalina.connector.Response;
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
    public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente c){
        /*if(validaCpfCadastrado(c.getCpfCliente())){
            return new ResponseEntity<>("CPF já cadastrado",HttpStatus.NOT_MODIFIED);
        };*/
        try {
            c.setDtAtualizacaoCadastroCliente(new Date());
            c.setDtCadastroCliente(new Date());
            clienteRepository.save(c);    
            return new ResponseEntity("Usuario cadastrado com sucesso",HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }    

    @PutMapping("/atualizar/{id}")
    public Optional<Object> atualizarCadastroCli(@RequestBody Cliente cliente,@PathVariable Long id){
        return clienteRepository.findById(id)
                              .map(c->{
                                  c.setNomeCliente(cliente.getNomeCliente());
                                  c.setSexoCliente(cliente.getSexoCliente());
                                  c.setEmailCliente(cliente.getEmailCliente());
                                  c.setCpfCliente(cliente.getCpfCliente());
                                  c.setIdNacionalidade(cliente.getIdNacionalidade());
                                  c.setIdNaturalidade(cliente.getIdNacionalidade());
                                  c.setDtAtualizacaoCadastroCliente(new Date());
                                  //return ResponseEntity.ok().body(clienteRepository.save(c));
                                  clienteRepository.save(c);
                                  return ResponseEntity.ok();
                              });
    }


    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Long> excluirUsuario(@PathVariable Long id){
        try {
            clienteRepository.deleteById(id); 
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private boolean validaCpfCadastrado(String cpf){
        if(clienteRepository.findBycpfcliente(cpf).getCpfCliente().isEmpty()){
            return false;
        }else{
            return true;
        }

    }
}
