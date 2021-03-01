
<!--一覧画面-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<meta charset="utf-8">
<link rel="stylesheet" href="css/style.css">
<title>商品情報管理システム</title>
</head>

<body>
<form action="./ProductUpdateControllerServlet" method= "Get">
	<h1>在庫管理システム</h1>

	<input type="image" class="button_signup" src="img/button_signup.png"
		alt="button_signup">
	<input type="image" class="button_search" src="img/button_search.png"
		alt="button_search">
	<table class=tableDesign>
		<tr class="purple">

			<th>商品ID</th>
			<th>画像</th>
			<th>メーカー名</th>
			<th>商品名</th>
			<th>ジャンル</th>
			<th>在庫数</th>
			<th>販売個数</th>
			<th>価格</th>
			<th>更新</th>

		</tr>

		<c:forEach var="tempProduct" items="${PRODUCT_LIST}">

			<tr>
			<td>${tempProduct.productId}</td>
			<td><img src="img/watch.png" alt="watch"></td>
			<td>${tempProduct.productMaker}</td>
			<td>${tempProduct.productName}</td>
			<td>${tempProduct.productGenreCode}</td>
			<td>${tempProduct.productPrice}</td>
			<td>${tempProduct.productStock}</td>
			<td>${tempProduct.productSales}</td>
			<td><input type="submit" value="更新"/></td>
			</tr>
		</c:forEach>
		

	</table>
</form>
</body>


</html>
