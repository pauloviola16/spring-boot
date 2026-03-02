package com.example.exerciciossb.model.repositories;

import com.example.exerciciossb.model.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProdutoRepository
        extends JpaRepository<Produto, Integer> {

}
