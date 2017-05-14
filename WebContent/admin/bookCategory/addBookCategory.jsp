<jsp:include page="../adminHeader.jsp" />
<center>
	<div class="content">
		<form action="${pageContext.request.contextPath}/addBookCategory"
			method="get" id="formregister">
			<table class="full">
				<tr>
					<td>Category ID</td>
					<td><input type="text" value="${ids}" /></td>
				</tr>
				<tr>
					<td>Category Name</td>

					<td><input type="text" name="category" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add Category" /></td>
					<td><input type="reset" value="  Clear  " /></td>
				</tr>
			</table>
		</form>
	</div>
</center>
<jsp:include page="../footer.jsp" />