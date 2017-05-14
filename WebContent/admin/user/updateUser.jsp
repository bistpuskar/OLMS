<jsp:include page="../adminHeader.jsp" />
<center>
	<div class="content">
		<h3>Enter User Detail</h3>
		<form action="${pageContext.request.contextPath}/updateuser" method="get" id="userform">
			<table class="full" >
				<tr>
					<td>Student ID</td>
					<td><input type="text" name="userid"  value="${param.userid}" readonly/></td>
				</tr>
				
				<tr>
				<td>Username</td>
				<td><input type="text" name="username"/></td>
				</tr>
				<tr>
				<td>Password</td>
				<td><input type="password" name="password"/></td>
				</tr>
				
				<tr>
					<td>First Name</td>
					<td><input type="text" name="fname" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lname" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td>Male:<input type="radio" name="gender" value="Male"/>
					   Female: <input type="radio"	name="gender" value="Female"></td>
				</tr>
				<tr>
					<td>Registered Date</td>
					<td><input type="date" name="registerdate" /></td>
				</tr>
				<tr>
					<td>Expire Date</td>
					<td><input type="date" name="expiredate" /></td>
				</tr>
				<tr>

					<td><input type="submit" value="Update User User" /></td>
					<td><input type="reset" value="  Clear  "/></td>
				</tr>
			</table>


		</form>
	</div>

</center>

<jsp:include page="../footer.jsp" />
