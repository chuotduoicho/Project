<%-- 
    Document   : profile
    Created on : Dec 21, 2020, 10:24:38 PM
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
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9eAaQ0Tua1oS8JHs8FXb0efFOLImXioyZGw&usqp=CAU" class="card-img-top" alt="..." style="height: 380px;">
                <div class="card-body">
                    <h5 class="card-title">${requestScope.account.name}</h5>
                    <p class="card-text">Telephone:${requestScope.account.tel}</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Address: ${requestScope.account.address}</li>
                    <li class="list-group-item">Email: ${requestScope.account.email}</li>
                </ul>
                <div class="card-body">
                    <button type="button" class="btn btn-warning" style="background-color: whitesmoke" onclick="sendRedirect('editProfile?id=${s.id}')" >Edit</button>
                </div>
                <div class="card-body">
                    <button type="button" class="btn btn-warning" style="background-color: whitesmoke" onclick="sendRedirect('vieworder?name=${requestScope.account.username}')" >View Order</button>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
