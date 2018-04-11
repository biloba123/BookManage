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

<link href="jumbotron-narrow.css" rel="stylesheet">

<title>Book list</title>
</head>
<body>
	<div class="container">
		<div class="header clearfix">
			<nav>
			<ul class="nav nav-pills pull-right">
				<li role="presentation"><a href="#">注销</a></li>
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
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">添加图书</a></li>
					<li><a href="#">删除图书</a></li>
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
							<th>价格</th>
							<th>库存量</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Book> books = (List<Book>) session.getAttribute("books");
							if (books != null) {
								for (Book book : books) {
									out.print("<tr><td>" + book.getId() + "</td><td>" + book.getName() + "</td><td>" + book.getAuthor()
											+ "</td><td>" + book.getIsbn() + "</td><td>" + book.getPrice() + "</td><td>"
											+ book.getStock() + "</td><tr>");
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