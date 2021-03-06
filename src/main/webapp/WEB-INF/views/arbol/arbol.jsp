<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navusuario.jsp"%>

<section id="team" class="bg-light-gray">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading2">MI �RBOL GENEAL�GICO</h2>
			</div>
		</div>
		<div class="row">
			<c:forEach var="miembro" items="${lista_miembros_rama2}">	
				<div class="col-sm-1">					
					<c:choose>
						<c:when test="${miembro.rutaImagen==''}">
							<div class="team-member-sinborde"></div>
						</c:when>
						<c:otherwise>
							<div class="team-member">
								<img src="${pageContext.request.contextPath}/${miembro.rutaImagen}" height=100px; width=100px; class="img-responsive img-circle" alt="">
								<p class="text-muted">${miembro.parentesco}<br/>${miembro.nombre}<br/>${miembro.edad}<br/>${miembro.historialMedico}</p>
							</div>
						</c:otherwise>
					</c:choose>									
				</div>
			</c:forEach>				
		</div>
		<div class="row">
			<div class="col-sm-1">					
				<div class="team-member-sinborde"></div>				
			</div>
			<div class="col-sm-1">					
				<div class="team-member-sinborde"></div>				
			</div>
			<div class="col-sm-3" style="text-align:center">					
				<div class="team-member-sinborde">
					<img src="${pageContext.request.contextPath}/resources/images/arbol/${row_Abuelos_TiosPadres_a}" height=250px; width=210px; alt="">
				</div>				
			</div>
			<div class="col-sm-1">					
				<div class="team-member-sinborde"></div>
			</div>
			<div class="col-sm-3">					
				<div class="team-member-sinborde" style="text-align:center">
					<img src="${pageContext.request.contextPath}/resources/images/arbol/${row_Abuelos_TiosPadres_b}" height=250px; width=210px; alt="">
				</div>				
			</div>
			<div class="col-sm-1">					
				<div class="team-member-sinborde"></div>	
			</div>
			<div class="col-sm-1">					
				<div class="team-member-sinborde"></div>	
			</div>		
		</div>		
		<div class="row">
			<c:forEach var="miembro" items="${lista_miembros_rama1}">	
				<div class="col-sm-1">					
					<c:choose>
						<c:when test="${miembro.rutaImagen==''}">
							<div class="team-member-sinborde">
								<p class="text-muted"><br/><br/></p>
							</div>
						</c:when>
						<c:otherwise>
							<div class="team-member">
								<img src="${pageContext.request.contextPath}/${miembro.rutaImagen}" height=100px; width=100px; class="img-responsive img-circle" alt="">
								<p class="text-muted">${miembro.parentesco}<br/>${miembro.nombre}<br/>${miembro.edad}<br/>${miembro.historialMedico}</p>
							</div>
						</c:otherwise>
					</c:choose>									
				</div>
			</c:forEach>					
		</div>
		<div class="row">
			<div class="col-sm-3">					
				<div class="team-member-sinborde" style="text-align:center">
					<img src="${pageContext.request.contextPath}/resources/images/arbol/${row_TiosPadres_PrimosHermanos_a}" height=250px; width=210px; alt="">
				</div>				
			</div>
			<div class="col-sm-5">					
				<div class="team-member-sinborde" style="text-align:center">
					<img src="${pageContext.request.contextPath}/resources/images/arbol/${row_TiosPadres_PrimosHermanos_b}" height=250px; width=400px; alt="">
				</div>				
			</div>
			<div class="col-sm-3">					
				<div class="team-member-sinborde" style="text-align:center">
					<img src="${pageContext.request.contextPath}/resources/images/arbol/${row_TiosPadres_PrimosHermanos_c}" height=250px; width=210px; alt="">
				</div>				
			</div>
		</div>
		<div class="row">
			<c:forEach var="miembro" items="${lista_miembros_rama0}">	
				<div class="col-sm-1">					
					<c:choose>
						<c:when test="${miembro.rutaImagen==''}">
							<div class="team-member-sinborde"></div>
						</c:when>
						<c:otherwise>
							<div class="team-member">
								<img src="${pageContext.request.contextPath}/${miembro.rutaImagen}" height=100px; width=100px; class="img-responsive img-circle" alt="">
								<p class="text-muted">${miembro.parentesco}<br/>${miembro.nombre}<br/>${miembro.edad}<br/>${miembro.historialMedico}</p>
							</div>
						</c:otherwise>
					</c:choose>									
				</div>
			</c:forEach>			
		</div>		
	</div>
</section>

<%@include file="../includes/footerusuario.jsp"%>