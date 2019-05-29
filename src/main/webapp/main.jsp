<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored = "false" %>

<html>
<head>
  <title>flowershop</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

 <jsp:include page="header.jsp"/>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script src="scripts/products.js"></script>
<script src="cart.js"></script>

<link rel="stylesheet" href="css/styleProduct.css"/>

<style>
 .searchbar{
    margin-bottom: auto;
    margin-top: auto;
    height: 60px;
    background-color: #353b48;
    border-radius: 30px;
    padding: 10px;
    }

    .search_input{
    color: white;
    border: 0;
    outline: 0;
    background: none;
    width: 0;
    caret-color:transparent;
    line-height: 40px;
    transition: width 0.4s linear;
    }

    .searchbar:hover > .search_input{
    padding: 0 10px;
    width: 450px;
    caret-color:red;
    transition: width 0.4s linear;
    }

    .searchbar:hover > .search_icon{
    background: white;
    color: #e74c3c;
    }

    .search_icon{
    height: 40px;
    width: 40px;
    float: right;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 50%;
    color:white;
    }


</style>
</head>
<body style="background-image: url(https://skachatkartinki.net/photo/2304-95-1/835_382541135.jpg)">


<!-- Поиск по диапазону цен -->
<center>
<div class="container-fluid">
  <div data-role="main" class="ui-content">
    <form method="get" action="products">
     От <input type="number" name="minPrice" min="0" max="10000" step="10"/>
     До <input type="number" name="maxPrice" min="0" max="10000" step="10"/>
      <button type="submit" class="btn btn-primary">
        Поиск
      </button>
      </form>
</div>
</div>
</center>
<!-- -->

<div class="container-fluid">
<div class="container h-100">
      <div class="d-flex justify-content-center h-100">
      <form action="products" method="get" accept-charset="utf-8">
        <div class="searchbar">
          <input class="search_input" type="text" name="name" placeholder="Search...">
          <button type="submit" class="search_icon">
            Поиск
          </button>
        </div>
        </form>
      </div>
    </div>

    <div class="row product-grid">

      <c:forEach var="product" items="${products}">
      <div style="border:2px solid black" class="col-md-4 col-sm-4 grid-item">
        <img src="https://best-coll.ru/pictures/product/middle/7028_middle.jpg" alt="" />
        <h1 class="product-title">${product.name}</h1>
        <h3 class="product-price">${product.price}р</h3>
        <h3 class="product-quantity">Осталось:${product.stock.quantity} шт.</h3>


        <c:if test="${sessionScope.user != null}">

        <div class="quantity-input">
          <input class="minus btn" type="button" value="-">
          <input name="quantity" value="1"  class="input-text qty text" size="4"/>
          <input class="plus btn" type="button" value="+">
         </div>

         <button  data-id="${product.id}"  type="submit" class="btn btn-success add-to-cart-button"  role="addCartItem" ><span class="glyphicon glyphicon-ok"></span>
         К себе
         </button>


       </c:if>

      </div>

     </c:forEach>
      <div class="succes-message">Цветок успешно добавлен в корзину:)</div>
    </div>
</div>
</body>
</html>

