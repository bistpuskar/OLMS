<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="studentHeader.jsp" />
<center>
	<div class="content">
		<form action="${pageContext.request.contextPath}/books"
			id="formregister">

			<table class="full">
				<tr>
					<td><input type="text" name="searchbook" /></td>

					<td><input type="submit" value="Search Book" />
				</tr>
			</table>
			${messg}
		</form>


		<c:if test="${booklist!=null}">
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
				<tr>
					<td><c:out value="${booklist.b_id}" /></td>
					<td><c:out value="${booklist.b_name}" /></td>
					<td><c:out value="${booklist.b_author}" /></td>
					<td><c:out value="${booklist.b_isbn}"/></td>
					<td><c:out value="${booklist.b_publication}"/></td>
					<td><c:out value="${booklist.b_publication_year}" /></td>
					<td><c:out value="${booklist.b_category}" /></td>
					<td>
						<form action="${pageContext.request.contextPath}/notification">
							<input type="hidden" name="usernames" value="${username}" /> <input
								type="hidden" name="bookname" value="${booklist.b_name}" /> <input
								type="submit" value=" Request " />
						</form>
					</td>
				</tr>
			</table>
		</c:if>
	</div>

</center>

<jsp:include page="../footer.jsp" />