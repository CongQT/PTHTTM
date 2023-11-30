<%-- 
    Document   : GDBanCoChiTiet
    Created on : Nov 21, 2023, 9:24:04 AM
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
                height: 650px;
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
                margin-top: -10px
            }
            .intro{
                margin-top: -16px;
                margin-bottom: 4px
            }
            .button{
                background-color: #fff;
                border:none;
                border-radius: 30px;
                text-decoration: none;
            }
            table {
                border-collapse: collapse;
                width: 500px;
                text-align: center;
            }
            table, th, td {
                border: 1px solid #ffffff   ;
            }
            tr, th,td{
                width: 30px;
                height: 30px
            }
        </style>
    </head>
    <body>
        <section>
            <div class="form-box">
                <div class="form-value">
                    <h2>Bàn cờ chi tiết</h2>
                    <div class="intro">
                        ID: ${matchId}<br>
                        Ký hiệu: <c:if test="${symbol == 1}">
                                        X
                                    </c:if>
                                    <c:if test="${symbol == 0}">
                                        O
                                    </c:if><br>
                        Kết quả: <c:if test="${result == 1}">
                                        Win
                                    </c:if>
                                    <c:if test="${result == 0}">
                                        Lose
                                    </c:if>
                    </div>
                    <table border="1">
                        <c:forEach var="row" begin="0" end="14">
                            <tr>
                                <c:forEach var="col" begin="0" end="14">
                                    <c:set var="currentMove" value="${false}" />
                                    <c:forEach var="move" items="${listMove}">
                                        <c:if test="${move.row1 == row && move.col1 == col}">
                                            <c:set var="currentMove" value="${true}" />
                                            <c:choose>
                                                <c:when test="${move.symbol == 1}">
                                                    <td>X</td>
                                                </c:when>
                                                <c:when test="${move.symbol == 0}">
                                                    <td>O</td>
                                                </c:when>
                                            </c:choose>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${not currentMove}">
                                        <td></td>
                                    </c:if>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </section> 
    </body>
</html>
