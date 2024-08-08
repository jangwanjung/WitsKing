<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<body>
<style>
    body {
        background-color: #f8f9fa;
    }
    .navbar {
        background-color: #343a40;
    }
    .navbar-brand {
        color: #fff !important;
    }
    .nav-link {
        color: #fff !important;
    }
    .game-card {
        background-color: #fff;
        border: none;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        transition: transform 0.2s;
    }
    .game-card:hover {
        transform: translateY(-5px);
    }
    .game-title {
        font-size: 1.2rem;
        font-weight: bold;
    }
    .game-desc {
        color: #6c757d;
    }
    .game-img {
        height: 200px;
        background-color: #f1f1f1;
        border-radius: 8px 8px 0 0;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .game-img img {
        max-height: 100%;
    }

</style>


<!-- Main Content -->
<div class="container mt-5">
    <h2 class="text-center mb-4">게임 진행 결과</h2>
    <div class="row">
        <!-- Game Card 1 -->

        <c:forEach var="game" items="${games}" varStatus="status">
            <c:if test="${game.play==true}">
                <div class="col-md-3 mb-4">
                    <div class="card game-card">
                        <div class="game-img">
                            <img src="/image/${game.giftphoto}" alt="상품사진" style="width: 250px; height: 200px; object-fit: contain;"/>
                        </div>
                        <div class="card-body">
                            <p class="game-title">${game.title}</p>
                            <p class="game-title">눈치${game.scale}</p>
                            <p class="game-desc">상품:${game.giftname}</p>
                            <span class="material-symbols-outlined">man</span>
                            <span style="font-size: 25px">${game.people}/${game.scale}</span>
                            <br>
                            <a href="/history/table/${game.id}" class="btn btn-dark">결과보기</a>
                        </div>
                    </div>
                </div>

            </c:if>

        </c:forEach>

    </div>
</div>
</body>
<%@ include file="../layout/footer.jsp"%>
</html>