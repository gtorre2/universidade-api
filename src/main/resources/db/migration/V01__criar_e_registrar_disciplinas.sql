CREATE TABLE tb_disciplina (
	in_codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	ds_nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_disciplina (ds_nome) values ('Cálculo I');
INSERT INTO tb_disciplina (ds_nome) values ('Cálculo II');
INSERT INTO tb_disciplina (ds_nome) values ('Cálculo III');
INSERT INTO tb_disciplina (ds_nome) values ('Cálculo IV');
INSERT INTO tb_disciplina (ds_nome) values ('Introdução ao direito');
INSERT INTO tb_disciplina (ds_nome) values ('Direito Penal I');
INSERT INTO tb_disciplina (ds_nome) values ('Direito Penal II');
INSERT INTO tb_disciplina (ds_nome) values ('Anatomia humana I');
INSERT INTO tb_disciplina (ds_nome) values ('Anatomia humana II');
