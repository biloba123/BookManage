<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*,beans.Book"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Bootstrap -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>add book</title>
</head>
<body>
	<div class="container">

		<%
			String idStr = request.getParameter("id");
			Book book = null;
			if (idStr != null && !idStr.isEmpty()) {
				int id = Integer.valueOf(idStr);
				session.setAttribute("edit-id", id);
				List<Book> books = (List<Book>) session.getAttribute("books");
				if (books != null) {
					for (Book b : books) {
						if (b.getId() == id) {
							book = b;
							break;
						}
					}
				}
			}
		%>

		<form method="post" action="<%=book == null ? "add-book" : "edit-book"%>"
			style="max-width: 360px; padding: 15px;">
			<h2 class="form-signin-heading"><%=book == null ? "添加图书" : "修改图书"%></h2>
			<div class="input-group" style="margin-top: 5px;">
				<span class="input-group-addon" id="basic-addon1">书名</span> <input
					name="name" type="text" class="form-control"
					aria-describedby="basic-addon1"
					value="<%=book == null ? "" : book.getName()%>" required>
			</div>
			<div class="input-group" style="margin-top: 5px;">
				<span class="input-group-addon" id="basic-addon2">作者</span> <input
					name="author" type="text" class="form-control"
					aria-describedby="basic-addon2"
					value="<%=book == null ? "" : book.getAuthor()%>" required>
			</div>
			<div class="input-group" style="margin-top: 5px;">
				<span class="input-group-addon" id="basic-addon3">ISBN</span> <input
					name="isbn" type="text" class="form-control"
					aria-describedby="basic-addon3"
					value="<%=book == null ? "" : book.getIsbn()%>" required>
			</div>
			<div class="input-group" style="margin-top: 5px;">
				<span class="input-group-addon" id="basic-addon5">价格</span> <input
					name="price" type="text" class="form-control"
					aria-describedby="basic-addon5"
					value="<%=book == null ? "" : book.getPrice()%>">
			</div>
			<div class="input-group" style="margin-top: 5px;">
				<span class="input-group-addon" id="basic-addon6">折扣</span> <input
					name="discount" type="text" class="form-control"
					aria-describedby="basic-addon6"
					value="<%=book == null ? "" : book.getDiscount()%>">
			</div>
			<div class="input-group" style="margin-top: 5px;">
				<span class="input-group-addon" id="basic-addon7">库存量</span> <input
					name="stock" type="text" class="form-control"
					aria-describedby="basic-addon7"
					value="<%=book == null ? "" : book.getStock()%>">
			</div>
			<div class="input-group" style="margin-top: 5px;">
				<span class="input-group-addon" id="basic-addon4">出版日期</span> <input
					name="publishTime" type="text" class="form-control"
					aria-describedby="basic-addon4"
					value="<%=book == null || book.getPublishTime()==null? "" : book.getPublishTime()%>">
			</div>

			<button class="btn btn-primary btn-block" type="submit"
				style="margin-top: 10px;"><%=book == null ? "添加" : "修改"%></button>

		</form>
	</div>
	<!-- /container -->

</body>
</html>