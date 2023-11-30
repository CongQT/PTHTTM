<%-- 
    Document   : GDLichSuDau
    Created on : Nov 21, 2023, 8:49:13 AM
    Author     : 84382
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            .intro{
                margin-top: -16px;
                margin-bottom: 8px
            }
            .button{
                background-color: #fff;
                border:none;
                border-radius: 30px;
                text-decoration: none;
            }
            table {
                border-collapse: collapse;
                
                text-align: center;
            }
            table, th, td {
                border: 1px solid #ffffff   ;
            }
            th, td {
                padding: 10px;
            }
        </style>
    </head>
    <body>
        <section>
            <div class="form-box">
                <div class="form-value">
                    <h2>Lịch sử thi đấu</h2>
                    <div class="intro">
                        ID người chơi: ${player.getPlayerId()}<br>
                        Tên người chơi: ${player.getName()}
                    </div>
                    <table border="1">
                        <tr>
                            <th>ID</th>                          
                            <th>Kết quả</th>
                            <th>Ký hiệu</th>
                            <th>Xem chi tiết</th>
                        </tr>
                        <c:forEach var="match" items="${listMatch}">
                            <tr>
                                <td>${match.getMatchId()}</td>                              
                                <td>
                                    <c:if test="${match.getResult() == 1}">
                                        Win
                                    </c:if>
                                    <c:if test="${match.getResult() == 0}">
                                        Lose
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${match.getFirstPlayer() == 1}">
                                        X
                                    </c:if>
                                    <c:if test="${match.getFirstPlayer() == 0}">
                                        O
                                    </c:if>
                                </td>
                                <td><a href="bcct?matchId=${match.getMatchId()}&result=${match.getResult()}&symbol=${match.getFirstPlayer()}">Xem chi tiết</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </section>   
    </body>
</html>
