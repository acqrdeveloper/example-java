<%@ page import="bean.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="service.ProductService" %>

<%
    ProductService productService = new ProductService();
    ArrayList<Product> lista;
    lista = productService.list();
%>
<%--
  Created by IntelliJ IDEA.
  User: QuispeRoque
  Date: 08/12/16
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="layouts/header.jsp" %>
</head>
<body>
<div class="container">
    <div class="container-fluid">
        <br>
        <div class="row">
            <div class="col-sm-12 ">
                <h1 class="text-primary"><strong>List Products in JAVA
                    <small class="text-danger">1.8.0_111</small>
                </strong></h1>
            </div>
            <div class="col-sm-12">
                <div class="col-sm-6 ">
                    <div class="col-sm-6 text-left">
                        <br>
                        <a href="../view/product.create.jsp" class="btn btn-sm btn-default myBtnHoverInfo"><span
                                class="glyphicon glyphicon-plus"></span>&nbsp;add product</a>
                        <a href="../view/product.report.jsp" class="btn btn-sm btn-default myBtnHoverPrimary"><span
                                class="glyphicon glyphicon-modal-window"></span>&nbsp;report</a>
                    </div>
                </div>
                <div class="col-sm-6">
                    <%@include file="layouts/firma.html" %>
                </div>
            </div>
        </div>
        <div class="col-sm-12">
            <br>
            <%
                for (Product product : lista) {
            %>
            <div class="col-sm-4 ">
                <div class="thumbnail">
                    <div class="text-center">
                        <h4><%=product.getName()%>
                        </h4>
                    </div>
                    <img src="../public/images/002.jpg" alt="auto" width="200">
                    <br>
                    <div class="text-center">
                        <a href="../view/product.edit.jsp?id=<%=product.getId()%>" class="btn btn-sm btn-default "><span
                                class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;edit</a>

                        <%--<button id="btnSee" class="btn btn-sm btn-default btnShowClick" type="button" data-row="<%=product.getId()%>">Ver</button>--%>
                        <a href="../view/product.show.jsp?id=<%=product.getId()%>" class="btn btn-sm btn-default"><span
                                class="glyphicon glyphicon-oil"></span>&nbsp;&nbsp;see</a>
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
    <div id="divContentFullDos" class="container-fluid" data-form="deleteForm"></div>
</div>
<script src="../public/appdev/product/product.js"></script>
</body>
</html>
