INSERT INTO CATEGORY (id, description, type) VALUES(1, "Alimentação", "Saída");
INSERT INTO CATEGORY (id, description, type) values (2, "Cuidados Pessoais", "Saída");
INSERT INTO CATEGORY (id, description, type) values (3, "Despesas Financeiras", "Saída");
INSERT INTO CATEGORY (id, description, type) values (4, "Educação", "Saída");
INSERT INTO CATEGORY (id, description, type) values (5, "Investimentos", "Saída");
INSERT INTO CATEGORY (id, description, type) values (6, "Lazer", "Saída");
INSERT INTO CATEGORY (id, description, type) values (7, "Moradia", "Saída");
INSERT INTO CATEGORY (id, description, type) values (8, "Saúde", "Saída");
INSERT INTO CATEGORY (id, description, type) values (9, "Transporte", "Saída");
INSERT INTO CATEGORY (id, description, type) values (10, "Vestuário", "Saída");
INSERT INTO CATEGORY (id, description, type) values (11, "Outras Despesas", "Saída");
INSERT INTO CATEGORY (id, description, type) values (12, "Salário", "Entrada");
INSERT INTO CATEGORY (id, description, type) values (13, "Renda Variável", "Entrada");
INSERT INTO CATEGORY (id, description, type) values (14, "Outras Receitas", "Entrada");

insert into accounttype (id, description) values (1, "Conta Corrente");
insert into accounttype (id, description) values (2, "Conta Poupança");
insert into accounttype (id, description) values (3, "Conta Salário");
insert into accounttype (id, description) values (4, "Conta de Investimento");
insert into accounttype (id, description) values (5, "Cartão de Crédito");
insert into accounttype (id, description) values (6, "Dinheiro");

insert into institution (id, description) values (1, "Itaú");
insert into institution (id, description) values (2, "Banco do Brasil");
insert into institution (id, description) values (3, "Caixa Econômica Federal");
insert into institution (id, description) values (4, "Bradesco");
insert into institution (id, description) values (5, "Santander");
insert into institution (id, description) values (6, "Inter");
insert into institution (id, description) values (7, "Nubank");
insert into institution (id, description) values (8, "C6 Bank");
insert into institution (id, description) values (9, "Neon");
insert into institution (id, description) values (10, "Carteira");

INSERT INTO profile (id, description) values (1, "Administrador");
insert into profile (id, description) values (2, "Membro");

INSERT INTO USER(id, email, password) values (1, "administrador@wesomma.com.br", "$2a$10$s7ttvNeR4XthJJqQt285neuNY3KFzP1dpnlqNkPPw4m8HLx.Umnt6");
INSERT INTO ACCOUNT(id, agency, number, name, balance, institution, accountType, person) VALUES (1, "agency", "number", "name", 0.0, 1, 6, null);