<%@ page import="service.ProductService" %>

<%
    ProductService productService = new ProductService();
    int id = Integer.parseInt(request.getParameter("id"));
    int result = productService.delete(id);

    if (result > 0) {
        response.sendRedirect("../view/product.list.jsp");
    }
%>