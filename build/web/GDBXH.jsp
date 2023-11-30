<%-- 
    Document   : GDBXH
    Created on : Nov 21, 2023, 11:07:43 AM
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
                    <h2>Bảng xếp hạng</h2>
              
                    <table border="1">
                        <tr>
                            <th>Hạng</th>
                            <th>ID người chơi</th>                          
                            <th>Tên người chơi</th>                           
                            <th>Số trận chơi</th>
                            <th>Số trận thắng</th>
                            <th>Tỉ lệ thắng</th>
                        </tr>
                        <c:forEach var="bxh" items="${listBXH}" varStatus="loop">
                            <tr>
                                <td><c:out value="${loop.index + 1}" /></td>
                                <td><c:out value="${bxh.getPlayerId()}" /></td>
                                <td><c:out value="${bxh.getName()}" /></td>
                                <td><c:out value="${bxh.getTotal()}" /></td>
                                <td><c:out value="${bxh.getWins()}" /></td>
                                <td><c:out value="${bxh.getPercent()}%" /></td>
                    
                            </tr> 
                            <c:if test="${bxh.getPlayerId() == player.getPlayerId()}">
                                <c:set var="rankOfCurrentUser" value="${loop.index + 1}" />
                            </c:if>
                        </c:forEach>
                        <c:if test="${not empty rankOfCurrentUser}">
                            <tr>
                                <td colspan="6" style="text-align: center; font-weight: bold;">
                                    Rank của bạn: ${rankOfCurrentUser}
                                </td>
                            </tr>
                        </c:if>
                    </table>
                </div>
            </div>
        </section>   
    </body>
</html>
