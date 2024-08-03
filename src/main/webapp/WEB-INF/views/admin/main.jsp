<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<div class="container">
    <h1>게임생성</h1>
    <form action="/admin/makegame" method="post">
        <input type="text" class="form-control" name="scale" placeholder="정원수">
        <input style="margin-top: 10px;margin-bottom: 10px" type="text" class="form-control" name="giftName" placeholder="상품이름">
        <div class="custom-file">
            <input type="file" class="custom-file-input" name="giftPhoto" id="customFile">
            <label class="custom-file-label" for="customFile">상품사진</label>
        </div>
        <button style="margin-top: 10px" type="submit" class="btn btn-dark btn-block">게임생성</button>
    </form>
</div>

<script>
    // Add the following code if you want the name of the file appear on select
    $(".custom-file-input").on("change", function() {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });
</script>