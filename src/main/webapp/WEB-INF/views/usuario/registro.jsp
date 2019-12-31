<%@include file="../includes/head.jsp"%>
<%@include file="../includes/menu.jsp"%>

<section id="contact">

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h2 class="section-heading" style="color:#fec503;">Nuevo usuario</h2>
						</div>
					</div>
					<div class="col-lg-12 text-center">
					
						<form:form id="registrousuarioForm" method="post" action="registrousuario"
							modelAttribute="usuario">
							
							<div class="form-group">
								<form:input id="username" name="username" path="username"
									placeholder="Nombre de usuario" />
							</div>
							<div class="form-group">
								<form:password id="pass" name="pass" path="pass"
									placeholder="Contraseña" />
							</div>
							<div class="form-group">
								<form:input id="nombre" name="nombre" path="nombre"
									placeholder="Nombre" />
							</div>
							<div class="form-group">
								<form:input id="apellidos" name="apellidos" path="apellidos"
									placeholder="Apellidos" />
							</div>
							<div class="form-group">
								<form:input id="anio_nacimiento" name="anio_nacimiento" path="anio_nacimiento"
									placeholder="Año nacimiento" />
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


<%@include file="../includes/footer.jsp"%>
