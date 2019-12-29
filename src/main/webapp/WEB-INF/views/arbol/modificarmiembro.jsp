<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navusuario.jsp"%>

<section id="formulario" class="bg-light-gray">

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h2 class="section-heading2">Modificar miembro</h2>
						</div>
					</div>
					<div class="col-lg-12 text-center">
					
						<form:form id="modificarmiembroForm" method="post" action="miembros/modificar"
							modelAttribute="miembro">
							
							<div class="form-group">
								<form:input type="hidden" id="id" name="id" path="id"
									placeholder="Id" value="${miembro.id}" />
							</div>							
							<div class="form-group">
								<form:input id="nombre" name="nombre" path="nombre"
									placeholder="Nombre" value="${miembro.nombre}" />
							</div>
							<div class="form-group">
								<form:input id="apellido" name="apellido" path="apellido"
									placeholder="Apellido" value="${miembro.apellido}"/>
							</div>
							<div class="form-group">
								<form:input id="anioNacimiento" name="anioNacimiento" path="anioNacimiento"
									placeholder="Año nacimiento" value="${miembro.anioNacimiento}"/>
							</div>
							<div class="form-group">
								<form:input id="anioDefuncion" name="anioDefuncion" path="anioDefuncion"
									placeholder="Año defuncion" value="${miembro.anioDefuncion}"/>
							</div>
							<div class="form-group">
								<form:textarea id="historialMedico" name="historialMedico" path="historialMedico"
									placeholder="Historial médico" value="${miembro.historialMedico}"/>
							</div>							
							<div class="form-group">
								<form:select path="idParentesco">
									<c:forEach var="parentesco" items="${lista_parentesco}">
										<c:choose>
											<c:when test="${parentesco_select==parentesco.id}">
												<form:option value="${parentesco.id}" label="${parentesco.descripcion}" selected="selected"/>
											</c:when>
											<c:otherwise>
												<form:option value="${parentesco.id}" label="${parentesco.descripcion}" />
											</c:otherwise>
										</c:choose>																		
									</c:forEach>
								</form:select>
							</div>							
							<div class="form-group">
								<form:select path="idDescendencia">
									<c:forEach var="descendencia" items="${lista_descendencia}">
										<c:choose>
											<c:when test="${descendencia_select==descendencia.id}">
												<form:option value="${descendencia.id}" label="${descendencia.tipoRama}" selected="selected"/>
											</c:when>
											<c:otherwise>
												<form:option value="${descendencia.id}" label="${descendencia.tipoRama}" />
											</c:otherwise>
										</c:choose>																			
									</c:forEach>
								</form:select>
							</div>
							
							<div class="clearfix"></div>
							<div class="col-lg-12 text-center">
								<button type="submit" class="btn btn-xl">Guardar</button>
							</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</section>

<%@include file="../includes/footerusuario.jsp"%>