<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../adminHeader.jsp" />
<center>
	<div class="content">
		<div class="search">
		Welcome:${user}		
			<form action="${pageContext.request.contextPath}/searchIssueBook">
				<table class="full">
					<tr>
						<td>Enter Book Name</td>
					</tr>
					<tr>
					

						<td><input type="text" name="booksearch" /></td>
						<td><input type="submit" value="Search" /></td>
						<td><input type="hidden" name="names" value="${user}"/></td>
						<td><input type="hidden" name="id" value="${ids}"/></td>

					</tr>
				</table>
			</form>
		<h3 class="error">${messag}</h3>
		</div>


		<br /> <br /> <br /> <br />
			<c:if test="${books!=null}">
		
		<table class="full" border="1">
			<tr>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Book author Name</th>
				<th>Book ISBN</th>
				<th>Publication Name</th>
				<th>Issue Date</th>
				<th>Return Date</th>
				<th>Status</th>
				
			</tr>
			<tr>
		
			<td><c:out value="${books.b_id}"/> </td>
			<td><c:out value="${books.b_name}"/></td>
			<td><c:out value="${books.b_author}"/></td>
			<td><c:out value="${books.b_isbn}"/></td>
			<td><c:out value="${books.b_publication}"/></td>
			<td><c:out value="${books.issuedate}"/></td>
			<td><c:out value="${books.returndate}"/></td>
			<td>
			<form action="${pageContext.request.contextPath}/issueBook">
					<input type="hidden" name="names" value="${user}"/>
					<input type="hidden" name="id" value="${ids}"/>
					<input type="hidden" name="book_id" value="${books.b_id}" /> 
					<input type="hidden" name="book_name" value="${books.b_name}" /> 
					<input type="hidden" name="book_author" value="${books.b_author}" />
					<input type="hidden" name="book_isbn" value="${books.b_isbn}" /> 
					<input type="hidden" name="book_publication" value="${books.b_publication}"/>
					<input type="hidden" name="book_issue" value="${books.issuedate}"/>
					<input type="hidden" name="book_return" value="${books.returndate}"/> 
					<input type="submit" value="Issue" />

			
			</form>
			
			</td>
			</tr>	
		</table>
	
		</c:if>
					
		<div class="member">
			<table border="1">

				<tr>
					<th>Book Id</th>
					<th>Book Name</th>
					<th>Author Name</th>
					<th>Book ISBN</th>
					<th>Publication Name</th>
					<th>Issue Date</th>
					<th>Expire Date</th>
					<th>Fine</th>
					<th>Status</th>
				</tr>

				<tr>
				
				<c:forEach items="${issuelist}" var="b">
				<tr>
				<td><c:out value="${b.b_id}"/></td>
				<td><c:out value="${b.b_name}"/></td>
				<td><c:out value="${b.b_author}"/></td>
				<td><c:out value="${b.b_isbn}"/></td>
				<td><c:out value="${b.b_publication}"/></td>
				<td><c:out value="${b.issuedate}"/></td>
				<td><c:out value="${b.returndate}"/></td>
				<td><c:out value="${b.fine}"/></td>
				<td><form action="${pageContext.request.contextPath}/returnbooks">
						<input type="hidden" name="names" value="${user}"/>
						<input type="hidden" name="id" value="${ids}"/>
						<input type="hidden" name="issueid" value="${b.b_id}"/> 
						<input type="submit" value="Return" />
						</form></td>
				</tr>
				
				</c:forEach>
			
			</table>
		</div>
		
		</div>
		
		
		</center>

<jsp:include page="../footer.jsp" />

