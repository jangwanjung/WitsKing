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
        <h2 class="mb-4">회원가입</h2>
        <form action="/user/join" id="joinForm" method="post">
            <div class="form-group">
                <label for="email">고유ID</label>
                <input type="email" value="${username}" name="username" class="form-control" id="email"  placeholder="m@example.com" readonly>
            </div>
            <div class="form-group">
                <label  >닉네임</label>
                <input type="text" class="form-control" id="nickname" name="nickname" oninput="validateForm()">
            </div>
            <button type="submit" id="btn-save" class="btn btn-dark btn-block" disabled>회원가입</button>
        </form>
    </div>
</div>
</body>
<%@ include file="../layout/footer.jsp"%>
</html>
<script>
    function validateForm() {

        var nickname = document.getElementById("nickname").value;
        var btnSave = document.getElementById("btn-save");
        btnSave.disabled = nickname.trim() === "";
    }
</script>

