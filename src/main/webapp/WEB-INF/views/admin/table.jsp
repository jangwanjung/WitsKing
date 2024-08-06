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
        ${game.info}
        <c:forEach var="i" begin="1" end="${game.scale}">
            <div class="grid-item">${i}</div>
        </c:forEach>
    </div>
</div>
</body>
</html>
