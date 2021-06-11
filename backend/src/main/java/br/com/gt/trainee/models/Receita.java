package br.com.gt.trainee.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "tb_receita")
@Getter
@Setter
@EqualsAndHashCode
public class Receita {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotNull
        private String nome;
        @NotNull
        private String descricao;
        @NotNull
        private String tempoDePreparo;
        @NotNull
        @Min(1)
        private Integer rendimento;

        @Valid
        @ManyToMany
        @JoinTable(name="rel_categoria_receita",
                joinColumns=@JoinColumn(name="id_receita", referencedColumnName="id"),
                inverseJoinColumns=@JoinColumn(name="id_category", referencedColumnName="id"))
        private Set<Category> categorias;

        @OneToMany(cascade = CascadeType.PERSIST)
        private Set<ModoPreparo> modoPreparos;




}
