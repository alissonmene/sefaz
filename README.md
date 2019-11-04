# sefaz

##Passo a passo:
	1) Criar um banco de dados no H2 com o nome test (jdbc:h2:~/test) com usuário sa e senha vazia
	2) Importe o sql (sql_usuario_ivia.sql) no resource do projeto para o banco de dados
	3) Acesse o console do administrador do Wildfly
	4) Crie uma conexão do servidor com banco de dados vá em Configuration -> Subsystem -> Datasources -> NON-XA -> H2 -> name: sefazDS e JNDI: java:/sefazDS
	5) Informe usuário: sa e senha vazia em conexão
 
	
	
	
