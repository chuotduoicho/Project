<%-- 
    Document   : vieworder
    Created on : Dec 23, 2020, 4:42:29 PM
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
            <table class="table table-bordered" style="background-color: whitesmoke">
                <c:forEach items="${requestScope.orders}" var="c">
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
                        <c:if test="${sessionScope.user.rule eq 0}">
                            <td>
                                <button type="button" class="btn btn-secondary" onclick="sendRedirect('checkorder?id=${c.id}')">
                                    Checked
                                </button>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
            <c:if test="${sessionScope.user.rule eq 0}">
                <div class="card-body">
                    <button type="button" class="btn btn-warning" style="margin-left: 90%; width: 100px; height: 60px;" onclick="sendRedirect('manage')">Return</button>
                </div>
            </c:if>
        </div>
    </body>
</html>
