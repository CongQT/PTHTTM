<%-- 
    Document   : GDTrangChu
    Created on : Nov 20, 2023, 11:00:45 PM
    Author     : 84382
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        
            .button{
                width: 400px;
                height: 30px;
                background-color: #fff;
                border:none;
                border-radius: 30px;
                text-decoration: none;
                justify-content: center;
                display: flex;
                margin-bottom: 12px
            }
            
        </style>
    </head>
    <body>
        <section>
            <div class="form-box">
                <div class="form-value">
                    <div style="text-align: center; align-items: center; display: block; color: #fff">
                        <h1>Trang chủ</h1>
                        <div class="button"><a  style="text-decoration: none;margin-top: 5px" href="lichsu"> Lịch sử thi đấu </a></div>
                        <div class="button"><a  style="text-decoration: none;margin-top: 5px" href="bxh"> Bảng  xếp hạng </a></div>
                    </div>
                </div>
            </div>
        </section>  
    </body>
</html>
