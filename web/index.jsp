<%-- 
    Document   : index
    Created on : Nov 20, 2023, 11:09:12 PM
    Author     : 84382
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
        <style>
            section{
                margin: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                width: 100%; 
                background-color: #E3EFE5;
                background-image: linear-gradient(140deg, #8BA38F 5%, #b4dfbb 50%, #E3EFE5 95%);
                background-position: center;
                background-size: cover;
            }
            .form-box{
                position: relative;
                width: 700px;
                height: 550px;
                background: transparent;
                border: 2px solid rgba(255,255,255,0.5);
                border-radius: 20px;
                backdrop-filter: blur(15px);
                display: flex;
                justify-content: center;
                align-items: center;
            }
            h2{
                font-size: 2em;
                color: #fff;
                text-align: center;
               
            }
            .login {
                width: 100%;
                height: 30px;
                background: transparent;           
                outline: none;
                font-size: 1em;
                padding:0 35px 0 5px;
                color: #fff;
                border:1px solid #fff;
                border-radius: 30px;
                
            }
            .button{
                width: 50%;
                height: 30px;
                background-color: #fff;
                border:none;
                border-radius: 30px
            }
            
        </style>
    </head>
    <body>
        <section>
            <div class="form-box">
                <div class="form-value">
                    <h2> Đăng nhập </h2>
                    <form action="dangnhap"  method="post" >
                        <table>
                            <tr>
                                <td>Tên đăng nhập:</td>
                                <td><input class="login" type="text" name="username" id="username" required /></td>
                            </tr>
                            <tr>
                                <td>Mật khẩu:</td>
                                <td><input class="login" type="password" name="password" id="password"
                                           required /></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input class="button" type="submit" value="Đăng nhập" /></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </section>     
    </body>
</html>

