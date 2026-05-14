package dev.dsantor.mastersys.repository;

import dev.dsantor.mastersys.domain.Aluno;
import dev.dsantor.mastersys.dto.AlunoRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("Deve retornar True se o CPF existe no database")
    void existsByCpfCase1() {
        String cpf = "67089087021";
        AlunoRequest aluno = new AlunoRequest("Teste da Silva",
                "67089087021", LocalDate.parse("2001-09-02"),"M","988989-8989","98982829393",
                "joao@silva.com", "Perigo", "rua 22","12","bloco salvia",
                "ribamar","67", "MA","787657897");
        createAluno(aluno);

        boolean existe = alunoRepository.existsByCpf(cpf);
        assertTrue(existe);
    }

    @Test
    @DisplayName("Deve retornar False se o CPF nao existe no database")
    void existsByCpfCase2() {
        String cpf = "123456789";

        boolean existe = alunoRepository.existsByCpf(cpf);
        assertFalse(existe);
    }

    private Aluno createAluno(AlunoRequest request){
        Aluno aluno = new Aluno();
        aluno.setNome(request.nome());
        aluno.setCpf(request.cpf());
        entityManager.persist(aluno);
        return aluno;
    }
}