<%@ page import="service.ProductService" %>
<%@ page import="bean.Product" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: QuispeRoque
  Date: 08/12/16
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../layouts/header.jsp" %>
</head>
<body>
<%
    ProductService productService = new ProductService();
    ArrayList<Product> lista;
    lista = productService.list();

    if (!lista.isEmpty()) {
//        response.setContentType("application/vnd.ms-excel");
        response.setContentType("application/ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + "ReporteGeneral.xls");
    }
%>

<table class="table table-hover table-striped">
    <thead>
    <tr>
        <th style="background-color: #fffb93;text-align: center">ID</th>
        <th style="background-color: #fffb93;text-align: center">NAME</th>
        <th style="background-color: #fffb93;text-align: center">IMAGE</th>
        <th style="background-color: #fffb93;text-align: center">QUANTITY</th>
        <th style="background-color: #fffb93;text-align: center">PRICE</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Product product : lista) {
    %>
    <tr>
        <td><%=product.getId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getImage()%></td>
        <td><%=product.getQuantity()%></td>
        <td><%=product.getPrice()%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
