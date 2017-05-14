<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../adminHeader.jsp" />
<center>
	<div class="content">
		<h3 class="link">
			<a href="${pageContext.request.contextPath }/userid">Add User</a>
		</h3>
		<table class="full" border="1">
			<tr>
				<th>Student ID</th>
				<th>Username</th>
				<th>Password</th>
				<th>Usertype</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Gender</th>
				<th>Registered Date</th>
				<th>Expire Date</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>
			<c:forEach items="${users}" var="userlist">
			<tr>
			 <td><c:out value="${userlist.id}"/></td>
			 <td><c:out value="${userlist.username}"/></td>
			  <td><c:out value="${userlist.password}"/></td>
			   <td><c:out value="${userlist.usertype}"/></td>
			 <td><c:out value="${userlist.firstname}"/></td>
			 <td><c:out value="${userlist.lastname}"/></td>
			 <td><c:out value="${userlist.email}"/></td>
			 <td><c:out value="${userlist.address}"/></td>
			 <td><c:out value="${userlist.gender}"/></td>
			 <td><c:out value="${userlist.registerdate}"/></td>
			 <td><c:out value="${userlist.expiredate}"/></td>
			 <td><a href="${pageContext.request.contextPath}/deleteuser?userid=${userlist.id}"><img src="${pageContext.request.contextPath}/images/delete.png" height="40px"/></a>
			 <td><a href="${pageContext.request.contextPath}/admin/user/updateUser.jsp?userid=${userlist.id}"><img src="${pageContext.request.contextPath}/images/update.jpg" height="40px"/></a>
			</tr>
			</c:forEach>
						
		</table>
	</div>

</center>
<jsp:include page="../footer.jsp" />