<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/static/css/beetle-video.css" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<body>

<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>

<%--首页内容区域--%>
<div class="container">

    <%--    工具导航--%>
    <ul class="nav nav-pills">
        <li class="nav-item">
            <a class="nav-link <c:if test="${toolTypeId==0}">active</c:if>" href="/tools/0">全部</a>
        </li>
        <c:forEach items="${toolTypeInfo.list}" var="toolType">
        <li class="nav-item">
            <a class="nav-link <c:if test="${toolTypeId==toolType.id}">active</c:if>" href="/tools/${toolType.id}">${toolType.name}</a>
        </li>
        </c:forEach>
    </ul>

    <c:forEach items="${toolInfo.list}" varStatus="toolStatus" var="tool" >
        <c:if test="${toolStatus.index%4==0}"><div class="row row-cols-1 row-cols-md-4 mt-2"></c:if>
        <div class="col mb-3">
            <a href="${tool.toolUrl}" target="_blank">
                <div class="card select-shadow">
                    <img src="${tool.iconUrl}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <p class="card-text text-center">${tool.name}</p>
                    </div>
                </div>
            </a>
        </div>
        <c:if test="${toolStatus.index%4 == 3 || toolStatus.last}"> </div></c:if>
    </c:forEach>



    <%--        分页--%>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <li class="page-item " <c:if test="${!toolInfo.hasPreviousPage}">style="display:none"</c:if>>
                <a class="page-link" href="/tools/${toolTypeId}?pageNum=${toolInfo.prePage}" tabindex="-1" aria-disabled="true">上一页</a>
            </li>

            <c:forEach begin="${toolInfo.navigateFirstPage}" end="${toolInfo.navigateLastPage}" varStatus="idx">
                <li class="page-item <c:if test="${toolInfo.pageNum==idx.index}">active</c:if>">
                    <a class="page-link" href="/tools/${toolTypeId}?pageNum=${idx.index}">${idx.index}</a></li>
            </c:forEach>

            <li class="page-item" <c:if test="${!toolInfo.hasNextPage}">style="display:none"</c:if>>
                <a class="page-link" href="/tools/${toolTypeId}?pageNum=${toolInfo.nextPage}">下一页</a>
            </li>
        </ul>
    </nav>

</div>

<jsp:include page="/WEB-INF/jsp/common/tail.jsp"></jsp:include>


</body>
</html>

