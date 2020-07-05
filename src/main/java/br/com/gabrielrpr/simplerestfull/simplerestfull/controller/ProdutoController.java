package br.com.gabrielrpr.simplerestfull.simplerestfull.controller;

import br.com.gabrielrpr.simplerestfull.simplerestfull.exceptions.ProductsNotFoundException;
import br.com.gabrielrpr.simplerestfull.simplerestfull.models.ProdutoModel;
import br.com.gabrielrpr.simplerestfull.simplerestfull.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos/")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("check")
    public String health (){
        return "It's working";
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> getAllProdutos(){
        List<ProdutoModel> lista = produtoRepository.findAll();
        if(lista.isEmpty()){
            throw new ProductsNotFoundException("Produto não encontrado");
        }

        lista.stream().forEach(p ->  p.add(linkTo(methodOn(ProdutoController.class).getProduto(p.getIdProduto())).withSelfRel()));

        return new ResponseEntity<List<ProdutoModel>>(lista , HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<ProdutoModel> getProduto(@PathVariable("id") Long id){
        Optional<ProdutoModel> produto = produtoRepository.findById(id);
        if(!produto.isPresent()){
            throw new ProductsNotFoundException("Produto não encontrado");
        }
        return new ResponseEntity<ProdutoModel>(produto.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> saveProduto(@RequestBody @Valid ProdutoModel produto) {
        return new ResponseEntity<ProdutoModel>(produtoRepository.save(produto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable(value="id") long id) {
        Optional<ProdutoModel> produtoO = produtoRepository.findById(id);
        if(!produtoO.isPresent()) {
            throw new ProductsNotFoundException("Produto não encontrado");
        }else {
            produtoRepository.delete(produtoO.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<ProdutoModel> updateProduto(@PathVariable(value="id") long id,
                                                      @RequestBody @Valid ProdutoModel produto) {
        Optional<ProdutoModel> produtoO = produtoRepository.findById(id);
        if(!produtoO.isPresent()) {
            throw new ProductsNotFoundException("Produto não encontrado");
        }else {
            produto.setIdProduto(produtoO.get().getIdProduto());
            return new ResponseEntity<ProdutoModel>(produtoRepository.save(produto), HttpStatus.OK);
        }
    }



}
