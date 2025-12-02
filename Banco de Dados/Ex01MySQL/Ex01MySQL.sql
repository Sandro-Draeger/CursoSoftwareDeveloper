/*4.A
INSERT INTO funcionario(Nome, Email, Cargo, DataContratacao)
VALUES ('Sandro', 'sandro@gmail.com', 'Vendedor', '2025-12-02');
*/

/*4.B
UPDATE cliente
SET Telefone = '915923677'
WHERE ID = 19;
*/

/*5.A1
SELECT *
FROM produto;
*/

/*5.A2
SELECT ID, ClienteID, FuncionarioID, DataVenda, Total
FROM venda
*/

/*5.B1
SELECT Nome AS Produto, Preco AS Preço
FROM produto;
*/

/*5.B2
SELECT Nome, Cargo AS Função
FROM funcionario
*/

/*5.C1
SELECT preco, ROUND(preco - (preco*0.10), 2) AS 'Preço com Desconto'
FROM produto
*/

/*5.C2
SELECT ROUND(preco - (preco*0.15), 2) AS 'Preço com Desconto'
FROM produto
*/





