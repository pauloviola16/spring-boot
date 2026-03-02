package com.example.exerciciossb.controllers;

import com.example.exerciciossb.model.entities.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @GetMapping(path = "/qualquer")
    public Cliente obterCliente(){
        return new Cliente(20, "Paulo César", "123.456.678.99");
    }

    @GetMapping(path = "/{id}")
    public Cliente obterClientePorId1 (@PathVariable int id){
        return new Cliente(id, "Maria" , "903.121.313.44");
    }

    @GetMapping
    public Cliente obterClientePorId2 (@RequestParam(name = "id") int id){
        return new Cliente(id, "João" , "113.441.313.44");
    }
}
