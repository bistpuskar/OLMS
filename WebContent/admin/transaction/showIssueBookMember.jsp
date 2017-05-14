<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../adminHeader.jsp" />
<center>
	<div class="content">
		
		
				<div class="search">
			<form action="${pageContext.request.contextPath}/usersearch" method="get" id="formregister">
				<table class="full">
					<tr>
						<td colspan="2" align="center"><b>User Search Panel</b></td>
					</tr>
					<tr>
						<td><input type="text" name="searchuser" /></td>
						<td><input type="submit" value="search" /></td>
					</tr>
					<tr>
					</tr>
				</table>
			</form>
		<h2 class="error">${messag}</h2>
		</div>
	<c:if test="${usr!=null}">
	<table class="full" border="1">
	
	<tr>
				<th>User ID</th>
				<th>User name</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Gender</th>
				<th>Registered Date</th>
				<th>Expire Dates</th>
				
			</tr>
			
				<tr>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${usr.id}&names=${usr.username}"><c:out value="${usr.id}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${usr.id}&names=${usr.username}"><c:out value="${usr.username}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${usr.id}&names=${usr.username}"><c:out value="${usr.firstname}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${usr.id}&names=${usr.username}"><c:out value="${usr.lastname}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${usr.id}&names=${usr.username}"><c:out value="${usr.email}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${usr.id}&names=${usr.username}"><c:out value="${usr.address}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${usr.id}&names=${usr.username}"><c:out value="${usr.gender}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${usr.id}&names=${usr.username}"><c:out value="${usr.registerdate}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${usr.id}&names=${usr.username}"><c:out value="${usr.expiredate }"/></a></td>

				</tr>
	</table>
	</c:if>
		<c:if test="${usr==null}">
		
		<table class="full" border="1">
		
			<tr>
				<th>User ID</th>
				<th>User name</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Gender</th>
				<th>Registered Date</th>
				<th>Expire Date</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${user.id}&names=${user.username}"><c:out value="${user.id}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${user.id}&names=${user.username}"><c:out value="${user.username}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${user.id}&names=${user.username}"><c:out value="${user.firstname}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${user.id}&names=${user.username}"><c:out value="${user.lastname}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${user.id}&names=${user.username}"><c:out value="${user.email}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${user.id}&names=${user.username}"><c:out value="${user.address}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${user.id}&names=${user.username}"><c:out value="${user.gender}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${user.id}&names=${user.username}"><c:out value="${user.registerdate}"/></a></td>
					<td><a href="${pageContext.request.contextPath}/issuedetail?id=${user.id}&names=${user.username}"><c:out value="${user.expiredate }"/></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	</div>
</center>
<jsp:include page="../footer.jsp" />






