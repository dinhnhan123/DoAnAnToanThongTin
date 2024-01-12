<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Hash" %>
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
        <div class="container">
            <h2 class="text-center my-4">DANH SÁCH ĐƠN HÀNG</h2>
            <div class="w-100 bg-primary py-2">
                <a href="managerOrder?status=allOrder" class="text-white d-inline-block px-2 py-1" style="background-color: #343a40">Tất cả</a>
                <a href="managerOrder?status=authenticated" class="text-white d-inline-block px-2 py-1 rounded bg-success">Đã Xác Thực</a>
                <a href="managerOrder?status=notYetAuthenticated" class="text-white d-inline-block px-2 py-1 rounded bg-danger">Chưa Xác Thực</a>
            </div>
            <table class="table table-dark table-striped">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">Mã đơn hàng</th>
                    <th scope="col">Họ và tên</th>
                    <th scope="col">Số sản phẩm</th>
                    <th scope="col">Tổng giá </th>
                    <th scope="col">Trạng thái </th>
                    <th scope="col">Chi tiết </th>
                    <th scope="col">Xác thực đơn hàng </th>
                    <th scope="col">Tình trạng đơn hàng </th>

                </tr>
                </thead>
                <tbody>
                <c:set var="counter" value="0" />
            <c:forEach items="${list}" var="o">
                <c:set var="counter" value="${counter + 1}" />
                <tr>
                    <th scope="row">${counter}</th>
                    <td>#${o.order_code}</td>
                    <td>${o.fullname}</td>
                    <td>${o.total_product_quantity}</td>
                    <td>${o.total_amount}</td>
                    <td>${o.order_status}</td>
                    <td><a href="detailOrder?cid=${o.order_id}">Chi tiết</a></td>
                    <c:if test="${o.authenticated != 0}">
                        <td><a  style="display: inline-block; text-align: center " class="bg-success text-white py-1 px-1 rounded">Đã xác thực</a></td>
                    </c:if>
                    <c:if test="${o.authenticated == 0}">
                        <td><a  style="display: inline-block; text-align: center " class="bg-danger text-white py-1 text-white px-1 rounded">Chưa xác thực</a></td>
                    </c:if>
                    <c:set var="hashObject" value="${requestScope.hashObject}" />
                    <c:set var="hashedValue" value="${hashObject.calculateHash(o)}"/>
                    <c:if test="${hashedValue == o.hashedValueOld}">
                        <td><a  style="display: inline-block; text-align: center " class="bg-success text-white py-1 px-1 rounded">Chưa bị chỉnh sửa</a></td>
                    </c:if>
                    <c:if test="${hashedValue != o.hashedValueOld}">
                        <td><a  style="display: inline-block; text-align: center " class="bg-danger text-white py-1 px-1 rounded">Đã bị chỉnh sửa</a></td>
                    </c:if>
<%--                    <c:if test="${o.hashedValueOld == 0}">--%>
<%--                        <td><a  style="display: inline-block; text-align: center " class="bg-danger text-white py-1 text-white px-1 rounded">Chưa xác thực</a></td>--%>
<%--                    </c:if>--%>
                </tr>
              </c:forEach>
                </tbody>
            </table>
            <a href="http://localhost:8080/doancuoiki/homeControl" style="text-decoration: underline">Trang chủ</a>
        </div>
</body>
</html>

