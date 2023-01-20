<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>
        <H1>제품상세 페이지</H1>
        <hr />

        <table border="1">
            <tr>
                <th>번호</th>
                <th>상품명</th>
                <th>가격</th>
                <th>재고</th>
                <th>등록일</th>
            </tr>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.qty}</td>
                <td>${product.CreatedAtToString}</td>
            </tr>
        </table>
        <form action="/purchase/insert${product.id}/update" method="post">
            <input type="hidden" name="productId" value="${product.id}">
            <select name="count">
                <c:forEach begin="1" end="${product.qty}" var="num">
                    <option value="${num}">${num}</option>
                </c:forEach>
            </select>
            <button type="submit">구매</button>
        </form>
        <%@ include file="../layout/footer.jsp" %>