<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navusuario.jsp"%>

<section id="about">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading2">MI ÁRBOL GENEALÓGICO</h2>
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
								<!-- miembros del arbol con ramas -->
							</div>
							<div class="timeline-body">								
								<a href="arbol/modificarmiembro" class="btn btn-xl">Modificar miembro</a>						
							</div>
							<div class="timeline-body">								
								<a href="arbol/eliminarmiembro" class="btn btn-xl">Eliminar miembro</a>						
							</div>
							<div class="row">
							<div class="col-lg-12 text-center">
								<h2 class="section-heading"></h2>							
							</div>
						</div>
							<div class="timeline-body">								
								<a href="arbol/nuevomiembro" class="btn btn-xl">Nuevo miembro</a>						
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</section>

<%@include file="../includes/footerusuario.jsp"%>