<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navusuario.jsp"%>

<section id="formulario" class="bg-light-gray">

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h2 class="section-heading2">Nuevo miembro</h2>
						</div>
					</div>
					<div class="col-lg-12 text-center">
					
						<form:form id="nuevomiembroForm" method="post" action="miembros/nuevo"
							modelAttribute="miembro">
							
							<div class="form-group">
								<form:input id="nombre" name="nombre" path="nombre"
									placeholder="Nombre" />
							</div>
							<div class="form-group">
								<form:input id="apellido" name="apellido" path="apellido"
									placeholder="Apellido" />
							</div>
							<div class="form-group">
								<form:input id="anioNacimiento" name="anioNacimiento" path="anioNacimiento"
									placeholder="Año nacimiento" />
							</div>
							<div class="form-group">
								<form:input id="anioDefuncion" name="anioDefuncion" path="anioDefuncion"
									placeholder="Año defuncion" />
							</div>
							<div class="form-group">
								<form:textarea id="historialMedico" name="historialMedico" path="historialMedico"
									placeholder="Historial médico" />
							</div>							
							<div class="form-group">
								<form:select path="idParentesco">
									<c:forEach var="parentesco" items="${lista_parentesco}">
										<form:option value="${parentesco.id}" label="${parentesco.descripcion}" />							
									</c:forEach>
								</form:select>
							</div>							
							<div class="form-group">
								<form:select path="idDescendencia">
									<c:forEach var="descendencia" items="${lista_descendencia}">
										<form:option value="${descendencia.id}" label="${descendencia.tipoRama}" />									
									</c:forEach>
								</form:select>
							</div>

							<div class="clearfix"></div>
							<div class="col-lg-12 text-center">
								<button type="submit" class="btn btn-xl">Crear</button>
							</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</section>


<%@include file="../includes/footerusuario.jsp"%>
