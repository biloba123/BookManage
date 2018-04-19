<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*,beans.Book"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.10/js/all.js"
	integrity="sha384-slN8GvtUJGnv6ca26v8EzVaR9DC58QEwsIk9q1QXdCU8Yu8ck/tL/5szYlBbqmS+"
	crossorigin="anonymous"></script>

<link href="jumbotron-narrow.css" rel="stylesheet">

<script type="text/javascript">
	$(document).ready(function() {
		
		$("#delete-books").click(function() {

			var dels = document.getElementsByName("del");
			var val = "";
			for (i = 0; i < dels.length; i++) {
				if (dels[i].checked) {
					if (val == "") {
						val += dels[i].value;
					} else {
						val += "," + dels[i].value;
					}
				}
			}

			if (val == "") {
				alert("请选择要删除的书籍");
			} else {
				var isConfirm = confirm("确认删除？书籍编号：" + val);
				if (isConfirm) {
					window.location.href="delete-books?books="+val;
				}
			}

		});
	});
</script>

<title>Book list</title>
</head>
<body>
	<%
		if (session.getAttribute("user") == null) {
			response.sendRedirect("index.jsp");
		}
	%>

	<div class="container">
		<div class="header clearfix">
			<nav>
			<ul class="nav nav-pills pull-right">
				<li role="presentation"><a href="logout">注销</a></li>
			</ul>
			</nav>
			<h3 class="text-muted">图书管理系统</h3>
		</div>

		<nav class="navbar navbar-default" style="margin-top:15px;">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">操作</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<form class="navbar-form navbar-left" action="search-book">
				<select name="search-type" style="height: 25px;">
						<option value="name">书名</option>
						<option value="author">作者</option>
						<option value="isbn">ISBN</option>
						<option value="price">价格</option>
						<option value="publishTime">出版日期</option>
					</select>
					<div class="form-group">
						<input name="text" type="text" class="form-control" placeholder="Search">
					</div>
					<button id="btn-search" type="submit" class="btn btn-info">
						<i class="fa fa-search"></i>
					</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="book-add.jsp"><i class="fa fa-plus-circle"></i>
							添加图书</a></li>
					<li><a id="delete-books"><i class="fa fa-trash"></i> 删除图书</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
		<div class="panel panel-default">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>书名</th>
							<th>作者</th>
							<th>ISBN</th>
							<th>出版日期</th>
							<th>价格</th>
							<th>库存量</th>
							<th>选择</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Book> books = (List<Book>) session.getAttribute("books");
							if (books != null) {
								for (Book book : books) {
									out.print("<tr><td>" + book.getId() + "</td><td><a href='book-add.jsp?id=" + book.getId() + "'>"
											+ book.getName() + "</a></td><td>" + book.getAuthor() + "</td><td>" + book.getIsbn()
											+ "</td><td>" + book.getPublishTime() + "</td><td>" + book.getPrice() + "</td><td>"
											+ book.getStock() + "</td><td><input type=\"checkbox\" name=\"del\" value=\"" + book.getId()
											+ "\"/>" + "</td><tr>");
								}
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>