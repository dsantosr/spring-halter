package dev.dsantor.mastersys.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="alunos")
@EntityListeners(AuditingEntityListener.class)
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String cpf;
    private String nome;

    @Column(name="data_nascimento")
    private LocalDate dataNascimento;

    @Column(name="sexo", length = 1)
    private String sexo;
    private String telefone;
    private String celular;
    private String email;
    private String observacao;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;

    @Column(name="estado", length = 2)
    private String estado;
    private String cep;

    @CreatedDate
    @Column(name="criado_em", nullable = false, updatable = false)
    private LocalDateTime criadoEm;

    @LastModifiedDate
    @Column(name="atualizado_em")
    private LocalDateTime atualizadoEm;
}