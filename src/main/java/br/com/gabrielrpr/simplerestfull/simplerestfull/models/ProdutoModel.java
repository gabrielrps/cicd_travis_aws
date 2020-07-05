package br.com.gabrielrpr.simplerestfull.simplerestfull.models;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PRODUTOS")
@Data
public class ProdutoModel extends RepresentationModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduto;
    private String nome;
    private BigDecimal valor;


}
