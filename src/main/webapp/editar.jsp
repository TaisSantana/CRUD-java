<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.projetoSefaz.model.Cadastro"%>
<html>

<head>
    <meta charset="utf-8">
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    

</head>

<body>
<%//carrega objeto Cadastro vindo do request e imprime dentro do form
Cadastro cad = (Cadastro)request.getAttribute("cad"); %>

  <div class="container">
    	<h3>Bem vindo! </h3>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="background-color: #e3f2fd;">
	        <div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
				        <a class="nav-link"  href="TelaInicial.jsp"><b>Home</b></a>
				    </li>
				    <li class="nav-item">
				        <a class="nav-link" href="usucontroller.do?acao=lis"><b>Lista Usuários</b></a>
				    </li>
				    <li class="nav-item">
				        <a class="nav-link" href="autenticador.do"><b>Sair</b></a>
				    </li>
				</ul>
			</div>
      </nav>
    </div>
	<div id='corpoformcad'>
	    
	    <form action ="usucontroller.do" method="POST">
	        <h1> Alterar </h1>
	<input type="text" name ="nome" placeholder="Nome" maxlength= "70" value = "<%=cad.getNome()%>" required >
	        <input type="email" name ="email" placeholder="Email" maxlength= "40" value = "<%=cad.getEmail()%>" required >
	        <input type="text" name ="telefone" placeholder="Telefone" maxlength= "11" value = "<%=cad.getTelefone()%>" required>
	        <input type="password" name ="senha" placeholder="Senha" maxlength= "32" required>
	        
	        <input type="submit" value="Salvar">
	    </form>
	    </div> 
	    

</body>
</html>