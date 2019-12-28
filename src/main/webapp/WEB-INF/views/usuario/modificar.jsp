<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navusuario.jsp"%>

<section id="formulario" class="bg-light-gray">

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h2 class="section-heading2">Modificar usuario</h2>
						</div>
					</div>
					<div class="col-lg-12 text-center">
					
						<form:form id="modificarusuarioForm" method="post" action="usuarios/modificar"
							modelAttribute="usuario">
							
							<div class="form-group">
								<form:input id="username" name="username" path="username"
									placeholder="Nombre de usuario" value="${usuario.username}" />
							</div>
							<div class="form-group">
								<form:password id="pass" name="pass" path="pass"
									placeholder="Contraseña" />
							</div>
							<div class="form-group">
								<form:input id="nombre" name="nombre" path="nombre"
									placeholder="Nombre" value="${usuario.nombre}"/>
							</div>
							<div class="form-group">
								<form:input id="apellidos" name="apellidos" path="apellidos"
									placeholder="Apellidos" value="${usuario.apellidos}"/>
							</div>
							<div class="form-group">
								<form:input id="anio_nacimiento" name="anio_nacimiento" path="anio_nacimiento"
									placeholder="Año nacimiento" value="${usuario.anio_nacimiento}"/>
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