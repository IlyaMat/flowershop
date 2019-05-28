<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored = "false" %>

<html>
<head>
<style>
.succes-message {
  display: none;
  position: absolute;
  height:120px;
  background:pink;
  width: 220px;
  z-index: 2;
  left: 40%;
  right: 0;
  top:30%;
  font-size:20px;
  box-shadow: 0px 0px 20px -1px rgb(99, 99, 99);
  text-align:center;
  padding:20px;
}
</style>
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

       <!-- for admin -->

  <c:forEach var="order" items="${orders}">
       <div style="border:2px dashed pink" class="col-md-12 col-sm-4 grid-item">
         <h3 class="product-title">ФИО: ${order.customer.fullname}</h3>
         <h5 class="product-phoneNumber">Номер телефона: ${order.customer.phoneNumber}</h5>
         <h5 class="product-address">Адресс: ${order.customer.address}</h5>
         <h5 class="product-price">Стоимость: ${order.totalPrice}</h5>
         <h5 class="product-status">Статус заказа: ${order.status}</h5>
         <h5 class="product-date">Дата создания заказа: ${order.createdAt}</h5>
         <c:choose>
         <c:when test="${order.closedAt != null}">
          <h5 class="product-date">Дата закрытия заказа: ${order.closedAt}</h5>
         </c:when>
         <c:otherwise>
          <h5> Дата закрытия заказа: Заказ еще не закрыт... </h5>
         </c:otherwise>
          </c:choose>
        <div class="btn-group">
     <!-- <a href="/orders/order?id=${order.id}" type="button" class="btn btn-primary">Посмотреть заказ</a>-->

          <a href="/orders/order?id=${order.id}" type="button" style="background-color:#FF00FF" class="btn btn-primary btn-md" data-toggle="modal" data-target="#myModal">Посмотреть заказ</a>
          <!-- Modal -->
          <div class="modal fade" id="myModal" role="dialog">
            <div  class="modal-dialog">
              <!-- Modal content-->
              <div  class="modal-content">
              </div>
            </div>
        </div>
        </div>

        <c:choose>
          <c:when test="${order.status == 'ОПЛАЧЕН'}"> <!-- изменяется статус заказа -->

            <!-- куда отправляем -->
          <form method="post" action="rest/orders/close/${order.id}">
          <button type="submit" style="background-color:#FF00FF" class="btn btn-primary">Закрыть заказ</a>
          </form>
          </c:when>

           <c:when test="${order.status == 'СОЗДАН'}">
           <h4 style="background-color:yellow; width:130px"> Заказ ожидает оплаты... </h4>
           </c:when>
           <c:otherwise>
            <h4 style="background-color:#3CB371;height:20px;width:130px" > Заказ закрыт </h4>
           </c:otherwise>
        </c:choose>
        </div>
        </c:forEach>
        <!-- the end for admin -->


 </body>
 </html>