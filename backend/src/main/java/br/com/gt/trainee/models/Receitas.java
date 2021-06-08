package br.com.gt.trainee.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "tb_receita")
public class Receitas {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String descricao;
        private String tempoDePreparo;
        private Integer rendimento;

        public Receitas(){

        }

        public Receitas(Long id, String nome, String descricao, String tempoDePreparo, Integer rendimento) {
                this.id = id;
                this.nome = nome;
                this.descricao = descricao;
                this.tempoDePreparo = tempoDePreparo;
                this.rendimento = rendimento;
        }

        public Long getId() {
                return id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public String getTempoDePreparo() {
                return tempoDePreparo;
        }

        public void setTempoDePreparo(String tempoDePreparo) {
                this.tempoDePreparo = tempoDePreparo;
        }

        public Integer getRendimento() {
                return rendimento;
        }

        public void setRendimento(Integer rendimento) {
                this.rendimento = rendimento;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Receitas)) return false;
                Receitas receitas = (Receitas) o;
                return getId().equals(receitas.getId());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getId());
        }
}
