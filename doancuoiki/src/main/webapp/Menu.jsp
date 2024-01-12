<%@ page import="javax.print.attribute.standard.MediaSize" %>
<%@ page import="model.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Item" %>
<%@ page import="Dao.Dao" %>
<%@ page import="model.Product" %>
<%@ page import="DBConnect.DBcontext" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark" style="background-color: #E9B749">
    <div class="container" >
        <a class="navbar-brand" href="homeControl">Shop Cake Nhân ĐinhIT</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <c:if test="${sessionScope.acc.isAdmin == 1}">
                <li class="nav-item">
                    <a class="nav-link" href="managerOrder?status=allOrder"> Hóa Đơn</a>
                </li>
                </c:if>
                <c:if test="${sessionScope.acc.isAdmin == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="managerCustomer">Khách Hàng</a>
                    </li>
                </c:if> <c:if test="${sessionScope.acc.isAdmin == 1}">
                <li class="nav-item">
                    <a class="nav-link" href="managerAccount?status=allAccount">Người dùng</a>
                </li>
            </c:if>

                <c:if test="${sessionScope.acc.isSell == 1}">
                <li class="nav-item">
                    <a class="nav-link" href="manager">Quản lí sản phẩm</a>
                </li>
                </c:if>

                <c:if test="${sessionScope.acc != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Hello ${sessionScope.acc.user}</a>
                    </li>
                    <c:if test="${sessionScope.acc.isAdmin == 0}">
                        <li class="nav-item">
                            <a class="nav-link" href="privateKeyExposed">PrivateKey đã  bị lộ</a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Đăng xuất</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="Login.jsp">Đăng nhập</a>
                    </li>
                </c:if>
            </ul>

            <form action="search" method="get" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${txts}" name="txt" type="text" c------------lass="form-control" aria-label="Small"
                           aria-describedby="inputGroup-sizing-sm" placeholder="Tìm kiếm...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>

                <a class="btn btn-success btn-sm ml-3" href="cart" style="background-color: orangered;border: none">
                    <i class="fa fa-shopping-cart"></i> Giỏ Hàng
                    <span class="badge badge-light"> 1</span>
                </a>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center" >
    <div class="container">
        <h1 class="jumbotron-heading">Shop Cake Nhân ĐinhIT nhiều mẫu bánh rẻ</h1>
        <p class="lead text-muted mb-0" style="color:white ">Uy tín tạo nên thương hiệu với hơn 10 năm làm bánh của chef Nhân Đinh
            </p>
    </div>
</section>
<!--end of menu-->
