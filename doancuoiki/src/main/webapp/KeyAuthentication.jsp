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
    <form class="form-order" action="accountElectronicSignature" method="post">
      <h2>XÁC THỰC TÀI KHOẢN</h2>
      <p>PrivateKey của bạn là :</p>
      <div class="form-group">
        <label for="">PrivateKey:</label>
        <textarea class="form-control" id="" name="" rows="4">${privateKeyBase64}</textarea>
      </div>
      <input type="hidden" name="cid" value="${cid}">
      <P class="text-danger">Vui lòng nhập PrivateKey này vào bên dưới ô PrivateKey và đồng thời điền thông tin của bạn vào các ô để xác thực và vui lòng giữ Private này để xác thực mua hàng :</P>
      <div class="form-group">
        <label for="fullname">Họ và tên:</label>
        <input type="text" name="fullname" id="fullname" class="form-control">
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" class="form-control">
      </div>
      <div class="form-group">
        <label for="num_phone">SĐT:</label>
        <input type="tel" name="num_phone" id="num_phone" class="form-control">
      </div>
      <div class="form-group">
        <label for="PrivateKey">PrivateKey:</label>
        <textarea class="form-control" id="PrivateKey" name="PrivateKey" rows="4"></textarea>
      </div>
      <input type="submit" class="btn btn-primary" value="Xác Thực">
    </form>
</div>
</div>



</body>
</html>

