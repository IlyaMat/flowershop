<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored = "false" %>

<head>
  <title>flowershop</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Flowershop</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Главная страница</a></li>
      <li><a href="/products">Цветы</a></li>
    </ul>

     <c:if test="${sessionScope.user == null}">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Регистрация</a></li>
      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Вход</a></li>
      </ul>
      </c:if>


      <c:if test="${sessionScope.user != null}">
            <span class="navbar-text"><b>Добро пожаловать:</b> ${sessionScope.user.username}&nbsp;</span>
            <span class="navbar-text"><b>Ваш баланс</b>: ${sessionScope.user.customer.balance}&nbsp;</span>
            <span class="navbar-text"><b>Ваша скидка:</b> ${sessionScope.user.customer.discount}<b>%</b>&nbsp;</span>
      </c:if>


      <c:if test="${sessionScope.user != null}">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="/myorders?id=${sessionScope.user.customer.id}"><span class="glyphicon glyphicon-log-in"></span> Мои заказы</a></li>
          <li><a href="/logout"><span class="glyphicon glyphicon-user"></span> Выход</a></li>
          <li><a href="/cart"><span class="glyphicon glyphicon-log-in"></span> Корзина</a></li>
          </ul>
       </c:if>

      <c:if test="${sessionScope.user.userRole != CUSTOMER}">
       <span class="navbar-text"><a href="#"><b>Заказы пользователей.</b></a>&nbsp;</span>
      </c:if>
  </div>
</nav>

</body>
</html>
