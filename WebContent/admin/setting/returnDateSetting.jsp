
<jsp:include page="../adminHeader.jsp" />
<center>
	<div class="content">
		<form action="${pageContext.request.contextPath}/returndate" id="settings">
			<table class="full">
				<tr>
					<td>Previous Book Return Duration</td>
					<td><input type="text" value="${days.returndate}" readonly /></td>
				</tr>
				<tr>
					<td>Enter new Book Return Duration</td>
					<td><input type="text" name="bookduration" />
				</tr>
				<tr>
					<td><input type="submit" value="Change Book Return Date" /></td>
					<td><input type="reset" value="  Clear  "/></td>
				</tr>
			</table>

		</form>
	</div>
</center>
<jsp:include page="../footer.jsp" />