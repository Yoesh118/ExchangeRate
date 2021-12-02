<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<%--@elvariable id="rate" type="com.example.exchangeratecalculator.rate.Rate"--%>
<form:form method="POST"
           action="/rate" modelAttribute="rate">
    <table>
        <tr>
            <td><form:label path="base_currency_code">Convert from:</form:label></td>
            <td><form:input path="base_currency_code"/></td>
        </tr>
        <tr>
            <td><form:label path="pair_currency_code">Convert to:</form:label></td>
            <td><form:input path="pair_currency_code"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>