<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="plk.c.sasikarn.ProductMaker"%>
<%@ page import="plk.c.sasikarn.ProductGenre"%>
<%@ page import="plk.c.sasikarn.Product"%>
<%@ page import="plk.c.sasikarn.ProductDbUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/sign-up_design.css">
<title>更新画面</title>
</head>

<body>
<form action="./ProductInfoControllerServlet" method= "GET">
	<table>
		<tr>
			<td><label for="productId">商品ID</label><br> <input
				type="text" id="productId" name="productId"
				value="${THE_PRODUCT.productId}"></td>

			<td><label for="productGenreCode">ジャンル</label><br> <select
				id="productGenreCode" name="productGenreCode">
					<c:forEach var="genre" items="${ProductGenre.values()}">
						<option value="${genre.genreCode}"
							<c:if test="${THE_PRODUCT.productGenreCode == genre.genreCode}">選択</c:if>>
							${genre.genreName}</option>
					</c:forEach>
			</select></td>
		</tr>

		<tr>
			<td><label for="productName">商品名</label><br> <input
				type="text" id="productName" name="productName"
				value="${THE_PRODUCT.productName}"></td>

			<td><label for="productMaker">メーカー名</label><br> <select
				id="productMaker" name="productMaker">
					<c:forEach var="maker" items="${ProductMaker.values()}">
						<option
							<c:if test="${THE_PRODUCT.productMaker == maker.makerName}">選択</c:if>>
							${maker.makerName}</option>
					</c:forEach>
			</select></td>
		</tr>

		<tr>
			<td><label for="productPrice">金額</label><br> <input
				type="text" id="productPrice" name="productPrice"
				value="${THE_PRODUCT.productPrice}"></td>

			<td><label for="productStock">在庫数</label><br> <input
				type="text" id="productStock" name="productStock"
				value="${THE_PRODUCT.productStock}"></td>
		</tr>
		<tr>
			<td><label for="productSales">販売個数</label><br> <input
				type="text" id="productSales" name="productSales"
				value="${THE_PRODUCT.productSales}"></td>
		</tr>
	</table>

	<label for="productRemarks">備考</label>
	<br>
	<textarea id="productRemarks" name="productRemarks" >
	<c:out value="${THE_PRODUCT.productRemarks}"/>
		</textarea>

	<br>
	<input type="image" class="button_update" src="img/button_update.png"
		alt="button_update">

</form>
</body>

</html>