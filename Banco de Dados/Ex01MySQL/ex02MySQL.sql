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

/*4.E
CREATE VIEW emprestimos_ano2 AS
SELECT YEAR(Data_Emprestimo) AS ano, COUNT(*) AS numero_emprestimos
FROM emprestimo
WHERE Data_Emprestimo
GROUP BY YEAR(Data_Emprestimo);
*/

/*4.F
CREATE VIEW livrosPorEditora AS
SELECT *
FROM (
    SELECT 
        e.Nome AS Editora,
        COUNT(l.EditoraID) AS TotalLivros
    FROM editora e
    JOIN livro l ON l.EditoraID = e.ID
    GROUP BY e.Nome
) AS t
WHERE TotalLivros > 3;
*/

/*4.G
CREATE VIEW autoresEUAPortugal AS
SELECT l.Titulo, a.*
FROM livro l
JOIN autor a ON l.AutorID = a.ID
WHERE a.Pais IN ('EUA', 'Portugal');

SELECT *
FROM autoresEUAPortugal
ORDER BY Nome ASC;
*/

/*4.H
CREATE VIEW quantidadeGenero AS
SELECT g.Tipo, COUNT(l.GeneroID) AS TotalLivros
FROM genero g
JOIN livro l ON l.GeneroID = g.ID
GROUP BY g.Tipo;
*/

/*4.I
CREATE VIEW editorasGeneros AS
SELECT e.Nome AS Editora, g.Tipo AS Genero
FROM editora e
JOIN livro l ON l.EditoraID = e.ID
JOIN genero g ON l.GeneroID = g.ID
GROUP BY e.Nome, g.Tipo;
*/

/*4.J
CREATE VIEW top3AutoresNaoEUA AS
SELECT a.Nome AS Autor, COUNT(e.LivroID) AS TotalEmprestimos
FROM autor a
JOIN livro l ON l.AutorID = a.ID
JOIN emprestimo e ON e.LivroID = l.ID
WHERE a.Pais <> 'EUA'
GROUP BY a.Nome
ORDER BY TotalEmprestimos DESC
LIMIT 3;
*/

/*4.K
CREATE VIEW livrosEmprestados2021 AS
SELECT l.Titulo AS Livro, c.Nome AS Cliente, c.Email AS Email, e.Data_Emprestimo
FROM emprestimo e
JOIN livro l ON e.LivroID = l.ID
JOIN cliente c ON e.ClienteID = c.ID
WHERE e.Data_Devolucao OR e.Data_Devolucao >= '2021-01-01';
*/





