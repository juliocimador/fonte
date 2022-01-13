package com.crud.cadastro.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Collections;

import com.crud.cadastro.controller.dto.ClienteResponse;
import com.crud.cadastro.model.Cliente;
import com.crud.cadastro.repository.ClienteCustomRepository;
import com.crud.cadastro.repository.ClienteRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final ClienteCustomRepository clienteCustomRepository;

    public ClienteController(ClienteRepository clienteRepository, ClienteCustomRepository clienteCustomRepository){
        this.clienteRepository = clienteRepository;
        this.clienteCustomRepository = clienteCustomRepository;
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

    /*  Desativo e substituido pelo "/filtro"
    @GetMapping("/cpf")
    public List<ClienteResponse> pesquisarClienteCPF(@RequestParam("cpfcliente") String cpfCliente){
        System.out.println("cpf = "+ cpfCliente);
        return clienteRepository.findBycpfcliente(cpfCliente).stream().map(ClienteResponse::converter).collect(Collectors.toList());
        /*try {
            Cliente c = new Cliente();
            c = clienteRepository.findBycpfcliente(cpfCliente);
            if(c.getIdcliente()>0){
                return new ResponseEntity<>(c,HttpStatus.OK);
            }else{
                return new ResponseEntity("Erro: Usuário não encontrado!",HttpStatus.OK);
            }
                        
        } catch (Exception e) {
            return new ResponseEntity("Erro: Usuário não encontrado! " + e ,HttpStatus.EXPECTATION_FAILED);  
        }
    }*/


    @PutMapping("/cadastrar/")
    public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente c){
        if(!clienteRepository.findBycpfcliente(c.getCpfCliente()).isEmpty()){
            //System.out.println("Usuário já cadastrado!<br>");
            return new ResponseEntity<>("Usuário já cadastrado com o CPF:" +c.getCpfCliente() ,HttpStatus.OK);
        };
        try {
            c.setDtAtualizacaoCadastroCliente(new Date());
            c.setDtCadastroCliente(new Date());
            clienteRepository.save(c);    
            return new ResponseEntity<>("Usuario cadastrado com sucesso",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }    

    @PutMapping("/atualizar/{id}")
    public Optional<Object> atualizar(@RequestBody Cliente cliente){
        return clienteRepository.findById(cliente.getIdcliente())
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
    public ResponseEntity<String> excluirUsuario(@PathVariable Long id){
        try {
            clienteRepository.deleteById(id); 
            return new ResponseEntity<String>("Cadastro excluido com sucesso",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao excluir o usuário "+id+". Verifique o código informado.",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/filtro")
    public List<ClienteResponse> filtroPersonalizado(
        @RequestParam(name = "id", required =false) Long id,
        @RequestParam(name = "nome", required=false) String nome,
        @RequestParam(name = "cpf", required=false) String cpf){

        return this.clienteCustomRepository.find(id, nome, cpf)
                .stream()
                .map((c) -> ClienteResponse.converter(c))
                .collect(Collectors.toList());    
    }
}
