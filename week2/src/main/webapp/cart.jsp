<%@ page import="com.example.week2.controller.ProductPriceMapping" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.week2.models.CartDetail" %>
<%@ page import="com.example.week2.models.ProductPrice" %>
<%@ page import="com.example.week2.repositories.ProductPriceRepository" %>
<%@ page import="java.util.Optional" %>
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
    <th>Quantity</th>
    <th>Price</th>
  </tr>

  <% List<CartDetail> details = (List<CartDetail>) request.getAttribute("details");
    if(details != null){
      for(CartDetail cartDetail : details){
  %>
  <tr>
    <td><%= cartDetail.getProduct().getName() %></td>
    <td><%= cartDetail.getProduct().getDescription() %></td>
    <td><%= cartDetail.getProduct().getManufacturer() %></td>
    <td><%= cartDetail.getProduct().getUnit() %></td>
    <td><%= cartDetail.getQuantity() %></td>

    <% ProductPriceRepository productPriceRepository = new ProductPriceRepository();
      Optional<ProductPrice> price = productPriceRepository.findByProduct(cartDetail
              .getProduct().getProduct_id());
      ProductPrice productPrice = new ProductPrice();

      if(price.isPresent()){
        productPrice = price
                .get();
      }
    %>
    <td><%= productPrice.getPrice() %></td>
  </tr>
  <%}}%>
</table>
<form method="post" action="/week2?action=insert">
  <button type="submit">Order</button>
</form>
<br>
<br>
</body>
</html>