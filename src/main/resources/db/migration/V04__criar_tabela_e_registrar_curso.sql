CREATE TABLE tb_curso (
	in_codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	ds_nome VARCHAR(50) NOT NULL,
	in_semestre BIGINT(20) NOT NULL,
	codigo_professor BIGINT(20),
	FOREIGN KEY (codigo_professor) REFERENCES tb_professor(in_codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tb_curso_disciplina (
	codigo_curso BIGINT(20) NOT NULL,
	codigo_disciplina BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_curso, codigo_disciplina),
	FOREIGN KEY (codigo_curso) REFERENCES tb_curso(in_codigo),
	FOREIGN KEY (codigo_disciplina) REFERENCES tb_disciplina(in_codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tb_curso_aluno (
	codigo_curso BIGINT(20) NOT NULL,
	codigo_aluno BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_curso, codigo_aluno),
	FOREIGN KEY (codigo_curso) REFERENCES tb_curso(in_codigo),
	FOREIGN KEY (codigo_aluno) REFERENCES tb_aluno(in_codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tb_curso (ds_nome, codigo_professor, in_semestre) values ('Sistemas de Informação', 1, 1);
INSERT INTO tb_curso (ds_nome, codigo_professor, in_semestre) values ('Direito', 2, 1);
INSERT INTO tb_curso (ds_nome, codigo_professor, in_semestre) values ('Medicina', 3, 1);

INSERT INTO tb_curso_disciplina (codigo_curso, codigo_disciplina) values (1,1);
INSERT INTO tb_curso_disciplina (codigo_curso, codigo_disciplina) values (1,2);
INSERT INTO tb_curso_disciplina (codigo_curso, codigo_disciplina) values (1,3);
INSERT INTO tb_curso_disciplina (codigo_curso, codigo_disciplina) values (1,4);
INSERT INTO tb_curso_disciplina (codigo_curso, codigo_disciplina) values (2,5);
INSERT INTO tb_curso_disciplina (codigo_curso, codigo_disciplina) values (2,6);
INSERT INTO tb_curso_disciplina (codigo_curso, codigo_disciplina) values (2,7);
INSERT INTO tb_curso_disciplina (codigo_curso, codigo_disciplina) values (3,8);
INSERT INTO tb_curso_disciplina (codigo_curso, codigo_disciplina) values (3,9);

INSERT INTO tb_curso_aluno (codigo_curso, codigo_aluno) values (1,1);
INSERT INTO tb_curso_aluno (codigo_curso, codigo_aluno) values (1,2);
INSERT INTO tb_curso_aluno (codigo_curso, codigo_aluno) values (1,3);
INSERT INTO tb_curso_aluno (codigo_curso, codigo_aluno) values (1,4);
INSERT INTO tb_curso_aluno (codigo_curso, codigo_aluno) values (2,1);
INSERT INTO tb_curso_aluno (codigo_curso, codigo_aluno) values (2,2);
INSERT INTO tb_curso_aluno (codigo_curso, codigo_aluno) values (2,3);
INSERT INTO tb_curso_aluno (codigo_curso, codigo_aluno) values (2,4);
INSERT INTO tb_curso_aluno (codigo_curso, codigo_aluno) values (3,1);
INSERT INTO tb_curso_aluno (codigo_curso, codigo_aluno) values (3,2);
INSERT INTO tb_curso_aluno (codigo_curso, codigo_aluno) values (3,3);
INSERT INTO tb_curso_aluno (codigo_curso, codigo_aluno) values (3,4);