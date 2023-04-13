CREATE TABLE pagamentos
(
    id uuid NOT NULL,
    valor numeric(19, 2) NOT NULL,
    nome character varying(100),
    numero character varying(19),
    expiracao character varying(7),
    codigo character varying(3),
    status character varying(255) NOT NULL,
    forma_pagamento_id bigint NOT NULL,
    pedido_id uuid NOT NULL,
    PRIMARY KEY (id)
);