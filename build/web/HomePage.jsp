<%-- 
    Document   : HomePage
    Created on : Dec 17, 2020, 8:03:37 PM
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css"> 
        <script src="pagger.js" type="text/javascript"></script>
    </head>    
    <body background="https://3.bp.blogspot.com/-RfrtBCqOYNQ/WjpTfxsju2I/AAAAAAAAtUw/uitlBiCcG9A8--RFWcI9X0FalfRLyoUaQCLcBGAs/s1600/hinh-nen-cuc-dep-cho-may-tinh.jpg">

        <jsp:include page="Header.jsp"/>
        <div class="container" style="background-color: wheat">
            <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel"  style="width: 1000px;margin: 0 auto;" >
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://2.bp.blogspot.com/-EjPxyjggeW8/VWRGWIK6BbI/AAAAAAAADnI/f2SSHZrN9Pg/s1600/FINAL-Logo-Spread-JPG.jpg" class="d-block w-100" alt="..." >
                    </div>
                    <div class="carousel-item">
                        <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAcYAAABvCAMAAABB2JCJAAAAwFBMVEX///8CndX8//8dpNP///0AmtMAmdO94/P///vV7/QAm9Ld8PeS0usAndQAmdL//v9QteIdqdpCsd/R6vUzqdZRt+AAmdd1wuIAntJkveIAm9kAldCh1e3r9/jJ6PL6/vrj9fjD5fMzqd3z+PqHy+e03e+85O6j1+lGsNlbut3d9Pnt/fyWy+iv2eaHxuWGyeM7stYAltpkuONowN91weXh9PLv+/VCr+HK7PKGzuSl1O5PtNnH4/Ke1eIAlccAptwMp0++AAATaklEQVR4nO1dC3fiuA5OgmxMgpMCqTFQCC3l0c607Ezf0723//9f3TycBxAroWV3zt3Nd+ZRaOw4liVLsqQYRoMGDRo0aNCgQYMGDRo0aNCgQYMGDRo0aPA3AQzwPMOyfvc4GnwFwd3d69RgjP3ugTT4Cjxobyb//Ti/v7h0FhExASz43YNqcDzAuL32J0K4wuyNtsvBNGjI+H+IiGjB6twU0iSEUsr9n91Lxwq/93730Boch3BvvH0zqZmAuIL7N+vZ8+8eVoPPYN0TZgZKXbN/ffktpHDwuwfW4AhYwGY/OeEZJbm0hbvpDhpj5P8N0BmaBUJGEpa6veFqYfytFglAaMmmOFWPIayTItIrvH190AO80c6jlaLOTGPtQ5XGYuAM6Q4dTWmaovUwq+jYMyrGn9yg7qSPWlr4u+jv4nwXI4WfN2G3366kvtvj8d7tMLZPxsDwsTZ/hA06BO3Wr9RJLEf/HOY6ncPBCzX3QajfnWLrhHX8yjn6VpuMC07yW5OdkYx3PhLT3sXu1SQF/Rn127EPHuzzCDud8MfBnpyCmSD6JmJtWAZbTQ4nOL/G7C0qTD7YatsTd64uCoCt5cF13BR06ACUcxTAUnCuH3/8CBf1DdLLCdbVJyCWYa8eW/84JSEjRVD46x0VkD0gl3MRTbJnXCBkDGfKn+KzY7X07TdFqszfRcklnDwMNBx5PeYlDYpja7Xrb6/IcvskSDR/YMGo7Lm+gPCpqd8pTrEtkas38UoGb0ixJU96U2TFA7sU2smeXOxeujYP1y0hwvw5ALardYDFpuchL6KPK3gHjPrc2EM7Ox6kn9ybLfwT9xxBFhSHP/VTHFJcbVwQ9FGpQP0FMjnsXN+Sz3fEZcA6/XLBJs4v97t1elXMQ3tPcITK+Xxqnhlfp0vo9tR8bkbckzowPXaD9U8yabnwEaYN5+vlWbvmAZud80ORt6W85F6c0JcVy2m+YHf4phiN6uxAMUexPDEZTTvbDNjdX0DHiaMeD6bYZeQd0mkAB+PaaH/U8iN0XW0zcXd4Pbs81HRi2KKXcyR7q5hzzsXjgV6OwYOHE081bWWTAt2/gozZdNxhkxHrWWrWlmSMdkm1dgf09FzTKlOOYL7RjIpM+u1YkLDpe4VSyU27ewQNjch4lcS2OY/+xvaDrTYSjm7APG6RtItMj+if8EP0UTxknQd9RHQQs+QGVaImxCTbHG+QERKZTTLAhlTphL7G7pjp+ZiOypoACx6ppo2kL+3wko6P6lwRFcn6SA8QTCOr/f39LERs0l/1Ynx8fKB3Gp/psGlnj9fRPVDchd8rwYdeiClMlK7KHIzo5CZ/xHm14VPOj8AQUeUuyykP7EIrJYi7ma1kxVrllFf5f/TkTHeSbEdZYQJRnkctSmGk+hXAvX7AXGxLFxy0qzZ/rmR2OFuYnlqY5HWN3Z/0FiXjwXZfrjkrBoP9qaUUJ8KtpGLr9lMkLINl3GC3c5fVXYCFmDLc7JQ2sqCDqpWh/FMRE6GoRC7LZaoBfbzHBLTMD4AtgKH2wT02739ebySb+eliCeAJf+ga56PWDBGQcpPz/c4UGDBAlyu/Vyaxg0qLn3nnt3bFzqge6cAPEMBGf7mtF3yeB9aDMOssngNwOloYpzvmYmtslsq39/0uHhF6jNe6HizjAdvLaDp9Xewq0c477GI7dLHnfbsjwAwViZ8MB9efU9Inw5MeOcMZxhNiVYOMIBE130VcJ2+YedBLGnrMR2VqLi0CVPgWQa92/QAMcVPS6wpdEpbjMlUcBxcXpz2kvMXuJltV5wIRVgi70Bsk+gibd7pN7ux1JojQosN8Njr1tynS29kfA+TSSadC8nnsdVx3/WT3l204afgHQ0UW0W/vBSCuMj7ZdzIWbr1E7YPX5CpAhZZY5f1tjzhnob2nwkiWeiud9mpMQKdVb1dOMeaz0/KiBahXe1zHrllgPbR0iw6MOaYa8Bd1egeYWcvN3BEHV9g49rFz3rHRrxTUywIeOJF/DJyrKr9DcdCiN4f6p/11AB3UXeTXiZJeYqLxTdfKYn2MzXhq6MzQq3JpwTqV/oTdkWVyNZgiqhFx0OnbTh6fWWhBT/36d6cb7KTlU4At6q7c1lFwELuTux1ND4w9oG5snnCxZwwxnhW5tGDXR1pw5EPxI+sioQV9Pdd4RhBuJ+RjZjCPLfBDshxyPPoLQs9bmBfNvK3B+nNsqvoa9z1zdI7lBLSbbB4QoFrgRy6yoYVPX8k9evO4pYVIY6o1l0I8+dEzcDEM9UAW+LhXXoHTcqfWVwBojIsp/TqdYA4QOpwNnAPMZhcjim4mPHPEtbHrilPyenyECrmK3SiI2OZE62ix2EAmY5OiN2Ng1bF3OLfXJ7T5U7ARNpnjXzW4PzjHRj+2bfcQkyp3Ks0UixFq1RaiX4bHKv1muj8+6i8gZ/oHX5r50ZB9HRihXK3kR24eEXRTG7BA9SsXjdpTcDAF52FGPuHj4GM/FZZTbID2JlvYgXf8baIBhvvjFNl8iU6mQmioZYFS4f/ixWHwXKmvynL/8leBBgSQ8zp5Q8ipuUnbxuVnguZkJ70xpgWb4+tsFAxVaPUgcoptCnyue+z9KDLurgGmrSop86Dr70vABCIn7eoOAszmkmbgsdmxwk7yzFpl7AZzk44H2Thg9MnwA3Kl9/Vxs3whB+ypxFj6ce5AZ1wWoVOAeDh97g5gSmZ+3ocCOzAeP4JlHcmPhNOek0ky1ENg+/mUTNGjMlTUScQrviw5nAm10kGrZBeU1FyyJR4MFNJxeEQoYy0AW2OqBn2osTOirrI4CuNIfiRilLtx0dMXKbr5ANuYTMA89yjsMqUSWFsXjUAeg2GVVBBvp1ZyAvRwg17WOaNChxwNGDxjVpcfuT3xZ4UYevYH0lISJ+MVNtRTim5ntCLeVwN7dPjAHjB9dDo3/adK85V+Py07AqZkmiYaZJ0COzCmKozVYrOqR4vSWSiVrdFsJ3x6jnmcecGqxbRN+5at5KfO6N2VcQg2+oE0sa+QqOW02zp23BH4jvkB7evqDhhs9VzAReqI86CSjq3N8GLmWMbOxgFoVoYoGANLfRYN34AFK8KP15i5PPSasem7i1kV3KRcVt1KrNkpHeM+JmrIa3UHwBD9gPiZdLTgEg8DXj+XJDF4gGYrTJ7yFiPtzMlwzkKl5NI+en/kdHiYIuX4oiJkg8sy/WdvTGVs/kkwNCrR9Gv4jACz1ui2eOUK13M6ZfE6aBAO3eRLeoG40+LoA8+ouH9py4NTOraq2mO53erMKyU4N1+PydpAwdDzWNqtoVAxTC8b76REofsjJ7LsPOgN06PJOve6L/WxhEQFE7FVzUCdHL2DmV5X5UZxupkyNqty73LCT+bO8dDzWNupsQ9PkS5If3cW2Az3hTsHywauUKGfpecCQ5zSdJX22z5yf6TXOzNgecG20vsukpiSSqsjUiBPZHegZoDdr66UBkYb0ZHEHjtbER21dOHjKFFid+UMCMaNhWDxKWZdplaoxdoE2ckPR0RmheGEW/fiplJY0i7EWtHcrAqy4uTMOk2JpCF2J3dd3QEw5PhhbM73LvdwfiS9vUpeWLhaqOAUspx+IQtyWzgXunOPCGGTflCYZo/d+lUsRng73a63VYpQOMNDdoLtEaySjNkck4oM67gL1FrbHGqebIbYgZK87EbhBViUkOS5VQsb7ZNw0sm1TQ/ujjhvmewE4cBrC98WJRctJ0uswGYmHZrQpIYcBTwjkbzX6QPrgpfYuBX8aG922PESs2rJKNdTkQScNB86e+j6uyMvKF0WQ1PzIki5KTq9EXs6w3hej1QYAE3gFe0aKwWw8xFaxs4RHfWE5O5NUNge0XNgmp++YE4CerE3gnVdfiRX+Ug89lZx0M05GRa3ulBQ1RDf71/3AqBsb8ugxg2mCEnoe2kQToVfToyyVp6FTpzMT1/Q4ImnvVFUxMYWHqCgoT2PqowVOd7NU4RwY6+R2YEF+tSBB3r3VfQMw2otCtgamT6hO6vE5SodZs5u9ES7mFrS0V9mH+wNnrH+UZV2GEGKLByZTfHor2ibkweegm81QoMIr+O2xsDO0bjBP+t0gYX0Ud3paMiPGD+M05BKvGoDLaSWIGHvpUn7aOpRCrnJ3CwdWZUyRf2ng1UPdeIt7eEXxWrF4UaNyleA+ZzcB/0yC/kRO6NUwW5TbBZkIcvJQgyB8mQovAySeoDU4GJLWSUdxU2JiW3VyHwOn7ZOphOC75iSWSuUEr5jCg4S/xHADBNrqpTQHSaUxg8Zr4CjP3Agj6XPUYcfRbz3hqzSrXSF22+lkfzYEWjeuE6GiB4ephZwUxfqvYMWstw+sEQsD5er4j/RJX+ggY3FYHE9TcRMM4pulcAjN0nhq6C6eol9pxGMTg125JP1UeVU9vD630kC6rrRH0rDn13XFZQQIq7qSGyn99H7+ODcJqorN+yDTgQNOxGPpQnGCmCF/Egp0cD+sQY2jTr/iMqATAojpfFdqDvOew+4q+toIrVT9J+J9vZxScMfd3HgwtyfUBxCdrSTdV7VOHwe1/1K4jh4lvctxHQe4va2E2EW4vKyHaIWM0bVMhlTdt4i7uo26WW1as/xth5z2hgCz4u6Zqm7KhypGuZr2H27/ZoP8BnpZqC5fbQ/o/dfrRYRbeBp0KnAQB92FjxXNY6x+IJLzgssVU0jQ+FjvfURleIo1uXIv66s9gvl5QByMPA8YCXdJz94+Q2OK9SVojJRLHbhaQprHlxXjpo6aMVMNGjQoEGDBg0aNGjQoEGDBg2+AE9XYTS7InVAxO8QstSH3N8ARtZD4izQ9Md2vCxG/DpPYJ/zWzTYx7fD2hIRCsEni8Ft/FUQkRHm8c+dvNocBGmbTuRVCsr7C1E8JwjmnVm7fek4z82rdk+CYDOxDxzklLaGc+VRZ5dERF/JmHKWL2J/exK+HHHl7Cr+NXE/4pMUby3K/exURW4DCy4fr2TsEqe89zJaP/29Lyn7R4IFpaf6fCzVoQNLXs/C+/EnVUwijfyE6Sgp3Ehp10pc+PPyQy3SUs7voNsSxeLj4SJ6n//tj/1Pg/ekTh3lmIcgXIwTsroJ3QCSqgAqQ3CQEInHR8Qs6NL4s6T9NGgHktNobu9z43m0N0LQjd/IalNJeEuS5DCSmg07fhFMRZXRN2cew/mPiiNozaPfgyo8oCpZJKEfZBNL3FkvDqLlgq+z4rbsMb6Cbgd7mMcqznYSxzxu1oP51Fo418miEDVqgDfAoNLBuMiSjlS6AeXJQaWqJ2DHccfsMQ4Wse9DAXr7qKSxGBUOfdWbPMrjV6ykAhExU5nMXuJ9mfqNwvo1sKRUnJ2+ERBCpSeZap7M9TbZx2Ss4ARxCSoyXoO1lnEeHqdRoY78VFEFgUln19xINkaVTGrzeZyPG5od9+cvLy/9s581siwaIPimkgtuQO1PbJUEQU2SSGMrqfiT5EGk71dyO7P0XdVkuEsBFVgrd79VWi+kpZfl+/flbBpFNkR2aPjPaQur/vtwqSbWHw633yMMY7HJb5RJMU3C1mlcFByUhmOOXPUDGW93j/6HSgGVxfeX8kmy+VneNY0VY2lG5ob5x3Y5DyIqNjL1i8heAZMFOEXEeUtL0IN6n+MkCfxJg1sLBoPYTR7slUZCZmV12VIWcovsMR3721nznvIvAox+MqFZqkiSxCqvrhOpGOo78W9EPNVKDY0bmCqjQ5JBQcF5VvWpJC1yo5tVfPWM+bY3oSQntk3pplb0WgMtvOePhDBX6fu2z4Wy+1qx+hm8x1TkSpXMi4JMZDfJlZfyKt8HPfWKKHL+OCyiW6A0LAYXDx9C0MwJQMnT/sAaHANQJdBENs9sqorLjmPzX+k06t0HSh/iksqLAO5oYr2T9zxjOAl75qW1KDwWO9GTxOfn1+XFexrqPt7P3GtwFCCpvynFLA+eVJUQeWwp/plkH6hkDlWNi/Z+WcxibJMK0LwGVOLyoVdlgatP99vuxcVFUtUoCsCFp4S7G/P/q0hybLk5z78apNkg0XcqqcCOXAHpK/7stNp7lsk0SasVK5crLSkzF5V0SGLEC8ZFkuFBSrN5G9RGoOrEX8XBz/Hh4fRGuUkfom9UQYE4HzZ9ubJYKhuDXacFN1M/uir0RIvaa/SbuIF1FZOdLJMY7ch+iTUdXk71BrXhJGSw+6vl+tfb9fDh3E/qdUrRi1KtWUInchZbjeqdLiRNJwiCtKIYUYWyu0l/3N9szqP3nT4+3t/fd3/9uovYja3dxGbsL6fW3GmvH+LaMpzKr+ap/tuxTKwGSWgo2WwqbJUBz6kfZVWAKiBB72OhOVWsOVetrbyAa1xZDuAs3Vdj2rrK6hAifiuQBw9Rd4TLUE2dCJuS8G6S0pZzsppj/0pYxlCT7iSSV9bANvm9qnpymXwqvKmJjUSaFbUGw5tKTcqUKpwX3ESX5yfJkSunt9W/v75BLcDyQqG7g4tVQil2p76IVRAYXMcfCiUXYJ61eQtCMnY1SO176+J6OBxt+ptN/+znaHjfXTkL4y94Jce/C1Ya7sR2zyPSSCcVTaUqrkH6sVgzhRUCqixtfJaXUirqwQjiq5OeGxI2aNCgQYMGDRo0aNCgQYMGDRr8o/A/W/xuXBfxZxoAAAAASUVORK5CYII=" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="data:image/png;base64,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" class="d-block w-100" alt="..."  >
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleFade" role="button" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleFade" role="button" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </a>
            </div>
            <!--            slider-->

            <!--            search-->
            <form  action="Home" method="GET">

                <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
                    <input type="checkbox" class="btn-check" id="btncheck1" autocomplete="off" name="sale" value="sale">
                    <label class="btn btn-outline-primary" for="btncheck1">Sale</label>



                    <div class="col-12">
                        <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
                        <select class="form-select" id="inlineFormSelectPref" name="bid">
                            <option value="-1">Brand</option>
                            <c:forEach items="${requestScope.GroupProducts}" var="p">
                                <option 
                                    <c:if test="${p.id eq param.bid}">selected="selected"</c:if>
                                    value="${p.id}">${p.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-12" >
                        <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
                        Price From: <input type="text" value="${param.from}" name="from"/> 
                        Price To  : <input type="text" value="${param.to}" name="to"/> <br/>

                    </div>
                </div>
                <input class="form-control me-2" type="text" placeholder="Search" aria-label="Search" name="name" value="${param.name}">
                <button class="btn btn-outline-success" type="submit" style="background-color: blanchedalmond">Search</button> <br/>
            </form>

            <!--product-->   
            <div class= "container-fluid" style="margin: 0 auto;">
                <div class= "row d-inline-flex" >
                    <c:forEach items="${requestScope.Products}" var="p">

                        <!-- Gallery Item 1 -->
                        <div class ="col-12 col-sm-6 col-md-4 p-2" style="background-color: white">
                            <div class="d-flex flex-column text-center border height100">
                                <div >
                                    <a href="${p.image}"><img src="${p.image}" style="width:415px;height:250px"></a>
                                </div>
                                <h2 style="font-size: 20px">${p.name}</h2>
                                <div class="product-wid-price">
                                    <c:choose>
                                        <c:when test = "${p.newPrice ne 0}">
                                            <del>${p.price}$</del>
                                            <p>${p.newPrice}$</p>
                                        </c:when>
                                        <c:otherwise>
                                            <del>......</del>
                                            <p>${p.price}$</p> 
                                        </c:otherwise>
                                    </c:choose>

                                </div>

                                <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                                    <c:choose>
                                        <c:when test="${sessionScope.user ne null}">
                                            <c:choose>
                                                <c:when test="${sessionScope.user.rule ne 0}">
                                                    <button type="button" class="btn btn-danger" onclick="sendRedirect('addcart?id=${p.id}')">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart2" viewBox="0 0 16 16">
                                                        <path fill-rule="evenodd" d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l1.25 5h8.22l1.25-5H3.14zM5 13a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
                                                        </svg>
                                                    </button>
                                                    <button type="button" class="btn btn-warning" onclick="sendRedirect('detail?id=${p.id}')" >Buy Now</button>
                                                </c:when>
                                                <c:otherwise>
                                                    </button>
                                                    <button type="button" class="btn btn-warning" onclick="sendRedirect('addP')" style="background-color: yellow"> Create </button>
                                                    <button type="button" class="btn btn-warning" onclick="sendRedirect('updateP?id=${p.id}')" > Uppdate </button>
                                                    <button type="button" class="btn btn-danger" onclick="sendRedirect('deleteP?id=${p.id}')">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
                                                        <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                                                        <path fill-rule="evenodd" d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                                                        </svg>
                                                    </c:otherwise>
                                                </c:choose>

                                            </c:when>
                                            <c:otherwise>
                                                <button type="button" class="btn btn-danger" value="${p.id}" name="cartid" onclick="sendRedirect('login')">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart2" viewBox="0 0 16 16">
                                                    <path fill-rule="evenodd" d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l1.25 5h8.22l1.25-5H3.14zM5 13a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
                                                    </svg>
                                                </button>
                                                <button type="button" class="btn btn-warning" onclick="sendRedirect('login')" >Buy Now</button>
                                            </c:otherwise>
                                        </c:choose>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <!--pagging-->
                <div id="pager_bottom" class="pagination justify-content-end"> </div>
                <script>
                    renderPager("pager_bottom",${requestScope.pageindex},${requestScope.totalpage}, 3);
                </script>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    </body>
</html>
