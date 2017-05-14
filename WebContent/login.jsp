<jsp:include page="header.jsp" />
<center>
	<div class="content">
		<form method="post" action="${pageContext.request.contextPath}/logincheck" id="userform">
		<h3>Login Form</h3>
			<table class="full">
			
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" />
				</tr>
				<tr>
				<td>Password</td>
				<td><input type="password" name="password" />
				</tr>
			
				<tr>
				<td colspan="2"> ${message}</td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
			</table>

		</form>
	</div>

</center>
<jsp:include page="footer.jsp" />