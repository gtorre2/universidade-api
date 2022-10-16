CREATE TABLE tb_professor (
	in_codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	ds_nome VARCHAR(50) NOT NULL,
	vl_salario DECIMAL(10,2) NOT NULL,
	dt_nacimento DATE NOT NULL,
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_professor (ds_nome, vl_salario, dt_nacimento, ativo) values ('João Silva', 920.00, '1975-05-20', true);
INSERT INTO tb_professor (ds_nome, vl_salario, dt_nacimento, ativo) values ('Maria Rita', 700.00, '1984-09-13', true);
INSERT INTO tb_professor (ds_nome, vl_salario, dt_nacimento, ativo) values ('Pedro Santos', 600.00, '1985-02-10', true);