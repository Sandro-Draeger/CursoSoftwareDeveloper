/* 4.a 
CREATE VIEW clientes_gmail_91_96 AS
SELECT *
FROM cliente
WHERE Email LIKE '%gmail%' 
	AND (Contacto LIKE '91%' OR contacto LIKE '96%')
*/

/*4.b
CREATE VIEW livros_da_de_do AS
SELECT *
FROM livro
WHERE Titulo LIKE '% de %'
   OR Titulo LIKE '% do %'
   OR Titulo LIKE '% da %';
*/

/*4.c
CREATE VIEW emprestimos_ativos AS
SELECT *, DATEDIFF(CURDATE(), Data_Emprestimo) AS Dias
FROM emprestimo
WHERE data_devolucao;
*/

/*4.D
CREATE VIEW livro_autor AS
SELECT l.Titulo, a.Nome
FROM livro AS l
JOIN autor AS a ON l.AutorID = a.ID;
*/