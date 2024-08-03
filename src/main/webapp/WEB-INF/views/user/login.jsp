<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<body>
<style>
    .login-container {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }
    .login-form {
        padding: 2rem;
        border: 1px solid #e9ecef;
        border-radius: 0.25rem;
        width: 100%;
        max-width: 400px;
    }
</style>
<div class="container login-container">
    <div class="login-form">
        <h2 class="mb-4">로그인/회원가입</h2>
        <form>
            <a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=ac7aa397c0dd823feac44c965b8da082&redirect_uri=http://localhost:8000/oauth/kakao/callback"><img src="/image/kakaoLogin.png"></a>
        </form>
    </div>
</div>
</body>
<%@ include file="../layout/footer.jsp"%>
</html>
