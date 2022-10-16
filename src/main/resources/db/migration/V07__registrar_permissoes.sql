CREATE TABLE tb_usuario_permissao (
	codigo_usuario BIGINT(20) NOT NULL,
	codigo_permissao BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_usuario, codigo_permissao),
	FOREIGN KEY (codigo_usuario) REFERENCES tb_usuario(codigo),
	FOREIGN KEY (codigo_permissao) REFERENCES tb_permissao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- admin
INSERT INTO tb_usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO tb_usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);
INSERT INTO tb_usuario_permissao (codigo_usuario, codigo_permissao) values (1, 3);
INSERT INTO tb_usuario_permissao (codigo_usuario, codigo_permissao) values (1, 4);
INSERT INTO tb_usuario_permissao (codigo_usuario, codigo_permissao) values (1, 5);
INSERT INTO tb_usuario_permissao (codigo_usuario, codigo_permissao) values (1, 6);
INSERT INTO tb_usuario_permissao (codigo_usuario, codigo_permissao) values (1, 7);
INSERT INTO tb_usuario_permissao (codigo_usuario, codigo_permissao) values (1, 8);
INSERT INTO tb_usuario_permissao (codigo_usuario, codigo_permissao) values (1, 9);
INSERT INTO tb_usuario_permissao (codigo_usuario, codigo_permissao) values (1, 10);

-- maria
INSERT INTO tb_usuario_permissao (codigo_usuario, codigo_permissao) values (2, 2);
INSERT INTO tb_usuario_permissao (codigo_usuario, codigo_permissao) values (2, 4);
INSERT INTO tb_usuario_permissao (codigo_usuario, codigo_permissao) values (2, 7);