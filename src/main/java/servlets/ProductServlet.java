package servlets;

import bean.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by QuispeRoque on 08/12/16.
 */
@WebServlet(name = "ProductServlet")
public class ProductServlet extends HttpServlet {

    ProductService productService = new ProductService();
    PrintWriter pw;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (null != accion) {
            switch (accion) {
                case "store":
                    store(req, resp);
                    break;
                case "list":
                    list(req, resp);
                    break;
                case "clean":
                    clean(req, resp);
                    break;
                case "show":
                    show(req, resp);
                    break;
            }
        }
    }

    private void show(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ProductService productService = new ProductService();
        int id = Integer.parseInt(req.getParameter("idproduct"));
        Product product = productService.show(id);
        String html;

        resp.setContentType("text/html");
        pw = resp.getWriter();

        html = "<br>" +
                "<div class=\"col-sm-6 col-sm-offset-3\">\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-sm-12\">\n" +
                "                    <div class=\"col-sm-12 text-center\">\n" +
                "                        <h1></h1>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"col-sm-12\">\n" +
                "                <br>\n" +
                "                <div class=\"text-center\">\n" +
                "                    <img src=\"../public/images/002.jpg\" alt=\"auto\" width=\"250\">\n" +
                "                </div>\n" +
                "                <br>\n" +
                "                <br>\n" +
                "                <p class=\"text-justify text-muted text-uppercase\">" + product.getName() + "</p>\n" +
                "                <br>\n" +
                "                <br>\n" +
                "            </div>\n" +
                "            <div class=\"panel-body row \">\n" +
                "                <div class=\"col-sm-6 text-left\">\n" +
                "                    <a href=\"\" class=\"btn btn-sm btn-default myBtnHoverSuccess\"><span class=\"glyphicon glyphicon-home\"></span>&nbsp;&nbsp;list</a>\n" +
                "                    <a href=\"\" class=\"btn btn-sm btn-default myBtnHoverInfo\"><span class=\"glyphicon glyphicon-plus\"></span>&nbsp;add</a>\n" +
                "                </div>\n" +
                "                <div class=\"col-sm-6 text-right\">\n" +
                "                    <a href=\"\" class=\"btn btn-sm btn-default\"><span class=\"glyphicon glyphicon-edit\"></span>&nbsp;&nbsp;edit</a>\n" +
                "                    <a href=\"\" class=\"btn btn-sm btn-default myBtnHoverDanger form-delete\" data-method=\"delete\" data-confirm=\"Está seguro de eliminar el registro?\"><span class=\"glyphicon glyphicon-remove\"></span>&nbsp;&nbsp;delete</a>\n" +
                "                </div>\n" +
                "                <%@include file=\"layouts/firma.html\" %>\n" +
                "            </div>\n" +
                "        </div>";
        pw.println(html);
    }

    private void clean(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int result = productService.clean();

        resp.setContentType("text/html");
        pw = resp.getWriter();

        pw.println(result);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ArrayList<Product> lista;
        lista = productService.list();

        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter pw = resp.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            pw.println("<table class=\"table table-bordered table-hover\">");
            pw.println("<thead>");
            pw.println("<tr>");
            pw.println("<th>#</th>");//cabecera
            pw.println("<th>NOMBRE</th>");//cabecera
            pw.println("<th>IMAGE</th>");//cabecera
            pw.println("<th>QUANTITY</th>");//cabecera
            pw.println("<th>PRICE</th>");//cabecera
            pw.println("</tr>");
            pw.println("<thead>");
            pw.println("<tbody>");
            int i = 1;
            for (Product product : lista) {
                pw.println("<tr>");//abre fila
                pw.println("<td>" + i + "</td>");//columna
                pw.println("<td>" + product.getName() + "</td>");//columna
                pw.println("<td>" + product.getImage() + "</td>");//columna
                pw.println("<td>" + product.getQuantity() + "</td>");//columna
                pw.println("<td>" + product.getPrice() + "</td>");//columna
                pw.println("<tr>");//cierra fila
                i++;
            }
            pw.println("</tbody>");
            pw.println("</table>");
        }

    }

    private void store(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int result;

        String varName = req.getParameter("name");
        String varImage = req.getParameter("image");
        int varQuantity = Integer.parseInt(req.getParameter("quantity"));
        float varPrice = Float.parseFloat(req.getParameter("price"));
        String varDescription = req.getParameter("description");

        result = productService.store(varName, varImage, varQuantity, varPrice, varDescription);

        resp.setContentType("text/html");
        pw = resp.getWriter();

        pw.println(result);
    }

}


