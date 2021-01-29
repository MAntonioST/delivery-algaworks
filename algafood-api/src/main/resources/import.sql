INSERT INTO cozinha(id, nome) VALUES(1,'Tailandesa');
INSERT INTO cozinha(id, nome) VALUES(2,'Indiana');


INSERT INTO restaurante(nome, taxa_frete, cozinha_id) VALUES('Thai Gourmet', 10, 1);
INSERT INTO restaurante(nome, taxa_frete, cozinha_id) VALUES('Thai Delivery', 9.50, 1);
INSERT INTO restaurante(nome, taxa_frete, cozinha_id) VALUES('Tuk Tuk Comida Indiana', 15, 2);

INSERT INTO forma_pagamento (descricao) VALUES('Cartão');
INSERT INTO forma_pagamento (descricao) VALUES('Boleto');
INSERT INTO forma_pagamento (descricao) VALUES('Pix');


INSERT INTO permissao (descricao, nome) VALUES('Permite consultar produtos  dos restaurantes','Consultar produtos');
INSERT INTO permissao (descricao, nome) VALUES('Permite inserir produtos  para os restaurantes','Inserir produtos');


INSERT INTO estado (id,nome) VALUES(1,'São Paulo');
INSERT INTO estado (id,nome) VALUES(2,'Rio de Janeiro');


INSERT INTO cidade (nome, estado_id) VALUES('Mogi das Cruzes', 1);
INSERT INTO cidade (nome, estado_id) VALUES('Volta Redonda', 2);


