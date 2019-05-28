<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored = "false" %>

<body style="background-image: url(https://skachatkartinki.net/photo/2304-95-1/835_382541135.jpg)">
 <jsp:include page="header.jsp"/>

<div class="container wrapper">
            <div class="row cart-head">
                <div class="container">
                <div class="row">
                    <p></p>
                </div>
                <div class="row">
                    <p></p>
                </div>
                </div>
            </div>
            <div class="row cart-body">
                <form class="form-horizontal" method="post" action="">
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-push-6 col-sm-push-6">
                    <!--REVIEW ORDER-->
                    <div style="border:2px solid pink" class="panel panel-info">
                        <div style="background-color:#252727" class="panel-heading">
                            Заказ <div class="pull-right"><small></small></div>
                        </div>
                        <div class="panel-body">

                         <c:forEach var="item" items="${sessionScope.user.customer.cart.basketGoods}">
                              <div class="form-group">
                                <div class="col-sm-3 col-xs-3">
                                    <img class="img-responsive" src="https://best-coll.ru/pictures/product/middle/7028_middle.jpg" />
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                    <div class="col-xs-12">${item.value.product.name}</div>
                                </div>
                                <div class="col-sm-3 col-xs-3 text-right">
                                    <h6><span></span>${item.value.product.price}</h6>
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                  <div class="col-xs-12">Количество:</div>
                                </div>
                                <div class="col-sm-3 col-xs-3 text-right">
                                 <h6><span></span>${item.value.quantityFlower}</h6>
                                </div>
                            </div>
                            <div class="form-group"><hr /></div>
                            </c:forEach>

                             <div class="form-group">
                                 <div class="col-xs-12">
                                     <strong>Общее количество товаров::</strong>
                                     <div class="pull-right"><span></span><span>${sessionScope.user.customer.cart.totalQuantityProducts}</span></div>
                                 </div>
                             </div>

                            <div class="form-group"><hr /></div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <strong>Цена без скидки:</strong>
                                    <div class="pull-right"><span></span><span>${sessionScope.user.customer.cart.totalPrice}</span></div>
                                </div>
                            </div>
                            <div class="form-group"><hr /></div>
                            <div class="form-group">
                                <div class="col-xs-12">
                                    <strong>Цена с учетом скидки</strong>
                                    <div class="pull-right"><span></span><span>${sessionScope.user.customer.cart.totalPriceWithDiscount}</span></div>
                                </div>
                            </div>
                        </div>
                    </div>



                </div>
                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 col-md-pull-6 col-sm-pull-6">
                    <!--SHIPPING METHOD-->
                    <div style="border:2px solid pink" class="panel panel-info">
                        <div style="background-color:#252727" class="panel-heading">Адрес</div>
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-md-12">
                                    <h4>Форма для заказа</h4>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-12"><strong>ФИО:</strong></div>
                                <div class="col-md-12">
                                    <input type="text" class="form-control" name="fullname" value="${sessionScope.user.customer.fullname}" />
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-12 col-xs-12">
                                    <strong>Номер телефона:</strong>
                                    <input type="text" name="phoneNumber" class="form-control" value="${sessionScope.user.customer.phoneNumber}" />
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-12"><strong>Ваш адрес(полностью):</strong></div>
                                <div class="col-md-12">
                                    <input type="text" name="address" class="form-control" value="${sessionScope.user.customer.address}" />
                                </div>
                            </div>
                         </div>
                    </div>
                    <button type="submit" class="btn btn-primary">
                            Подтвердить заказ
                   </button>

                </div>
                </form>
            </div>
            <div class="row cart-footer">
            </div>
    </div>