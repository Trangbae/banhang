

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${o.cid}" var="o">
                <li class="list-group-item text-white"><a href="#">Váy dự tiệc</a></li>
            </c:forEach>

        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Last product</div>
        <div class="card-body">
            <img class="img-fluid" src="thoitrang/vay-tieu-thu.jpg" />
            <h5 class="card-title">Váy đi chơi tết</h5>
            <p class="card-text"></p>
            <p class="bloc_left_price">100 $</p>
        </div>
    </div>
</div>