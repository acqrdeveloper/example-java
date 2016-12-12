<%@ page import="service.ProductService" %>
<%@ page import="bean.Product" %>

<%
    ProductService productService = new ProductService();
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = productService.show(id);
%>
<%--
  Created by IntelliJ IDEA.
  User: QuispeRoque
  Date: 10/12/16
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="layouts/header.jsp" %>
</head>
<body>
<div class="container">
    <div class="container-fluid" data-form="deleteForm">
        <br>
        <div class="col-sm-6 col-sm-offset-3">
            <div class="row">
                <div class="col-sm-12">
                    <div class="col-sm-12 text-center">
                        <h1><%=product.getName().toUpperCase()%>
                        </h1>
                    </div>
                </div>
            </div>
            <div class="col-sm-12">
                <br>
                <div class="text-center">
                    <img src="../public/images/002.jpg" alt="auto" width="250">
                </div>
                <br>
                <br>
                <p class="text-center text-muted"><%=product.getDescription().toLowerCase()%>
                </p>
                <br>
                <br>
            </div>
            <div class="panel-body row ">
                <div class="col-sm-6 text-left">
                    <a href="../view/product.list.jsp" class="btn btn-sm btn-default myBtnHoverSuccess"><span
                            class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;list</a>
                    <a href="../view/product.create.jsp" class="btn btn-sm btn-default myBtnHoverInfo"><span
                            class="glyphicon glyphicon-plus"></span>&nbsp;add</a>
                </div>
                <div class="col-sm-6 text-right">
                    <a href="../view/product.edit.jsp?id=<%=product.getId()%>" class="btn btn-sm btn-default "><span
                            class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;edit</a>
                    <a href="../view/product.logic.delete.jsp?id=<%=product.getId()%>" class="btn btn-sm btn-default myBtnHoverDanger form-delete" data-method="delete"
                       data-confirm="Está seguro de eliminar el registro?"><span
                            class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;delete</a>
                </div>
                <%@include file="layouts/firma.html" %>
            </div>
        </div>
    </div>
</div>
<script src="../public/appdev/product/product.js"></script>
</body>
</html>
