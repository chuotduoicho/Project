<%-- 
    Document   : detail
    Created on : Dec 21, 2020, 6:28:09 PM
    Author     : Admin
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <!--            <a><img src="" style="width:415px;height:250px"></a>-->
            <div class="card" style="width: 18rem; margin: 0 auto">
                <img src="${requestScope.detail.image}" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${requestScope.detail.name}</h5>
                    <p class="card-text">${requestScope.detail.detail}</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Date: ${requestScope.detail.date}</li>
                    <li class="list-group-item">Brand:                <img src="${requestScope.detail.groupProduct.image}" class="card-img-top" alt="..." style="width: 90px;height: 60px"> </li>
                    <li class="list-group-item">
                        <c:choose>
                            <c:when test = "${requestScope.detail.newPrice ne 0}">
                                <del>${requestScope.detail.price}$</del>
                                <p>${requestScope.detail.newPrice}$</p>
                            </c:when>
                            <c:otherwise>
                                <p>${requestScope.detail.price}$</p> 
                            </c:otherwise>
                        </c:choose>
                    </li>
                </ul>
                <div class="card-body">
                    <button type="button" class="btn btn-warning" onclick="sendRedirect('buynow?id=${requestScope.detail.id}')" >Buy Now</button>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
