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
					
						<form:form id="modificarmiembroForm" method="post" action="arbol/modificarmiembro"
							modelAttribute="usuario">
							
							<div class="form-group">
								<form:input id="parentesco" name="parentesco" path="parentesco"
									placeholder="Parentesco" value="${usuario.username}" />
									<!-- devolver lista de parentescos -->
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