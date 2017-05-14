<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../adminHeader.jsp" />
<center>
	<div class="content">
		<form action="${pageContext.request.contextPath}/updateBook" method="get" id="formregister">
			
			<table class="full">

				<tr>
					<td>Book Id</td>
					<td><input type="text" name="bookid" value="${param.bookid}" readonly /></td>
					<td>Book Name</td>
					<td><input type="text" name="bookname" /></td>
				</tr>
				<tr>
					<td>Book author Name</td>
					<td><input type="text" name="authorname" /></td>
					<td>Book ISBN</td>
					<td><input type="text" name="isbn" /></td>
				</tr>



				<tr>
					<td>Publication Name</td>
					<td><input type="text" name="publicationname" />
					<td>Select Publication Year</td>
					<td><input type="text" name="publicationyear" /></td>

				</tr>

				<tr>
					<td>Enter Purchasing Date</td>
					<td><input type="text" name="purchasedate" /></td>
					<td>Choose Category</td>
					<td><select name="bookcategory">
							<option>Select Category</option>
							<c:forEach items="${category}" var="bookcategory">
							<option>
							<c:out value="bookcategory.c_name"/>
							
							</option>
							</c:forEach>

					</select></td>
				</tr>

				<tr>
					<td>Number Of Book</td>
					<td><input type="text" name="booknumber" /></td>
					<td>Book Cost</td>
					<td><input type="text" name="bookcost" /></td>

				</tr>
				<tr>
					<td><input type="submit" value="Update Book" /></td>
				</tr>
			</table>

		</form>
	</div>

</center>
<jsp:include page="../footer.jsp" />