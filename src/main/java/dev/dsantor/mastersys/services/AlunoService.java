package dev.dsantor.mastersys.services;

import dev.dsantor.mastersys.domain.Aluno;
import dev.dsantor.mastersys.dto.AlunoRequest;
import dev.dsantor.mastersys.dto.AlunoResponse;
import dev.dsantor.mastersys.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository repository) {
        this.alunoRepository = repository;
    }

    public AlunoResponse cadastrar(AlunoRequest alunoRequest) {

        if (alunoRequest.cpf() != null && alunoRepository.existsByCpf(alunoRequest.cpf())){
            throw new EntityNotFoundException("Já existe um aluno com esse CPF");
        }

        Aluno aluno = alunoRequest.toEntity();
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoSalvo);
    }

    public Page<AlunoResponse> listar(Pageable pageable) {
        return alunoRepository.findAll(pageable).map(AlunoResponse::fromEntity);
    }

    public AlunoResponse atualizar(Long id, AlunoRequest alunoRequest) {
        Aluno aluno = buscarEntidadePorId(id);
        alunoRequest.preencher(aluno);
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoAtualizado);
    }

    public void excluir(Long id) {
        Aluno aluno = buscarEntidadePorId(id);
        alunoRepository.delete(aluno);
    }

    public AlunoResponse buscarPorId(Long id){
        Aluno aluno = buscarEntidadePorId(id);
        return AlunoResponse.fromEntity(aluno);
    }

    private Aluno buscarEntidadePorId(Long id){
        return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }
}

