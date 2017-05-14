<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="studentHeader.jsp" />
<center>
	<div class="content">
		<h2>All Book Category List</h2>
		<table class="full" border="1">
			<tr>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Book author Name</th>
				<th>Book ISBN</th>
				<th>Publication Name</th>
				<th>Select Publication Year</th>
				<th>Book Category</th>
				<th>Request</th>
			</tr>
			<c:forEach items="${booklist}" var="b">

				<tr>
					<td><c:out value="${b.b_id}" /></td>
					<td><c:out value="${b.b_name}" /></td>
					<td><c:out value="${b.b_author}" /></td>
					<td><c:out value="${b.b_isbn}" /></td>
					<td><c:out value="${b.b_publication}" /></td>
					<td><c:out value="${b.b_publication_year}" /></td>
					<td><c:out value="${b.b_category}" /></td>
					<td>
						<form action="${pageContext.request.contextPath}/notification">
							<input type="hidden" name="usernames" value="${username}" /> <input
								type="hidden" name="bookname" value="${b.b_name}" /> <input
								type="submit" value=" Request " />
						</form>
					</td>
				</tr>


			</c:forEach>


		</table>
	</div>
</center>
<jsp:include page="../footer.jsp" />