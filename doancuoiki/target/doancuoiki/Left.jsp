
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <link rel="stylesheet" href="style.css">
</head>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> DANH MUC</div>
        <ul class="list-group category_block" >
            <c:forEach items="${listC}" var="o">
                <li class="list-group-item text-white ${tag == o.cid ? "active" : "" }" ><a href="category?cid=${o.cid}">${o.name}</a></li>
            </c:forEach>

        </ul>
    </div>
    <div class="card bg-light mb-3" >
        <div class="card-header bg-success text-white text-uppercase">Bánh mới 🎅 </div>
        <div class="card-body">
            <img class="img-fluid" src="${p.image}" />
            <h5 class="card-title">${p.name}</h5>
            <p class="card-text">${p.title}</p>
            <p style="background-color: #28A745;color: white;font-weight: bold;font-size: 150%;text-align: center">${p.price} VND</p>
        </div>
    </div>
</div>
