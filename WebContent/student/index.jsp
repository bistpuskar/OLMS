<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="studentHeader.jsp" />
<center>
	<div class="content">
	<c:if test="${userlist!=null}">
		<h2>Your Detail Book Information</h2>
		<table class="full" border="1">
			<tr>
				<th>Book ID</th>
				<th>Book Name</th>
				<th>Book Author Name</th>
				<th>Book ISBN</th>
				<th>Publication Name</th>
				<th>Issue Date</th>
				<th>Return Date</th>
			</tr>
			<c:forEach items="${userlist}" var="u">
				<tr>
					<td><c:out value="${u.b_id}" /></td>
					<td><c:out value="${u.b_name}" /></td>
					<td><c:out value="${u.b_author}" /></td>
					<td><c:out value="${u.b_isbn}" /></td>
					<td><c:out value="${u.b_publication}" /></td>
					<td><c:out value="${u.issuedate}" /></td>
					<td><c:out value="${u.returndate}" /></td>

				</tr>


			</c:forEach>


		</table>
		</c:if>
		<h2 style="color: green;">${messagenotification}</h2>

	</div>
</center>
<jsp:include page="../footer.jsp" />