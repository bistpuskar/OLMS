<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="studentHeader.jsp" />
<center>
	<div class="content">
	<h2>Book Category List</h2>
		<table class="full" border="1">
			<tr>
				<th>Category ID</th>
				<th>Category Name</th>
			</tr>
			<c:forEach items="${clist}" var="c">
				<tr>
					<td><c:out value="${c.c_id}" /></td>
					<td><c:out value="${c.c_name}" /></td>
				</tr>

			</c:forEach>
		</table>

	</div>

</center>
<jsp:include page="../footer.jsp" />