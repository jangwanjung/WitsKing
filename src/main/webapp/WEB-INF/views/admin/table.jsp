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
                <c:if test="${game.winnerNumber==i}">
                    <button style="background-color: goldenrod" class="grid-item" data-toggle="modal" data-target="#myModal${i}" >${i}(${usersCnt[i-1]})</button>
                </c:if>
                <c:if test="${game.winnerNumber!=i}">
                    <button style="background-color: darkgreen" class="grid-item" data-toggle="modal" data-target="#myModal${i}" >${i}(${usersCnt[i-1]})</button>
                </c:if>
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
    <br>
    <br>
    <form action="/admin/sendgift" method="post">
        <input style="margin-top: 10px;margin-bottom: 10px" type="text" class="form-control"   value="${game.winner}" name="username" placeholder="받는사람">
        <input style="margin-top: 10px;margin-bottom: 10px" type="text" class="form-control" value="${game.giftname}" name="giftName" placeholder="상품이름">
        <div class="custom-file">
            <input type="file" class="custom-file-input" name="giftPhoto" id="customFile">
            <label class="custom-file-label" for="customFile">상품사진</label>
        </div>
        <button style="margin-top: 10px" type="submit" class="btn btn-dark btn-block">상품보내기</button>
    </form>
</div>
</body>

</html>
<script>
    // Add the following code if you want the name of the file appear on select
    $(".custom-file-input").on("change", function() {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });
</script>
