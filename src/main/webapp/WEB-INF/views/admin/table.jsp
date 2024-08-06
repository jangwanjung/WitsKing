<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<body>
<style>
    .grid-container {
        display: grid;
        grid-template-columns: repeat(auto-fill, minmax(50px, 1fr));
        gap: 10px;
        max-width: 100%;
        margin: 20px auto;
    }
    .grid-item {
        background-color: cadetblue;
        color: white;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 50px;
        border-radius: 5px;
    }


</style>

<div class="container">

    <div class="grid-container">

        <c:forEach var="i" begin="1" end="${game.scale}">
            <c:if test="${usersCnt[i-1]>=1}">
                <button style="background-color: darkgreen" class="grid-item" data-toggle="modal" data-target="#myModal${i}" >${i}(${usersCnt[i-1]})</button>
                <!-- The Modal -->
                <div class="modal" id="myModal${i}">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">${i}번을 선택한사람</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                                <c:forEach var="user" items="${users}">
                                    <c:if test="${user.number==i}">
                                        ${user.username}&nbsp;&nbsp;&nbsp;${user.nickname}&nbsp;&nbsp;&nbsp;${user.creatDate}
                                        <br>
                                    </c:if>
                                </c:forEach>

                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                            </div>

                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${usersCnt[i-1]==0}">
                <div class="grid-item">${i}(${usersCnt[i-1]})</div>
            </c:if>
        </c:forEach>
    </div>
</div>
</body>

</html>
