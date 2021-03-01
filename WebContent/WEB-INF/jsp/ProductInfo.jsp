<!--新規登録画面JSP-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="plk.c.sasikarn.Product"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/sign-up_design.css">

<meta charset="UTF-8">
<title>新規登録</title>
</head>

<body>

<form action = "./ProductInfoControllerServlet" method="Get">
		<table>
			<tr>
				<td><label for="productId">商品ID</label><br> <input
					type="text" id="productId" name="productId"></td>

				<td><label for="productGenreCode">ジャンル</label><br> <select
					id="productGenreCode" name="productGenreCode">
						<option value="時計">時計</option>
						<option value="電子機器">電子機器</option>
						<option value="携帯">携帯</option>
				</select></td>
			</tr>

			<tr>
				<td><label for="productName">商品名</label><br> <input
					type="text" id="productName" name="productName"></td>
				<td><label for="productMaker">メーカー名</label><br> <select
					id="productMaker" name="productMaker">
						<option value="パナソニック">パナソニック</option>
						<option value="ソニー">ソニー</option>
						<option value="シャープ">シャープ</option>
				</select>
			</tr>

			<tr>
				<td><label for="productPrice">金額</label><br> <input
					type="text" id="productPrice" name="productPrice"></td>
				<td><label for="productStock">在庫数</label><br> <input
					type="text" id="productStock" name="productStock"></td>
			</tr>
			<tr>
				<td><label for="productSales">販売個数</label><br> <input
					type="text" id="productSales" name="productSales"></td>
			</tr>
		</table>

		<label for="productRemarks">備考</label> <br>
		<textarea id="productRemarks" name="productRemarks">
		</textarea>

		<br> <input type="image" class="button_register"
			src="img/button_register.png" alt="button_register">

		<!-- <br><input type="submit" value="送信"/><br/> -->
	</form>
</body>

</html>