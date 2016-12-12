/**
 * Created by QuispeRoque on 08/12/16.
 */
$(document).ready(function () {

    //TODO : views form
    var $formCreate = $('#frmProductCreate');

    //TODO : Form Create
    $formCreate.on('submit', function (e) {
        e.preventDefault();
        var $paramsObj = $formCreate.serialize();
        $.ajax({
            type: 'POST',
            url: "../ProductServlet?accion=store",
            data: $paramsObj,
            beforeSend: function () {
            }, success: function (resp) {
                if (resp == 1) {
                    alert("registrado Correctamente");
                }
            }, complete: function () {
                window.location = "http://localhost:8081/view/product.list.jsp";
            }, error: function (resp) {
            }
        });
    });

    $('#btnClean').on('click', function (e) {
        e.preventDefault();

        if (confirm("desea limpiar la tabla") == true) {

            $.ajax({
                type: 'POST',
                url: "../ProductServlet?accion=clean",
                data: null,
                beforeSend: function () {
                }, success: function (resp) {
                    if (resp == 1) {
                        alert("limpiado Correctamente");
                    }
                }, complete: function () {
                    window.location = "http://localhost:8081/view/product.index.jsp";
                }, error: function (resp) {
                }
            });
        } else {
            e.preventDefault();
        }
    });

    $('#btnLoad').on('click', function () {
        $.ajax({
            type: "GET",
            url: "../ProductServlet?accion=list",
            data: null,
            beforeSend: function () {

            }, success: function (resp) {
                $('#divList').html(resp);
            }, complete: function () {

            }
        });
    });

    $('.btn.btnShowClick').on('click', function (e) {
        e.preventDefault();
        var $this = $(this);
        var idProduct = $this.data('row');
        $.ajax({
            type: 'GET',
            url: '../ProductServlet?accion=show',
            data: 'idproduct=' + idProduct,
            beforeSend: function () {

                //Window.location = "http://localhost:8081/view/product.show.jsp";
            }, success: function (resp) {
                //alert(resp);
                $('#divContentFullDos').html(resp);
            }, complete: function () {
            }, error: function (resp) {
                //alert(resp);
            }
        });
    });

});