<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>눈치왕</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal" var="principal"/>
    </sec:authorize>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/">홈</a>
            </li>
            <c:if test="${not empty principal}">
                <li class="nav-item">
                    <a class="nav-link" href="/gift">당첨내역</a>
                </li>
            </c:if>
            <c:if test="${empty principal}">
                <li class="nav-item">
                    <a class="nav-link" href="/user/login">로그인/회원가입</a>
                </li>
            </c:if>

            <li class="nav-item">
                <a class="nav-link" href="/history">게임 결과</a>
            </li>
            <c:if test="${principal.user.role eq 'ADMIN'}">
                <li class="nav-item">
                    <a class="nav-link" href="/admin">관리자페이지</a>
                </li>
            </c:if>
        </ul>
    </nav>

</head>