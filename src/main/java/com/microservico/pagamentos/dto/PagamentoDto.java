package com.microservico.pagamentos.dto;

import com.microservico.pagamentos.model.ItemDoPedido;
import com.microservico.pagamentos.model.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PagamentoDto {
    private UUID id;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Size(max = 19)
    private String numero;

    @NotBlank
    @Size(max = 7)
    private String expiracao;

    @NotBlank
    @Size(min = 3, max = 3)
    private String codigo;

    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private UUID pedidoId;

    @NotNull
    private Long formaPagamentoId;

    private List<ItemDoPedido> itens;
}
