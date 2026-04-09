package org.example.lojajogos.lojajogos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Jogo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank (message = "Nome é obrigatório")
        private String nome;

        @NotNull(message = "Preço é obrigatório")
        @Positive (message = "Preço deve ser maior que 0")
        private Double preco;

        @NotBlank (message = "Categoria deve ser obrigatório")
        private String categoria;

        @NotBlank (message = "Código de ativação deve ser obrigatório")
        @Column (unique = true)
        private String codigoAtivacao;

        public Jogo() {}
}
