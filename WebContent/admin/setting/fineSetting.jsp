<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../adminHeader.jsp" />

<center>
	<div class="content">
		<form action="${pageContext.request.contextPath}/fineperday" id="settings">

			<table class="full">
				<tr>
					<td>Previous FineRate</td>

					<td><input type="text" value="${day.finePerDay}" readonly /></td>
				</tr>
				<tr>
					<td>Enter new FineRate</td>
					<td><input type="text" name="finerate"></td>
				</tr>
				<tr>
					<td><input type="submit" value="ChangeFineDay" /></td>
					<td><input type="reset" value="  Clear  "/></td>
				</tr>


			</table>
		</form>

	</div>

</center>

<jsp:include page="../footer.jsp" />
