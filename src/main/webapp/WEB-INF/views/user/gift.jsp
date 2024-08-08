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
    <h2 class="text-center mb-4">당첨내역</h2>
    <div class="row">
        <c:forEach var="gift" items="${gifts}" varStatus="status">
            <c:if test="${gift.username==principal.user.username}">
                <div class="col-md-3 mb-4">
                    <div class="card game-card">
                        <div class="card-body">
                            <p class="game-title">${gift.giftName}</p>
                        </div>
                        <div class="game-img">
                            <img src="${gift.giftPhoto}" alt="상품사진" style="width: 250px; height: 200px; object-fit: contain;"/>
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
