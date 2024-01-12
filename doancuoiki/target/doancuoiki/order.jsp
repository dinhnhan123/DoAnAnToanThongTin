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
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
    <title>Login Form</title>
</head>
<body>
    <div class="container w-100 d-flex pt-3">
    <div class="client-information w-50 mr-3">
        <form class="form-order" action="order" method="post">
        <h2>THÔNG TIN KHÁCH HÀNG</h2>
            <p class="text-danger">Vui lòng nhập đúng Họ và tên , Email, SĐT,PrivateKey để xác thực đơn hàng</p>
            <div class="form-group">
                <label for="fullname">Họ và tên:</label>
                <input type="text" name="fullname" id="fullname" class="form-control">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" name="email" id="email" class="form-control">
            </div>
            <div class="form-group">
                <label for="address">Địa chỉ:</label>
                <input type="text" name="address" id="address" class="form-control">
            </div>
            <div class="form-group">
                <label for="num_phone">SĐT:</label>
                <input type="tel" name="num_phone" id="num_phone" class="form-control">
            </div>
            <div class="form-group">
                <label for="privateKey">Nhập privateKey:</label>
                <textarea class="form-control" id="privateKey" name="privateKey" rows="4"></textarea>
            </div>
            <a href="homeControl">Quay lại trang chủ!</a>
    </div>
        <div class="order-information w-50 ml-3">
            <h2>THÔNG TIN HÓA ĐƠN</h2>
            <table class="table">
                <thead>
                <tr>
                    <td>Sản phẩm</td>
                    <td>Tổng</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${order.items}" var="item">
                <tr class="cart-item">
                    <td class="product-name">${item.product.name}<strong class="product-quantity">x ${item.quantity}</strong></td>
                    <td class="product-total">${order.numberFormat(item.product.price)} <span> VND</span></td>
                </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr class="order-total">
                    <td>Tổng đơn hàng:</td>
                    <td><strong class="total-price">${order.numberFormat(order.gettotal()) }VNĐ</strong></td>
                    <input type="hidden" value="2" name="total_product_quantity">
                    <td><input type="hidden" value="35000000" name="total_amount"></td>
                </tr>
                </tfoot>
            </table>
            <div class="payment mt-3">
                <input type="radio" id="payment-home" name="payment_method" value="payment-home" checked="checked">
                <label for="payment-home">Thanh toán khi nhận hàng</label>
            </div>
            <input type="submit" value="Đặt hàng" class="btn btn-primary float-right mr-5" id="sm_order">
            </form>

        </div>
    </div>

</body>
</html>
