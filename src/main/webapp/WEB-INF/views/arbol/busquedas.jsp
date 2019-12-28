<%@include file="../includes/head.jsp"%>
<%@include file="../includes/navusuario.jsp"%>

<section id="team" class="bg-light-gray">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading2">RESULTADOS SOBRE MI B�SQUEDA</h2>
			</div>
		</div>
		<div class="row">
			<c:choose>
				<c:when test="${sinMiembros}">
					<div class="col-lg-12 text-center">
						<div class="team-member">				
							<p>No hay miembros que tengan informaci�n registrada sobre lo que se intenta buscar.</p>
						</div>
					</div>		
				</c:when>
				<c:otherwise>
					<div class="col-lg-12 text-center">
						<div class="team-member">				
							<p>Hay ${numMiembros} miembro(s) que tiene(n) registrada la patolog�a "${enfermedad}" en su historial m�dico.</p>
						</div>
					</div>				
					<c:forEach var="miembro" items="${lista_miembros}">		
						<div class="col-sm-4">
							<div class="team-member">
								<h4>${miembro.nombre} ${miembro.apellido}</h4>
								<p class="text-muted">${miembro.parentesco}
									<c:choose>
										<c:when test="${miembro.descendencia==''}"></c:when>
									    <c:otherwise> - </c:otherwise>
									</c:choose>					
									${miembro.descendencia}<br/>${miembro.edad}<br/>${miembro.historialMedico}</p>
								
							</div>				
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>	
		</div>				
	</div>
</section>

<%@include file="../includes/footerusuario.jsp"%>