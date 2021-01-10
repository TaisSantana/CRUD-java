<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>

	<head>
	    <meta charset="utf-8">
	    <link rel="stylesheet" href="./css/main.css">
	
	</head>
	
	<body>
	
	    <div id='corpoformcad'>
	    
	        <form action="usucontroller.do" method="POST">
	            <h1>Cadastrar </h1>
	            <input type="text" name ="nome" placeholder="Nome" maxlength= "70" required value="">
	            <input type="text" name ="telefone" placeholder="Telefone" maxlength= "11" required value="">
	            <input type="email" name ="email" placeholder="Email" maxlength= "40" required value="">
	            <input type="password" name ="senha" placeholder="Senha" maxlength= "32" required value="">
	            <input type="password" name ="confsenha" placeholder="Confirmar Senha" maxlength= "70"required >
	            <input type="submit" value="Cadastrar">
	        </form>
	    </div>
	    
	</body>

</html>