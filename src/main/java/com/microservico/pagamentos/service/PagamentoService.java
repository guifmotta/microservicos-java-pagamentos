package com.microservico.pagamentos.service;

import com.microservico.pagamentos.dto.PagamentoDto;
import com.microservico.pagamentos.model.Pagamento;
import com.microservico.pagamentos.model.Status;
import com.microservico.pagamentos.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<PagamentoDto> obterTodos(Pageable paginacao) {
        return repository.findAll(paginacao).map(p -> modelMapper.map(p, PagamentoDto.class));
    }

    public PagamentoDto obterPorId(UUID id) {
        var pagamento = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto criarPagamento(PagamentoDto dto) {
        var pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto atualizarPagamento(UUID id, PagamentoDto dto) {
        var pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setId(id); // TODO: Verificar se é necessário já que o Id deve estar vindo no DTO
        pagamento = repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public void excluirPagamento(UUID id) {
        repository.deleteById(id);
    }
}
