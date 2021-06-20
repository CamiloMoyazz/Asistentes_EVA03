<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<jsp:include page="../templates/header.jsp"></jsp:include>
	
<main class="container">
	<!--  
	<div class="container mt-4">
			<div class="columns is-centered mt-4 mb-1">
				<div class="column  mt-4 is-6">
					<div class="notification is-primary mt-4">
						<h6>Asistente ya Registrado</h6>
						<div class="content">
							<ul>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
	</div>
	-->

	<div class="columns is-centered">
		<div class="column is-5">
			<form method="POST" action="IngresarAsistenteController.do">
					<!-- COMIENZO DEL CARD -->
				<div class="card mt-6">
					<div class="card-header has-background-dark">
						<h1 class="card-header-title has-text-primary-light">Ingresar Asistente</h1>
					</div>
					<!-- CONTENIDO DEL CARD , AQUI ESTAN LOS ELEMENTOS DEL FORMULARIO -->
					<div class="card-content has-text-centered">
						<!-- RUT ASISTENTE -->
						<div class="field">
							<label class="label" for="rut-txt">Rut</label>
							<div class="control">
								<input class="input has-text-centered" type="text" id="rut-txt" name="rut-txt" placeholder="12983672-7" >
							</div>
						</div>
						<!-- NOMBRE ASISTENTE -->
						<div class="field">
							<label class="label" for="nombre-txt">Nombre</label>
							<div class="control">
								<input class="input has-text-centered" type="text" name="nombre-txt" id="nombre-txt" placeholder="Nombre Apellido">
							</div>
						</div>
						<!-- APELLIDO ASISTENTE -->
						<div class="field">
							<label class="label" for="apellido-txt">Apellido</label>
							<div class="control">
								<input class="input has-text-centered" type="text" name="apellido-txt" id="apellido-txt" placeholder="Apellido">
							</div>
						</div>
						<!-- EDAD -->
						<div class="field">
							<label class="label" for="edad-txt">Edad</label>
							<div class="control">
								<input class="input has-text-centered" type="number" name="edad-txt" id="edad-txt" placeholder="Debe ser Mayor de 18 Años">
							</div>
						</div>
						<!-- EMPRESA ASISTENTE -->
						<div class="field">
							<label class="label" for="empresa-txt">Empresa</label>
							<div class="control">
								<input class="input has-text-centered" type="text" name="empresa-txt" id="empresa-txt" placeholder="Nombre de Su Empresa">
							</div>
						</div>
						<!-- ESTADO -->
						<div class="field">
							<label class="label" for="estado-select">Estado</label>
							<div class="control">
								<div class="select">
									<select name="estado-select" id="estado-select">
										<option>Pagada</option>
										<option>Con Deuda</option>							
									</select>
								</div>
							</div>
						</div>
						<!-- REGION -->
						<div class="field">
							<label class="label" for="region-select">Región</label>
							<div class="control">
								<div class="select">
									<select name="region-select" id="region-select">
										<option>Valparaiso</option>
										<option>Santiago</option>		
										<option>Norte de Chile</option>
										<option>Sur de Chile</option>		
										<option>Internacional</option>			
									</select>
								</div>
							</div>
						</div>
					</div>
						
					<!-- FOOTER PARA ALOJAR EL BOTON -->
					<div class="card-footer has-text-centered">
						<div class="card-footer-item">
							<button class="button is-success" type="submit">Ingresar Asistente</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

</main>

</body>
</html>