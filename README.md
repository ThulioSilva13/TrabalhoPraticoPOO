# TrabalhoPraticoPOO
Projeto de gerenciamento de estoque
Neste sistema criamos um sistema de gerenciamento de estoque de uma loja
as classes usadas no projeto foram: Usuário, Produto, Fornecedor e Endereço
criamos as funcionalidades de cadastrar, excluir, listar e editar para cada uma das classes citadas acima
além destas, foram criadas as funcionalidades de comprar, repor estoque e listar as compras de um determinado usuário
usamos um banco de dados MySQL para a persistência dos dados
para conectar o sistema com o banco no pacote Connection abrimos o arquivo Conexao.java
na linha: conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp01poo?user=root&password=root");
a string do parâmetro deve ser "jdbc:mysql://localhost:3306/tp01poo?user=NOMEUSERBANCO&password=SENHA"

para rodar a parte do cliente basta abrir o arquivo HTML
