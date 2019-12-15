<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navusuario.jsp"%>

<section id="team" class="bg-light-gray">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading2">MI ÁRBOL GENEALÓGICO</h2>
			</div>
		</div>
		<div class="row">
			<c:forEach var="miembro" items="${lista_miembros_rama2}">	
				<div class="col-sm-11">					
					<div class="team-member">
						<img src="${pageContext.request.contextPath}/${miembro.rutaImagen}" height=100px; width=100px; class="img-responsive img-circle" alt="">
						<p class="text-muted">${miembro.parentesco} - ${miembro.nombre}</p>
					</div>				
				</div>
			</c:forEach>		
		</div>
		<div class="row">
			<div class="col-sm-5">					
				<div class="team-member"> </div>				
			</div>
			<div class="col-sm-5">					
				<div class="team-member">
					<img src="${pageContext.request.contextPath}/arbol/${row_Abuelos_TiosPadres_a}" height=100px; width=200px; class="img-responsive img-circle" alt="">
				</div>				
			</div>
			<div class="col-sm-5">					
				<div class="team-member"> </div>				
			</div>
			<div class="col-sm-5">					
				<div class="team-member">
					<img src="${pageContext.request.contextPath}/arbol/${row_Abuelos_TiosPadres_b}" height=100px; width=200px; class="img-responsive img-circle" alt="">
				</div>				
			</div>
			<div class="col-sm-5">					
				<div class="team-member"> </div>				
			</div>		
		</div>		
		<div class="row">
			<c:forEach var="miembro" items="${lista_miembros_rama1}">		
				<div class="col-sm-11">
					<div class="team-member">
						<img src="${pageContext.request.contextPath}/${miembro.rutaImagen}" height=100px; width=100px; class="img-responsive img-circle" alt="">
						<p class="text-muted">${miembro.parentesco} - ${miembro.nombre}</p>
					</div>				
				</div>	
			</c:forEach>
		</div>
		<div class="row">
			<div class="col-sm-3">					
				<div class="team-member">
					<img src="${pageContext.request.contextPath}/arbol/${row_TiosPadres_PrimosHermanos_a}" height=100px; width=200px; class="img-responsive img-circle" alt="">
				</div>				
			</div>
			<div class="col-sm-3">					
				<div class="team-member">
					<img src="${pageContext.request.contextPath}/arbol/${row_TiosPadres_PrimosHermanos_b}" height=100px; width=200px; class="img-responsive img-circle" alt="">
				</div>				
			</div>
			<div class="col-sm-3">					
				<div class="team-member">
					<img src="${pageContext.request.contextPath}/arbol/${row_TiosPadres_PrimosHermanos_c}" height=100px; width=200px; class="img-responsive img-circle" alt="">
				</div>				
			</div>
		</div>
		<div class="row">
			<c:forEach var="miembro" items="${lista_miembros_rama0}">		
				<div class="col-sm-11">
					<div class="team-member">
						<img src="${pageContext.request.contextPath}/${miembro.rutaImagen}" height=100px; width=100px; class="img-responsive img-circle" alt="">
						<p class="text-muted">${miembro.parentesco} - ${miembro.nombre}</p>
					</div>				
				</div>
			</c:forEach>
			<div class="col-sm-11">	
				<div class="team-member">
					<img src="${pageContext.request.contextPath}/${usuario.ruta_imagen}" height=100px; width=100px; class="img-responsive img-circle" alt="">
					<p class="text-muted">Yo - ${usuario.nombre}</p>
				</div>
			</div>			
		</div>		
	</div>
</section>

<%@include file="../includes/footerusuario.jsp"%>