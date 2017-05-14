
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/books.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/user.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/setting.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/character.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/count.js"></script>

<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/validate.css"
	rel="stylesheet" type="text/css" />

<title>Online Library Management System</title>
</head>

<body>
	<div id='wrapper'>
		<div class="banner">

			<div>
				<span class="session"> Welcome:${username} </span> <span
					class="logout">

					<div class="dropdown">

						<button class="dropbtn">MY PROFILE</button>
						<div class="dropdown-content">

							<a href="${pageContext.request.contextPath}/SBooklist?userid=${id}"> Dashboard</a> <a
								href="${pageContext.request.contextPath }/index.jsp"> Logout</a>

						</div>
					</div>

				</span>


			</div>

			<h1>Online Library Management System</h1>



			<div class="menu-wraps">
				<nav class="menu">
					<ul class="clearfix">
						<li><a
							href="${pageContext.request.contextPath}/SBooklist?userid=${id}">
								<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
								&nbsp; Home
						</a></li>


						<li><a
							href="${pageContext.request.contextPath}/sbookCategory">Book
								Category</a></li>
						<li><a href="${pageContext.request.contextPath}/sbook">Book</a></li>


						<li><a
							href="${pageContext.request.contextPath}/student/searchBookStudent.jsp"><span
								class="glyphicon fa fa-blind" aria-hidden="true"></span>&nbsp;
								Search Book </a></li>




						<li id="position"><a href="${pageContext.request.contextPath}/index.jsp"><span
								class="glyphicon fa fa-address-book" aria-hidden="true"></span>&nbsp;
								Logout</a></li>

					</ul>
				</nav>
			</div>

		</div>