<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored = "false" %>

<html>
<head>
  <title>Заказы</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 <jsp:include page="header.jsp"/>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
 </head>
<body style="background-image: url(https://skachatkartinki.net/photo/2304-95-1/835_382541135.jpg)">

    <c:forEach var="order" items="${orders}">
       <div style="border:2px dashed pink" class="col-md-12 col-sm-4 grid-item">
         <h5 class="product-price">Стоимость: ${order.totalPrice}</h5>
         <h5 class="product-status">Статус заказа: ${order.status}</h5>
         <h5 class="product-date">Дата создания заказа: ${order.createdAt}</h5>
         <c:choose>
         <c:when test="${order.closedAt != null}">
         <h5 class="product-date">Дата закрытия заказа: ${order.closedAt}</h5>
         </c:when>
         <c:otherwise>
         <h5> Дата закрытия заказа: Ваш заказ еще не закрыт... </h5>
         </c:otherwise>
         </c:choose>

        <c:choose>
         <c:when test="${order.status == 'СОЗДАН'}">
         <!-- отправляем на сервлет и изменяется статус заказа -->
         <form method="post" action="myorders">
          <input type="hidden" name="orderId" value="${order.id}" />
            <button type="submit" style="background-color:#FF00FF" class="btn btn-primary">Оплатить заказ</button>
           </form>
         </c:when>
         <c:when test="${order.status == 'ОПЛАЧЕН'}">
          <h4 style="background-color:#00BFFF;width:145px" > Заказ ждет ответа от администратора </h4>
         </c:when>
         <c:when test="${order.status == 'ЗАКРЫТ'}">
            <h4 style="background-color:#3CB371;height:20px;width:130px" > Заказ закрыт </h4>
         </c:when>
         </c:choose>
       </div>
    </c:forEach>

 </body>
 </html>