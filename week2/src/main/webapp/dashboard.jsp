<%@ page import="com.example.week2.controller.ProductPriceMapping" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<br/>
<h2>List product</h2>
<table>
    <tr>
        <th>Product name</th>
        <th>Description</th>
        <th>Manufacturer</th>
        <th>Unit</th>
        <th>Price</th>
        <th>Quantity</th>
        <th><a href="/week2?action=myCart">Go to my cart</a></th>
    </tr>

    <% List<ProductPriceMapping> productPriceMappings = (List<ProductPriceMapping>) request.getAttribute("products");

    if(productPriceMappings != null){
        for(ProductPriceMapping mapping: productPriceMappings) {
    %>
    <tr>
        <td><%= mapping.getName() %></td>
        <td><%= mapping.getDescription() %></td>
        <td><%= mapping.getPrice() %></td>
        <td><%= mapping.getManufacturer()%></td>
        <td><%= mapping.getUnit() %></td>
        <td>
            <form method="post" action="week2?action=addToCart">
               <input type="text" name="quantity" value="1">
                <input type="hidden" name="productId" value="<%=mapping.getProduct_id()%>">
                <input type="hidden" name="price" value="<%=mapping.getPrice()%>">
                <button>Add to cart</button>
            </form>
        </td>
    </tr>

    <%}}%>
</table>
<br>
<br>
</body>
</html>