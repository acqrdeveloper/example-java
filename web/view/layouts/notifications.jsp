<%--
  Created by IntelliJ IDEA.
  User: QuispeRoque
  Date: 19/12/16
  Time: 00:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    boolean rpta = true;
    String level = "success";
    String msg = "execute succesfully";

    if (rpta) {
%>
<div id="idAlertFlash" class="alert alert-<%=level%>">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <%=msg%>
</div>
<%
    }
%>

<script type="text/javascript">
    $('#idAlertFlash').not('.alert-important').delay(3000).fadeOut(350);
</script>