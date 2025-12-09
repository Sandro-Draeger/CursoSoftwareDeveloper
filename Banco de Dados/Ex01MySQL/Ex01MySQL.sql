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

/*5.D1
select DATEDIFF(CURRENT_DATE(), DataVenda) AS Diferença_de_dias
from venda
*/

/*5.D2
select Nome, year(DataNascimento)
from cliente
*/

/*5.E1
SELECT *
from funcionario
where Nome = 'Sandro'
*/

/*5.E2
SELECT Nome, DataNascimento
from cliente
where  year(current_date()) -year(DataNascimento) between 31 and 49;
*/

/*5.E3
SELECT *
FROM venda
WHERE DataVenda BETWEEN '2023-01-01' AND '2023-03-31';
*/

/*5.F1
SELECT *
FROM produto
WHERE CategoriaID IN (1, 2) and stock > 10
*/

/*5.F2 (não tem nenhum João na lista cliente)
SELECT *
FROM cliente
WHERE Nome like 'João' and CP ^100
*/

/*5.G1
SELECT *
FROM produto
WHERE Preco between 100 and 500
*/

/*5.G2
SELECT *
FROM venda
WHERE DataVenda between '2023-01-01' and '2023-05-31'
*/

/*5.G3
SELECT *
FROM cliente
where year(current_date()) -year(DataNascimento) between 25 and 40;
*/

/*5.H1
SELECT *
FROM cliente
WHERE ID IN (1, 5, 7);
*/

/*5.H2
SELECT *
FROM cliente
WHERE Localidade in ('Braga', 'Viseu', 'Coimbra')
*/

/*5.I1
SELECT *
FROM produto
WHERE Nome like 'Máquina%'
*/

/*5.I2
SELECT *
FROM cliente
WHERE Nome like 'A____%'
*/

/*5.I3
SELECT *
FROM cliente
WHERE Email regexp '@gmail.com|@hotmail.com'
*/

/*5.I4
SELECT *
FROM produto
WHERE Nome regexp '^Ar|^As'
*/

/*5.J1
SELECT CategoriaID, max(Preco)
FROM produto
GROUP BY CategoriaID
*/

/*5.J2*/
