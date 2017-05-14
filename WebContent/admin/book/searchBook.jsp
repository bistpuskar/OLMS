<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../adminHeader.jsp" />
<center>
	<div class="content">
		<form action="${pageContext.request.contextPath}/searchbook" id="formregister">

			<table class="full" >
				<tr>
					<td><input type="text" name="searchbook" /></td>
					
					 <td><input type="submit" value="Search Book" /> 
				</tr>
			</table>

		</form>
		
		<c:if test="${books!=null}">
		
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
			<tr>
		
			<td><c:out value="${books.b_id}"/> </td>
			<td><c:out value="${books.b_name}"/></td>
			<td><c:out value="${books.b_author }"/></td>
			<td><c:out value="${books.b_isbn }"/></td>
			<td><c:out value="${books.b_publication }"/></td>
			<td><c:out value="${books.b_publication_year }"/></td>
			<td><c:out value="${books.b_purchase_date }"/></td>
			<td><c:out value="${books.b_category }"/></td>
			<td><c:out value="${books.b_number }"/></td>
			<td><c:out value="${books.b_cost }"/></td>
			
			<td><a href="${pageContext.request.contextPath}/deleteBook?bookid=${books.b_id}"><img src="${pageContext.request.contextPath}/images/delete.png" height="40px"/></a></td>
			<td><a href="${pageContext.request.contextPath}/admin/book/updateBook.jsp?bookid=${books.b_id}"><img src="${pageContext.request.contextPath}/images/update.jpg" height="40px"/></a></td>
			
			</tr>	
		</table>
		</c:if>
		<h2 class="error">${mess}</h2>
	</div>

</center>


 <jsp:include page="../footer.jsp" />