<%@ page import="service.ProductService" %>
<%@ page import="bean.Product" %>
<%@ page import="java.util.ArrayList" %>

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
    <br>
    <div class="container-fluid">
        <br>
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-12">
                        <h2><strong>Report General</strong></h2>
                    </div>
                    <div class="col-sm-6 text-left">
                        <a href="../view/product.list.jsp" class="btn btn-sm btn-default myBtnHoverSuccess"><span
                                class="glyphicon glyphicon-home"></span>&nbsp;list</a>
                        <a href="../view/product.create.jsp" class="btn btn-sm btn-default myBtnHoverInfo"><span
                                class="glyphicon glyphicon-plus"></span>&nbsp;add</a>
                    </div>
                    <div class="col-sm-6 text-right">
                        <a href="../view/reports/export.products.jsp" class="btn btn-sm btn-default myBtnHoverSuccess">
                            <span class="glyphicon glyphicon-modal-window"></span>&nbsp;exportar</a>
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <div class="table">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>NAME</th>
                            <th>IMAGE</th>
                            <th>QUANTITY</th>
                            <th>PRICE</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            int i = 1;
                            for (Product product : lista) {
                        %>
                        <tr>
                            <td><%=i%>
                            </td>
                            <td><%=product.getName()%>
                            </td>
                            <td><%=product.getImage()%>
                            </td>
                            <td><%=product.getQuantity()%>
                            </td>
                            <td><%=product.getPrice()%>
                            </td>
                        </tr>
                        <%
                                i++;
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

