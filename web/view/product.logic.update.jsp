<%@ page import="service.ProductService" %>

<jsp:useBean id="product" class="bean.Product"/>
<jsp:setProperty name="product" property="*"/>

<%
    ProductService productService = new ProductService();
    int result = productService.update(product);
    if (result > 0) {
        response.sendRedirect("../view/product.list.jsp");
    }
%>
