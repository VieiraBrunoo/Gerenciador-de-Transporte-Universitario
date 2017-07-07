<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Students</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Matricula do Motorista</th>
                <th>Nome</th>
                <th>Numero Habilitação</th>
                <th>Telefone</th>
                <th>Endereço</th>
                <th>Bairro</th>
                <th>Cidade</th>
                <th>Sexo</th>
                <th>CPF</th>
                <th>Estado Civil</th>
                <th>Data de Nascimento</th>
                
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${motoristas}" var="motorista">
            <tr>
                                            <td><c:out value="${motorista.idMotorista}" /></td>
											<td><c:out value="${motorista.nome}" /></td>
											<td><c:out value="${motorista.habilitacao}" /></td>
											<td><c:out value="${motorista.telefone}" /></td>
											<td><c:out value="${motorista.endereco}" /></td>
											<td><c:out value="${motorista.bairro}" /></td>
											<td><c:out value="${motorista.cidade}" /></td>
											<td><c:out value="${motorista.sexo}" /></td>
											<td><c:out value="${motorista.cpf}" /></td>
											<td><c:out value="${motorista.estadoCivil}" /></td>
											<td><c:out value="${motorista.dataNascimento}" /></td>
										    <td><a href="MotoristaController.do?action=edit&idMotorista=<c:out value="${motorista.idMotorista }"/>">Atualizar</a></td>
                    <td><a href="MotoristaController.do?action=delete&idMotorista=<c:out value="${motorista.idMotorista}"/>">Deletar</a></td>
               </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="MotoristaController.do?action=insert">Add Student</a>
    </p>
</body>
</html>