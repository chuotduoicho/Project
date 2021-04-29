<%-- 
    Document   : register
    Created on : Dec 20, 2020, 4:05:03 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="https://3.bp.blogspot.com/-RfrtBCqOYNQ/WjpTfxsju2I/AAAAAAAAtUw/uitlBiCcG9A8--RFWcI9X0FalfRLyoUaQCLcBGAs/s1600/hinh-nen-cuc-dep-cho-may-tinh.jpg">
        <jsp:include page="Header.jsp"/>
        <div class="container">
            <section>				
                <div id="container_demo" > 
                    <div id="login" class="animate form">
                        <form  action="signup" method="POST"> 
                            <h1>Sign up</h1> 
                            <p> 
                                <label> Your name </label>
                                <input type="text" name="namesi"/>
                            </p>
                            <p> 
                                <label> Your email </label>
                                <input type="email" name="emailsi"/>
                            </p>
                            <p> 
                                <label> Your address </label>
                                <input type="text" name="addresssi"/>
                            </p>
                            <p> 
                                <label> Your phone </label>
                                <input type="tel" id="phone" pattern="[0-9]{10}" name="phonesi"/>
                            </p>
                            <p> 
                                <label> Your username </label>
                                <input type="text" name="usernamesi"/>
                            </p>
                            <p> 
                                <label> Your password</label>
                                <input type="password" id="password" required name="passwordsi" required/>
                            </p>
<!--                            <p> 
                                <label> Confirm your password </label>
                                <input type="password" id="confirm_password" required  name="passwordsiconfirm" required/>
                            </p>-->
                            <p class="signin button"> 
                                <input type="submit" value="Sign up"/> 
                            </p>
                            <p class="change_link">  
                                Already a member ?
                                <a href="login"> Go and log in </a>
                            </p>
                        </form>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>
