<%@include file="includes/head.jsp"%>
<%@include file="includes/menu.jsp"%>

<section id="contact">

	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="row">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h2 class="section-heading" style="color:#fec503;">Inicia sesión</h2>
						</div>
					</div>
					<div class="col-lg-12 text-center">					
					
						<form:form id="loginForm" method="post" action="home"
							modelAttribute="usuario">
							
							<div class="form-group">
								<form:input id="username" name="username" path="username"
									placeholder="Nombre de usuario" />
							</div>
							<div class="form-group">
								<form:password id="pass" name="pass" path="pass"
									placeholder="Contraseña" />
							</div>
							<div class="clearfix"></div>
							<div class="col-lg-12 text-center">
								<button type="submit" class="btn btn-xl">Entrar</button>
							</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</section>


<%@include file="includes/footer.jsp"%>