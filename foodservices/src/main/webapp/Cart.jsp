<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.food.model.*,com.food.DAO.*,com.food.DAOimplents.*, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Your shoping cart</h1>

<% 

	Cart cart  =  (Cart)session.getAttribute("cart");
	if(cart!=null && !cart.getItems().isEmpty())
	{
		for(CartItem item : cart.getItems().values())
		{

%>



<p><%= item.getName() %></p>
<p><%= item.getPrice() %></p>



<form action="Cart">

<input name = "menuId" value = "<%= item.getItem_id()%>">
<label>Quantity: <input type="number" name = "quantity" value="<%= item.getQuantity() %>">
</label>
<input type ="submit" name ="action" value = "update" class ="update-btn">
<input type ="submit" name ="action" value = "remove" class ="update-btn">

</form>


<%
		}
	}
	else
	{
	
%>

<p>cart is empty</p>

<% } %>



<a href="menu?restaurantId =<%= session.getAttribute("restaurantId") %>">Add more items</a>


<% 
	if(session.getAttribute("cart") != null)
%>
<form action="checkout.jsp">

<input type="submit" value="proceed to checkout">

</form>


</body>
</html>