CREATE TABLE tb_permissao (
	codigo BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_permissao (codigo, descricao) values (1, 'ROLE_CADASTRAR_DISCIPLINA');
INSERT INTO tb_permissao (codigo, descricao) values (2, 'ROLE_PESQUISAR_DISCIPLINA');

INSERT INTO tb_permissao (codigo, descricao) values (3, 'ROLE_CADASTRAR_CURSO');
INSERT INTO tb_permissao (codigo, descricao) values (4, 'ROLE_PESQUISAR_CURSO');

INSERT INTO tb_permissao (codigo, descricao) values (5, 'ROLE_CADASTRAR_PROFESSOR');
INSERT INTO tb_permissao (codigo, descricao) values (6, 'ROLE_INATIVAR_PROFESSOR');
INSERT INTO tb_permissao (codigo, descricao) values (7, 'ROLE_PESQUISAR_PROFESSOR');

INSERT INTO tb_permissao (codigo, descricao) values (8, 'ROLE_CADASTRAR_ALUNO');
INSERT INTO tb_permissao (codigo, descricao) values (9, 'ROLE_INATIVAR_ALUNO');
INSERT INTO tb_permissao (codigo, descricao) values (10, 'ROLE_PESQUISAR_ALUNO');