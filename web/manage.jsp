<%-- 
    Document   : manage
    Created on : Dec 22, 2020, 10:56:02 PM
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
            <table class="table caption-top">
                <caption>List of users</caption>
                <thead>
                    <tr>
                        <th scope="col">UserName</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Address</th>
                        <th scope="col">Tel</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.accounts}" var="a">

                        <tr>
                            <td>${a.username}</td>
                            <td>${a.name}</td>
                            <td>${a.email}</td>
                            <td>${a.address}</td>
                            <td>${a.tel}</td>
                            <td>                               
                                <button type="button" class="btn btn-light" onclick="sendRedirect('vieworder?name=${a.username}')">View Order</button>
                            </td>
                            <th scope="row">
                                <button type="button" class="btn btn-secondary" onclick="sendRedirect('deleteacc?id=${a.id}')">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd" d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                                    </svg>
                                </button>
                            </th>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
