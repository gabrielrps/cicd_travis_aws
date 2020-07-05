package br.com.gabrielrpr.simplerestfull.simplerestfull.repository;

import br.com.gabrielrpr.simplerestfull.simplerestfull.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
