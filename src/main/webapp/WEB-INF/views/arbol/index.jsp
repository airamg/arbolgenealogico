<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navusuario.jsp"%>

<section id="team" class="bg-light-gray">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading2">MI ÁRBOL GENEALÓGICO</h2>
				<div class="team-member">
					<ul class="list-inline social-buttons">
						<li><a href="miembros/arbol"><i class="fa fa-tree fa-3x fa-stack-2x text-primary"></i></a></li>
					</ul>
					<ul class="list-inline social-buttons">
						<li><a href="miembros/nuevo"><i class="fa fa-plus fa-3x fa-stack-2x text-primary"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row">
			<c:forEach var="miembro" items="${lista_miembros}">		
			<div class="col-sm-4">
				<div class="team-member">
					<img src="${pageContext.request.contextPath}/${miembro.rutaImagen}" height=255px; width=255px; class="img-responsive img-circle" alt="">
					<h4>${miembro.nombre} ${miembro.apellido}</h4>
					<p class="text-muted">${miembro.parentesco}<br/>${miembro.anioNacimiento} - ${miembro.anioDefuncion}<br/>${miembro.historialMedico}</p>
					<ul class="list-inline social-buttons">
						<li><a href="miembros/modificar/${miembro.id}"><i class="fa fa-pencil fa-3x fa-stack-2x text-primary"></i></a></li>
					</ul>
					<ul class="list-inline social-buttons">
						<li><a href="miembros/eliminar/${miembro.id}"><i class="fa fa-minus fa-3x fa-stack-2x text-primary"></i></a></li>
					</ul>
				</div>				
			</div>
			</c:forEach>
		</div>			
	</div>
</section>

<%@include file="../includes/footerusuario.jsp"%>