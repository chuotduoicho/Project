<%-- 
    Document   : login
    Created on : Dec 18, 2020, 4:38:20 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css"> 
    </head>
    <body background="https://3.bp.blogspot.com/-RfrtBCqOYNQ/WjpTfxsju2I/AAAAAAAAtUw/uitlBiCcG9A8--RFWcI9X0FalfRLyoUaQCLcBGAs/s1600/hinh-nen-cuc-dep-cho-may-tinh.jpg">
        <jsp:include page="Header.jsp"/>
        <div class="container">
            <section>				
                <div id="container_demo" > 
                    <div id="login">
                        <form  action="login" method="post"> 
                            <h1>Log in</h1> 
                            <p> 
                                <label> Your username </label>
                                <input type="text" name="username"/>
                            </p>
                            <p> 
                                <label> Your password </label>
                                <input type="password" name="password"/>
                            </p>
                            <p> 
                                <input type="checkbox" name="remember" value="remember" /> 
                                <label>Keep me logged in</label>
                            </p>
                            <p> 
                                <input type="submit" value="Login" /> 
                            </p>
                            <p>
                                Not a member yet ?
                                <a href="signup">Join us</a>
                            </p>
                        </form>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
