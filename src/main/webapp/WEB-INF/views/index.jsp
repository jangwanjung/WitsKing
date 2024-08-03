<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
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
    <h2 class="text-center mb-4">눈치왕</h2>
    <h2 class="text-center mb-4">현재진행중인게임</h2>
    <div class="row">
        <!-- Game Card 1 -->
        <div class="col-md-3 mb-4">
            <div class="card game-card">
                <div class="game-img">
                    <img src="path/to/image" alt="Game Image">
                </div>
                <div class="card-body">
                    <p class="game-title">눈치 게임</p>
                    <p class="game-desc">상대방의 행동을 눈치 빨리 파악하는 게임</p>
                    <a href="#" class="btn btn-dark">플레이하기</a>
                </div>
            </div>
        </div>
        <!-- Game Card 2 -->
        <div class="col-md-3 mb-4">
            <div class="card game-card">
                <div class="game-img">
                    <img src="path/to/image" alt="Game Image">
                </div>
                <div class="card-body">
                    <p class="game-title">퍼즐 게임</p>
                    <p class="game-desc">다양한 퍼즐을 풀어 점수를 높이는 게임</p>
                    <a href="#" class="btn btn-dark">플레이하기</a>
                </div>
            </div>
        </div>
        <!-- Game Card 3 -->
        <div class="col-md-3 mb-4">
            <div class="card game-card">
                <div class="game-img">
                    <img src="path/to/image" alt="Game Image">
                </div>
                <div class="card-body">
                    <p class="game-title">타이밍 게임</p>
                    <p class="game-desc">정확한 타이밍을 맞추는 게임</p>
                    <a href="#" class="btn btn-dark">플레이하기</a>
                </div>
            </div>
        </div>
        <!-- Game Card 4 -->
        <div class="col-md-3 mb-4">
            <div class="card game-card">
                <div class="game-img">
                    <img src="path/to/image" alt="Game Image">
                </div>
                <div class="card-body">
                    <p class="game-title">기억력 게임</p>
                    <p class="game-desc">순서와 패턴을 기억하는 게임</p>
                    <a href="#" class="btn btn-dark">플레이하기</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%@ include file="layout/footer.jsp"%>
</html>
