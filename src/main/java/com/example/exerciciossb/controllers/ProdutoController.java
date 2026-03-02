package com.example.exerciciossb.controllers;

import com.example.exerciciossb.model.entities.Produto;
import com.example.exerciciossb.model.repositories.ProdutoRepository;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    /* 1 JEITO DE FAZER, MAS PODE DAR MAIS TRABALHO
    @PostMapping
    public Produto novoProduto (@RequestParam String nome ,
                                @RequestParam double preco,
                                @RequestParam double desconto){
        Produto produto = new Produto(nome, preco, desconto);
        produtoRepository.save(produto);
        return produto;
    } */


    // 2 - OUTRO JEITO MAIS SIMPLES DE FAZER, PASSA DIRETO O OBJETO COMO PARÂMETRO QUE O SPRING ENTENDE O QUE QUER FAZER
      @PostMapping
    public Produto novoProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }


        // obter todos os produtos cadastrados
        @GetMapping
        public Iterable<Produto> obterProdutos () {
            return produtoRepository.findAll();
        }

      // filtrar por pagina
      @GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
      public Iterable<Produto> obterProdutosPorPagina (@PathVariable int numeroPagina, @PathVariable int qtdePagina) {
          Pageable page = PageRequest.of(numeroPagina,qtdePagina);
        return produtoRepository.findAll(page);
    }

        //retornar pelo ID do produto
        @GetMapping(path = "/{id}")
        public Optional<Produto> obterProdutoPorId ( @PathVariable int id){
            return produtoRepository.findById(id);
        }


        // serve para alterar um produto
        @PutMapping
        public Produto alterarProduto (@Valid Produto produto){
            produtoRepository.save(produto);
            return produto;
        }


        // deletar algum produto pelo ID
        @DeleteMapping(path = "/{id}")
        public void excluirProduto(@PathVariable int id){
          produtoRepository.deleteById(id);
        }

    }