package dev.dsantor.mastersys.repository;

import dev.dsantor.mastersys.domain.Aluno;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @DisplayName("Deve retornar True se o CPF existe no database")
    void existsByCpfDeveRetornarTrueSeCpfExistirTest() {
        String cpf = "123456789";
        Aluno aluno = new Aluno();
        aluno.setCpf(cpf);
        aluno.setNome("Aluno Teste");

        testEntityManager.persist(aluno);

        boolean existe = alunoRepository.existsByCpf(cpf);
        assertTrue(existe);
    }

    @Test
    @DisplayName("Deve retornar False se o CPF nao existe no database")
    void existsByCpfDeveRetornarFalseSeCpfNaoExistirTest() {
        String cpf = "123456789";

        boolean existe = alunoRepository.existsByCpf(cpf);
        assertFalse(existe);
    }
}