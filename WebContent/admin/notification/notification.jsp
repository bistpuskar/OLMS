<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../adminHeader.jsp" />
<center>
	<div class="content">
		<h1>User  Send Request for Issue Book</h1>
		<table class="full" border="1">
			<tr>
				<th>Id</th>
				<th>Requested Member Name</th>
				<th>Requested for Book Name</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${nlist}" var="n">
				<tr>
					<td><c:out value="${n.id}" /></td>
					<td><c:out value="${n.message}" /></td>
					<td><c:out value="${n.bookname}" /></td>
					<td><a href="${pageContext.request.contextPath}/deleteNotification?deleteid=${n.id}"><img src="${pageContext.request.contextPath}/images/delete.png" height="40px"/></a></td>
				</tr>

			</c:forEach>
		</table>

	</div>
</center>
<jsp:include page="../footer.jsp" />