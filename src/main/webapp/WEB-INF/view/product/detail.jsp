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
        <div class="flex_box">
            <form action="/product/${product.id}/update" method="post">
                <input type="number" name="qty" min="1" placeholder="Input number">
                <button type="submit">구매</button>
            </form>
        </div>
        <%@ include file="../layout/footer.jsp" %>