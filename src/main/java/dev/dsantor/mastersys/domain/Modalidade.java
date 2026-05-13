package dev.dsantor.mastersys.domain;

import jakarta.persistence.*;

@Entity
@Table(name="modalidades")
public class Modalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private boolean ativa = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean Ativa() {
        return ativa;
    }

    public void setAtiva(boolean ativo) {
        this.ativa = ativo;
    }
}
