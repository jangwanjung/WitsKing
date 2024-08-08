<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<style>
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
<div class="container">
    <br>
    <h2>게임생성</h2>
    <form action="/admin/makegame" method="post">
        <input style="margin-top: 10px;margin-bottom: 10px" type="text" class="form-control" name="title" placeholder="제목">
        <input type="text" class="form-control" name="scale" placeholder="정원수">
        <input style="margin-top: 10px;margin-bottom: 10px" type="text" class="form-control" name="giftName" placeholder="상품이름">
        <div class="custom-file">
            <input type="file" class="custom-file-input" name="giftPhoto" id="customFile">
            <label class="custom-file-label" for="customFile">상품사진</label>
        </div>
        <button style="margin-top: 10px" type="submit" class="btn btn-dark btn-block">게임생성</button>
    </form>
    <br>

    <h2>진행중인게임</h2>
    <br>
    <div class="row">
        <!-- Game Card 1 -->
        <c:forEach var="game" items="${games}" varStatus="status">
            <div class="col-md-3 mb-4">
                <div class="card game-card">
                    <div class="game-img">
                        <img src="/image/${game.giftphoto}" alt="상품사진" style="width: 250px; height: 200px; object-fit: contain;"/>
                    </div>
                    <div class="card-body">
                        <p class="game-title">${game.title}</p>
                        <p class="game-title">
                            눈치${game.scale}
                            <c:if test="${game.play==true}">
                                (마감)
                            </c:if>
                        </p>
                        <p class="game-desc">상품:${game.giftname}</p>
                        <span class="material-symbols-outlined">man</span>
                        <span style="font-size: 25px">${game.people}/${game.scale}</span>
                        <br>
                        <a href="/admin/table/${game.id}" class="btn btn-dark">테이블보기</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script>
    // Add the following code if you want the name of the file appear on select
    $(".custom-file-input").on("change", function() {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });
</script>