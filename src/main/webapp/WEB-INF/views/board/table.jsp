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
            <button type="submit"  class="grid-item" onclick="select(${i})">${i}</button>
        </c:forEach>
    </div>
</div>
</body>
<script>
    function select(num){
        if(!confirm(num+"번으로 선택하시겠습니까?")){
            return false;
        }
        if(!"${principal}"){
            alert("로그인 하세요")
            return false;
        }
        $.ajax({
            url: "/board/table",
            type: "POST",
            data: {
                num : num,
                gameId : ${game.id},
                userId : ${principal.user.id}
            }
        }).done(function (resp){
            alert("성공하였습니다");
        }).fail(function (resp){
            alert("실패하였습니다");
        });
    }
</script>
</html>