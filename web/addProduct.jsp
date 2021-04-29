<%-- 
    Document   : addProduct
    Created on : Dec 22, 2020, 9:27:15 PM
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
    </head>
    <body background="https://3.bp.blogspot.com/-RfrtBCqOYNQ/WjpTfxsju2I/AAAAAAAAtUw/uitlBiCcG9A8--RFWcI9X0FalfRLyoUaQCLcBGAs/s1600/hinh-nen-cuc-dep-cho-may-tinh.jpg">
        <jsp:include page="Header.jsp"/>
        <div class="container" style="background-color: wheat">
            <form action="addP" method="POST">
                <div class="mb-3">
                    <label for="formGroupExampleInput" class="form-label">Name</label>
                    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Name" name="namep">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput2" class="form-label">Detail</label>
                    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Detail" name="detailp">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput2" class="form-label">Price</label>
                    <input type="number" class="form-control" id="formGroupExampleInput2" placeholder="Price" name="pricep">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput2" class="form-label">Image</label>
                    <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Image" name="imagep">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput2" class="form-label">Date</label>
                    <input type="date" class="form-control" id="formGroupExampleInput2" placeholder="Date" name="datep">
                </div>
                <div class="mb-3">
                    <label for="formGroupExampleInput2" class="form-label">Brand</label>
                    <select class="form-select" id="inlineFormSelectPref" name="bid">
                        <option value="-1">Brand</option>
                        <c:forEach items="${requestScope.GroupProducts}" var="p">
                            <option 
                                <c:if test="${p.id eq param.bid}">selected="selected"</c:if>
                                value="${p.id}">${p.name}</option>
                        </c:forEach>
                    </select>
                    <br/>
                    <br/>
                </div>
                <div class="mb-3">
                    <input type="submit" class="form-control" id="formGroupExampleInput2" style="background-color: tomato;" value="Create">
                </div>
            </form>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
