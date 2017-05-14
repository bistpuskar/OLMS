<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../adminHeader.jsp" />
<center>
	<div class="content">
		<form>
		<h3 class="link">
			<a href="${pageContext.request.contextPath }/categoryid">Add Book Category</a>
		</h3>
		<table class="full" border="1" width="80%">
		
		<tr>
			<th>S.N</th>
			<th>Category</th>
			<th>delete</th>
			<th>update</th>
		</tr>
		<c:forEach items="${category}" var="bookcategory">
		<tr>
		   <td><c:out value="${bookcategory.c_id}"/></td>
		   <td><c:out value="${bookcategory.c_name}"/></td>
		   <td><a href="${pageContext.request.contextPath}/deleteBookCategory?id=${bookcategory.c_id}"><img src="${pageContext.request.contextPath}/images/delete.png" height="40px" /></a></td>
		   <td><a href="${pageContext.request.contextPath}/admin/bookCategory/updateBookCategory.jsp?ids=${bookcategory.c_id}"><img src="${pageContext.request.contextPath }/images/update.jpg" height="40px" /> </a></td>
		</tr>
		</c:forEach>
		</table>
		</form>
	</div>
</center>
<jsp:include page="../footer.jsp" />