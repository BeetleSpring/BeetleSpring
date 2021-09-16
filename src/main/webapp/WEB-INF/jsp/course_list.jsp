<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程列表</title>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/css/beetle-video.css" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<body>



<div class="container">

    <jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
    <%-- 工具导航--%>
    <ul class="nav nav-pills">
        <li class="nav-item">
            <a class="nav-link <c:if test="${typeId==0}">active</c:if>" href="/courseList/0">全部</a>
        </li>
        <c:forEach items="${topicTypeInfo.list}" var="topicType">
            <li class="nav-item">
                <a class="nav-link <c:if test="${typeId==topicType.id}">active</c:if>" href="/courseList/${topicType.id}">${topicType.typeName}</a>
            </li>
        </c:forEach>
    </ul>
    <c:forEach items="${topicsInfo.list}" var="topic"  varStatus="topicStatus">
        <c:if test="${topicStatus.index%4==0}"><div class="row row-cols-1 row-cols-md-4 mt-2"></c:if>
            <div class="col mb-3">
                <a <c:if test="${topic.vipFlag==1&&login_user.vipFlag==1||topic.vipFlag==0}"> href="/courseVideo/${topic.id}"</c:if> target="_blank">
                    <div class="card select-shadow">
                        <img src="${topic.iconUrl}" class="card-img-top" alt="...">
                        <div class="card-body">
                            <p class="card-text">${topic.title}</p>
                            <p class="card-text">${topic.courseViews}人学习</p>
                            <c:if test="${topic.vipFlag==0}">
                            <span class="badge badge-pill badge-success ">免费</span>
                            </c:if>
                            <c:if test="${topic.vipFlag==1}">
                                <span class="badge badge-pill badge-danger ">会员</span>
                            </c:if>
                        </div>
                    </div>
                </a>
            </div>
        <c:if test="${topicStatus.index%4 == 3 || topicStatus.last}"></div></c:if>
    </c:forEach>

    <%-- 分页--%>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item" <c:if test="${topicsInfo.isFirstPage}">style="display: none" </c:if>>
                <a class="page-link" href="/courseList/${typeId}?pageNum=${topicsInfo.prePage}" tabindex="-1" aria-disabled="true">Previous</a>
            </li>
            <c:forEach begin="${topicsInfo.navigateFirstPage}" end="${topicsInfo.navigateLastPage}" varStatus="idx">
                <li class="page-item <c:if test="${topicsInfo.pageNum==idx.index}">active</c:if>">
                    <a class="page-link" href="/courseList/${typeId}?pageNum=${idx.index}">${idx.index}</a>
                </li>
            </c:forEach>
            <li class="page-item" <c:if test="${topicsInfo.isLastPage}">style="display: none" </c:if>>
                <a class="page-link" href="/courseList/${typeId}?pageNum=${topicsInfo.nextPage}">Next</a>
            </li>
        </ul>
    </nav>
</div>
<br>
<br>

<jsp:include page="/WEB-INF/jsp/common/tail.jsp"></jsp:include>


</body>
</html>
