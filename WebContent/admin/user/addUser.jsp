<jsp:include page="../adminHeader.jsp" />
<center>
	<div class="content">
		<h3>Enter User Detail</h3>
		<form action="${pageContext.request.contextPath}/adduser" method="get" id="userform">
			<table class="full" >
				<tr>
					<td>Student ID</td>
					<td><input type="text" name="userid" value="${uid}" readonly/></td>
				</tr>
				
				<tr>
				<td> Username </td>
				<td><input type="text" name="username"/>
				</tr>
				
				<tr>
				<td>Password</td>
				<td><input type="password" name="password"/>
				</tr>
				<td>User Type</td>
				<td>
				<select name="usertype">
				<option>Choose Usertype</option>
				<option>Admin</option>
				<option>Student</option>
				
				</select>
				
				
				</td>

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
					<td><input type="radio" name="gender" value="Male"/>
					    <input type="radio"	name="gender" value="Female" /></td>
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

					<td><input type="submit" value="Add User" /></td>
					<td><input type="reset" value="  Clear  "/></td>
				</tr>
			</table>


		</form>
	</div>

</center>

 <jsp:include page="../footer.jsp" />
