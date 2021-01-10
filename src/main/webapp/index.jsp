<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="./css/main.css">
    
</head>

<body>
    
    <div id='corpoform'>
        <h1>Projeto Sefaz</h1>
        <h1>Entrar </h1>
        <form action="autenticador.do" method="POST" >        
            <input type="email" name ="email" placeholder="Email" required>
            <input type="password" name = "senha" placeholder="Senha" required>
            <input type="submit" value="Entrar">
            <a href="cadastrar.jsp">Ainda não é inscrito?<Strong>Cadastre-se</strong></a>

        </form>
    </div>