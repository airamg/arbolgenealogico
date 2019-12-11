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
					
						<form:form id="modificarmiembroForm" method="post" action="miembros/modificar/${miembro.id}"
							modelAttribute="miembro">
							
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
									placeholder="A�o nacimiento" value="${miembro.anioNacimiento}"/>
							</div>
							<div class="form-group">
								<form:input id="anioDefuncion" name="anioDefuncion" path="anioDefuncion"
									placeholder="A�o defuncion" value="${miembro.anioDefuncion}"/>
							</div>
							<div class="form-group">
								<form:input id="historialMedico" name="historialMedico" path="historialMedico"
									placeholder="Historial m�dico" value="${miembro.historialMedico}"/>
							</div>
							
							<div class="form-group">
								<!-- lista de parentescos -->
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