<%@page import="java.sql.PreparedStatement"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../adminHeader.jsp" />
<center>
	<div class="content">
		<form action="${pageContext.request.contextPath}/updateBookCategory" method="get" id="formregister">
			<table>
				<tr>
					<td>Category Id</td>
					<td><input type="text" value="${param.ids}" name="id" readonly/></td>
				</tr>
				<tr>
				<td>Category Name</td>
					<td><input type="text" name="category" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update" /></td>
				</tr>

			</table>
		</form>
		
		
		
	</div>
</center>
 <jsp:include page="../footer.jsp" />