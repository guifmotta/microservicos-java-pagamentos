package com.microservico.pagamentos.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ItemDoPedido {
    private UUID id;
    private Integer quantidade;
    private String descricao;
}
