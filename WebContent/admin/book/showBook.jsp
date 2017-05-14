<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../adminHeader.jsp" />
<center>
	<div class="content">
		<h3 class="link">
			<a href="${pageContext.request.contextPath }/bookid"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;Add
				Book</a>
		</h3>
		<table class="full" border="1">
			<tr>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Book author Name</th>
				<th>Book ISBN</th>
				<th>Publication Name</th>
				<th>Select Publication Year</th>
				<th>Enter Purchasing Date</th>
				<th>Category</th>
				<th>Number Of Book</th>
				<th>Book Cost</th>
				<th>Delete</th>
				<th>Update</th>
				 
			</tr>

			<c:forEach items="${books}" var="book">
			<tr>
			<td><c:out value="${book.b_id}"/></td>
			<td><c:out value="${book.b_name}"/></td>
			<td><c:out value="${book.b_author}"/></td>
			<td><c:out value="${book.b_isbn}"/></td>
			<td><c:out value="${book.b_publication}"/></td>
			<td><c:out value="${book.b_publication_year}"/></td>
			<td><c:out value="${book.b_purchase_date}"/></td>
			<td><c:out value="${book.b_category}"/></td>
			<td><c:out value="${book.b_number}"/></td>
				<td><c:out value="${book.b_cost}"/></td>
			<td><a href="${pageContext.request.contextPath}/deleteBook?bookid=${book.b_id}"><img src="${pageContext.request.contextPath}/images/delete.png" height="40px"/></a></td>
			<td><a href="${pageContext.request.contextPath}/admin/book/updateBook.jsp?bookid=${book.b_id}"><img src="${pageContext.request.contextPath}/images/update.jpg" height="40px"/></a></td>
			</tr>
			</c:forEach>
			
			


		</table>
	</div>
</center>
<jsp:include page="../footer.jsp" />