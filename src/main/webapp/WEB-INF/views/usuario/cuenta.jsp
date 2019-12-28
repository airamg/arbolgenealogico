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
								<p class="text-muted">${usuario.anio_nacimiento}</p>
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
					<li class="timeline-inverted">
						<div class="timeline-image">
							<img class="img-circle img-responsive"
								src="${pageContext.request.contextPath}/resources/images/usuario/miembros.png"
								height=156px; width=156px; alt="">
						</div>
						<div class="timeline-panel">
							<div class="timeline-heading">
								<h4>Miembros de mi árbol</h4>
								<c:choose>
									<c:when test="${listaMiembrosVacia}">
										<p class="text-muted">No has añadido ningún miembro todavía.</p>
									</c:when>
						    		<c:otherwise></c:otherwise>
								</c:choose>									
							</div>
							<div class="timeline-body">
								<c:forEach var="miembro" items="${lista_miembros}">
									<p>${miembro.nombre} ${miembro.apellido} - ${miembro.parentesco}</p>
								</c:forEach>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
</section>

<%@include file="../includes/footerusuario.jsp"%>