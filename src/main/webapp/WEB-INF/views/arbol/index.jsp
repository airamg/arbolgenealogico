<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navusuario.jsp"%>

<section id="team" class="bg-light-gray">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading2">GESTIÓN DE MIEMBROS DEL ÁRBOL</h2>
			</div>
		</div>
		<div class="row">
			<c:choose>
				<c:when test="${sinMiembros}">
					<div class="col-lg-12 text-center">
						<div class="team-member">				
							<ul class="list-inline social-buttons">
								<li><a href="miembros/nuevo"><i class="fa fa-plus fa-3x fa-stack-2x text-primary"></i></a></li>
							</ul>
						</div>
					</div>		
				</c:when>
				<c:otherwise>
					<div class="col-sm-2 text-center">
						<div class="team-member-sinborde"></div>
					</div>
					<div class="col-sm-1 text-center">
						<div class="team-member">
							<ul class="list-inline social-buttons">
								<li><a href="miembros/nuevo"><i class="fa fa-plus fa-3x fa-stack-2x text-primary"></i></a></li>
							</ul>							
						</div>
					</div>
					<div class="col-sm-1 text-center">
						<div class="team-member">
							<ul class="list-inline social-buttons">
								<li><a href="miembros/arbol"><i class="fa fa-tree fa-3x fa-stack-2x text-primary"></i></a></li>
							</ul>							
						</div>
					</div>
					<div class="col-sm-1 text-center">
						<div class="team-member-sinborde"></div>
					</div>
					<form:form id="busquedasForm" method="post" action="miembros/buscar" modelAttribute="miembro">
						<div class="col-sm-4 text-center">
							<div class="team-member">							
								<div class="form-group">
									<form:input style="width:380px; height:45px;" id="historialMedico" name="historialMedico" path="historialMedico" placeholder="¿Qué quieres buscar en el historial médico familiar?" />
								</div>	
							</div>
						</div>
						<div class="col-sm-1 text-center">
							<div class="team-member">
								<ul class="list-inline social-buttons">
									<li><button style="width:50px;height:44px;background-color:black;" type="submit" class="fa fa-search fa-3x fa-stack-2x-button text-primary"></button></li>
								</ul>							
							</div>
						</div>
					</form:form>
				</c:otherwise>
			</c:choose>	
		</div>	
		<div class="row">
			<c:forEach var="miembro" items="${lista_miembros}">		
			<div class="col-sm-5">
				<div class="team-member">
					<img src="${pageContext.request.contextPath}/${miembro.rutaImagen}" height=200px; width=200px; class="img-responsive img-circle" alt="">
					<h4>${miembro.nombre} ${miembro.apellido}</h4>
					<p class="text-muted">${miembro.parentesco}
						<c:choose>
							<c:when test="${miembro.descendencia==''}"></c:when>
						    <c:otherwise> - </c:otherwise>
						</c:choose>					
						${miembro.descendencia}<br/>${miembro.anioNacimiento} - ${miembro.anioDefuncion}<br/>${miembro.historialMedico}</p>
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