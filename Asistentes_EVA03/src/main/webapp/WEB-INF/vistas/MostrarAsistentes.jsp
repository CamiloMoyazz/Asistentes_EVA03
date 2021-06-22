<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<jsp:include page="../templates/header.jsp"></jsp:include>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<main class="container">
		<div class="columns is-centered">
			<div class="column is-6 mt-5">
			<form action="MostrarAsistentesController.do">
				<div class="field">
					<label class="label">Filtrar por Estado</label>
					<div class="select">
						<select name="filtro-select" id="filtro-select">
                                                        <option>Todas</option>
							<option>Pagado</option>
							<option>Con Deuda</option>
						</select>
					</div>
					<div class="field mt-2">
						<button type="submit" class="button is-success">Filtrar</button>
					</div>
				</div>	
			</form>
			</div>
		</div>
		<div class="columns is-centered">
			<div class="column is-8">
				<table class="table is-fullwidth is-hoverable">
					<thead class="has-background-grey-dark">
						<tr>
							<th class="has-text-light">Nombre</th>
							<th class="has-text-light">Empresa</th>
							<th class="has-text-light">Región</th>
							<th class="has-text-warning">Estado</th>
						</tr>
					</thead>
					<tbody>
                                            <c:forEach items="${asistentes}" var="asistente">
						<tr>
							<td>${asistente.nombre} ${asistente.apellido}</td>
							<td>${asistente.empresa}</td>
							<td>${asistente.region}</td>
							<td>${asistente.estado}</td>
						</tr>
                                           </c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="columns is-multiline">
			<div class="column is-7">
			</div>
			<div class="column is-5 is-one-quarter">
				<div class="field mt-1 ml-4 pl-4 ">
						<label class="label">Total de Asistentes Registrados</label>
                                              
                                                    <label class="label ml-3 has-text-centered">${total}</label>
                                               
				</div>
			</div>
		
		</div>
	
	</main>
	
</body>
</html>