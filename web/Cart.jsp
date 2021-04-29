<%-- 
    Document   : Cart
    Created on : Dec 22, 2020, 4:05:03 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function sendRedirect(url)
            {
                window.location.href = url;
            }
        </script>
    </head>
    <body background="https://3.bp.blogspot.com/-RfrtBCqOYNQ/WjpTfxsju2I/AAAAAAAAtUw/uitlBiCcG9A8--RFWcI9X0FalfRLyoUaQCLcBGAs/s1600/hinh-nen-cuc-dep-cho-may-tinh.jpg"> 
        <jsp:include page="Header.jsp"/>
        <div class="container" style="background-color: wheat">
            <form action="buyinc" method="POST">
                <table class="table table-bordered" style="background-color: whitesmoke">
                    <c:forEach items="${requestScope.carts}" var="c">
                        <tr>
                            <td>
                                <img src="${c.product.image}" style="width:200px;height:150px">
                            </td>
                            <td>${c.product.name}</td>
                            <td>${c.product.detail}</td>
                            <td>
                                <c:choose>
                                    <c:when test = "${c.product.newPrice ne 0}">
                                        <p>${c.product.newPrice}$</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p>${c.product.price}$</p> 
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <input type="checkbox" name="checked" value="${c.id}"/>
                                <input type="hidden" name="pid" value="${c.product.id}"/>
                            </td>
                            <td>
                                <button type="button" class="btn btn-secondary" onclick="sendRedirect('deletecart?id=${c.id}')">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                                    </svg>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="card-body">
                    <button type="submit" class="btn btn-warning" style="margin-left: 90%; width: 100px; height: 60px;" onclick="sendRedirect('buyinc')">Buy</button>
                </div>
            </form>
        </div>
    </body>
</html>
