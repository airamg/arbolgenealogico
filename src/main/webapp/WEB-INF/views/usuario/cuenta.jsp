<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navusuario.jsp"%>

<section id="about">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading2">HOLA, ${usuario.username}</h2>
				<h3 class="section-subheading text-muted">Última conexión:
					${usuario.ultima_conexion}</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<ul class="timeline">
					<li>
						<div class="timeline-image">
							<img class="img-circle img-responsive"
								src="${pageContext.request.contextPath}/${usuario.ruta_imagen}"
								height=156px; width=156px; alt="">
						</div>
						<div class="timeline-panel">
							<div class="timeline-heading">
								<h4>${usuario.nombre} ${usuario.apellidos}</h4>
								<p class="text-muted">${usuario.email}</p>
							</div>
							<div class="timeline-body">								
								<a href="usuarios/modificar" class="btn btn-xl">Modificar datos</a>						
							</div>
							<div class="row">
							<div class="col-lg-12 text-center">
								<h2 class="section-heading"></h2>							
							</div>
						</div>
							<div class="timeline-body">								
								<a href="usuarios/borrar" class="btn btn-xl">Borrar cuenta</a>						
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</section>

<%@include file="../includes/footerusuario.jsp"%>