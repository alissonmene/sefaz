# sefaz

##Passo a passo para uso Sefaz:
<p>
	1) Criar um banco de dados no H2 com o nome test (jdbc:h2:~/test) com usuário _sa_ e senha _vazia_
	2) Importe o _sql (sql_usuario_ivia.sql)_ no resource do projeto para o banco de dados
	3) Acesse o console do administrador do Wildfly
	4) Crie uma conexão do servidor com banco de dados vá em _Configuration -> Subsystem -> Datasources -> NON-XA -> H2 -> name: sefazDS e JNDI: java:/sefazDS_
	
</p>
