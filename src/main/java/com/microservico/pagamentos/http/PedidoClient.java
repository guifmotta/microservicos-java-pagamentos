package com.microservico.pagamentos.http;

import com.microservico.pagamentos.model.Pedido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient("pedidos-ms")
public interface PedidoClient {
    @RequestMapping(method = RequestMethod.PUT, value = "/pedidos/{id}/pago")
    void atualizaPagamento(@PathVariable UUID id);

    @RequestMapping(method = RequestMethod.GET, value = "/pedidos/{id}")
    Pedido obterItensDoPedido(@PathVariable UUID id);
}
