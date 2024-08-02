<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina di edit Shipping</title>
</head>
<body>
<f:form action="/shipping/update" method="post" modelAttribute="shippingForm">
<f:hidden path="id"/>
<f:label path="shippingDate">Shipping date</f:label>
<f:input type="date" path="shippingDate"/>
<f:label path="scheduleDeliveryDate">Schedule Delivery Date</f:label>
<f:input path="scheduleDeliveryDate" type="date"/>
<f:label path="status">Status</f:label>
<f:input path="status"/>
<input type="submit" value="Edit"/>

</f:form>

</body>
</html>