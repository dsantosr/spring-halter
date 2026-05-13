package dev.dsantor.mastersys.domain;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Table(name="matriculas_modalidades")
public class MatriculaModalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="data_inicio")
    private LocalDate dataInicio;

    @CreatedDate
    @Column(name="data_fim")
    private LocalDate datafim;

    @ManyToOne(fetch=FetchType.LAZY)
    @Column(name="matricula_id")
    private Matricula matricula;

    @ManyToOne(fetch=FetchType.LAZY)
    @Column(name="modalidade_id")
    private Modalidade modalidade;

    @ManyToOne(fetch=FetchType.LAZY)
    @Column(name="plano_id")
    private Plano plano;

    @ManyToOne(fetch=FetchType.LAZY)
    @Column(name="graduacao_id")
    private Graduacao graduacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDatafim() {
        return datafim;
    }

    public void setDatafim(LocalDate datafim) {
        this.datafim = datafim;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Graduacao getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Graduacao graduacao) {
        this.graduacao = graduacao;
    }
}
