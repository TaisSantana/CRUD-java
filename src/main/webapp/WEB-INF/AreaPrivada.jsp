<%@page import="java.util.List"%>
<%@page import="br.com.projetoSefaz.model.Cadastro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Página do Usuario</title>
	<meta charset="utf-8"/>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
function confirmarExclusao(email){
 if (window.confirm('Tem certeza que deseja excluir?')){
	 location.href="usucontroller.do?acao=exc&email="+email;
 }
	 }
</script>
</head>
<body>


<%//recebe o objeto setado no UserController.java (lista de cadastros)
List<Cadastro> lista = (List<Cadastro>)request.getAttribute("list");%>

<div class="container">

   
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
   
	<table class="table table-light table-striped table-bordered">
		
		<tr id=titulo>
            <td scope="col"><b>Nome</b></td>
            <td scope="col"><b>Email</b></td>
            <td scope="col"><b>Telefone</b></td>   
            <td scope="col"><b>Opções</b></td>
            
        </tr>
     
        <% for (Cadastro cad: lista){ %>
  			<tr id=infos>
	    		<td><%=cad.getNome()%></td>
	            <td><%=cad.getEmail()%></td>
	            <td><%=cad.getTelefone() %></td>
	            <td>
	              	<a href="usucontroller.do?acao=alt&email=<%cad.getEmail();%>">Alterar</a><br/>
	            	<a href="usucontroller.do?acao=exc&email=<%=cad.getEmail()%>">Excluir Conta </a>
           		 
           		</td>
	        </tr>

		<%}%>
	</table>
</div>


</body>
</html>