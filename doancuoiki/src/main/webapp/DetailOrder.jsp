<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
  <link href="css/login.css" rel="stylesheet" type="text/css"/>
  <title>Login Form</title>
</head>
<body>
    <div class="container">
      <h2>THÔNG TIN ĐƠN HÀNG</h2>
      <c:set var="payment_method" value="${order.payment_method}" />
      <c:set var="payment_method" value="Thanh toán tại nhà" />
      <c:set var="order_status" value="${order.order_status}" />
      <c:set var="order_status" value="Đang xử lý" />
        <div class="d-block">
          <i class="fa-regular fa-file-code"></i>
          <strong style="font-size: 18px">Mã Đơn hàng:</strong>
          <p class="text"> #${order.order_code}</p>
        </div>
        <div class="d-block">
          <i class="fa-solid fa-location-dot"></i>
          <strong style="font-size: 18px">Địa chỉ nhận hàng:</strong>
          <p class="text">${order.shipping_address}</p>
        </div>
        <div class="d-block">
          <i class="fa-solid fa-truck-fast"></i>
          <strong style="font-size: 18px">Thông tin vận chuyển:</strong>
          <p class="text">${payment_method}</p>
        </div>
        <div class="d-block">
          <i class="fa-solid fa-signal"></i>
          <strong style="font-size: 18px">Tình trạng đơn hàng:</strong>
          <p class="text">${order_status}</</p>
        </div>








      <h4>Sản phẩm đơn hàng</h4>
      <table class="table">
        <thead>
        <tr>
          <th scope="col">STT</th>
          <th scope="col">Tên sản phẩm</th>
          <th scope="col">Đơn giá </th>
          <th scope="col">Số lượng </th>
          <th scope="col">Thành tiền</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="quantity" value="0" />
        <c:set var="price" value="0" />
    <c:forEach items="${order_item}" var="o">
      <c:set var="quantity" value="${o.quantity}" />
      <c:set var="price" value="${o.price}" />
    </c:forEach>
      <c:set var="counter" value="0" />
        <c:forEach items="${products}" var="product">
          <c:set var="counter" value="${counter + 1}" />

          <tr>
            <th scope="row">${counter}</th>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${quantity}</td>
            <td>${quantity*product.price}</td>

          </tr>
          <!-- Các thông tin khác của sản phẩm -->
        </c:forEach>


        </tbody>
      </table>
      <h4>Giá trị đơn hàng</h4>
      <ul class="d-flex " style="list-style: none;">
        <li>
          <span class="d-block mr-3">Tổng số lượng:</span>
          <span class="d-block mr-3">Tổng đơn hàng:</span>
        </li>
        <li>
          <span class="d-block">${order.total_product_quantity}</span>
          <span class="d-block">${order.total_amount}VND</span>
        </li>
      </ul>

    </div>

</body>
</html>
