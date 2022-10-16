CREATE TABLE tb_aluno (
	in_codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	ds_nome VARCHAR(50) NOT NULL,
	nt_nota DECIMAL(10,2) NOT NULL,
	dt_nascimento DATE NOT NULL,
	ds_matricula VARCHAR(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_aluno (ds_nome, nt_nota, dt_nascimento, ds_matricula) values ('Rodrigo', 6.5, '1975-06-02', '123456');
INSERT INTO tb_aluno (ds_nome, nt_nota, dt_nascimento, ds_matricula) values ('Amanda', 10.0, '2000-07-06', '345671');
INSERT INTO tb_aluno (ds_nome, nt_nota, dt_nascimento, ds_matricula) values ('Gabrielly', 10.0, '1985-05-17', '567890');
INSERT INTO tb_aluno (ds_nome, nt_nota, dt_nascimento, ds_matricula) values ('Michelli', 7.5, '2004-05-09', '456789');
