package dev.dsantor.mastersys.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="matriculas_modalidades")
public class MatriculaModalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="data_inicio")
    private LocalDateTime dataInicio;

    @CreatedDate
    @Column(name="data_fim")
    private LocalDateTime datafim;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="matricula_id")
    private Matricula matricula;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="modalidade_id")
    private Modalidade modalidade;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="plano_id")
    private Plano plano;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="graduacao_id")
    private Graduacao graduacao;
}
