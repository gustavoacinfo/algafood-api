insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into forma_pagamento (descricao) values ('Boleto');
insert into forma_pagamento (descricao) values ('Cartao de credito');
insert into forma_pagamento (descricao) values ('Cartao de debito');

insert into permissao (nome, descricao) values ('Consultar Restaurante', 'Permite ao Usuário acesso a lista de Restaurantes');
insert into permissao (nome, descricao) values ('Consultar Cozinha', 'Permite ao Usuário acesso a lista de Cozinhas');
insert into permissao (nome, descricao) values ('Consultar Pedido', 'Permite ao Usuário acesso a lista de Pedidos');