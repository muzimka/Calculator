<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="./styleCalc.css"/>">


</head>
<body>

<form  action="/calculator" id="expression" method="post" name="calcFormForm">
    <textarea name="calc"></textarea>
</form>
<table>

    <tr>
        <td><input type="button" value="(" onclick="calcFormForm.calc.value+='(';"/></td>
        <td></td>
        <td></td>
        <td><input type="button" value=")" onclick="calcFormForm.calc.value+=')';"/></td>
    </tr>
    <tr>
        <td><input type="button" value="7" onclick="calcFormForm.calc.value+='7';"/></td>
        <td><input type="button" value="8" onclick="calcFormForm.calc.value+='8';"/></td>
        <td><input type="button" value="9" onclick="calcFormForm.calc.value+='9';"/></td>
        <td><input type="button" value="&#247;" onclick="calcFormForm.calc.value+='/';"/></td>
    </tr>

    <tr>
        <td><input type="button" value="4" onclick="calcFormForm.calc.value+='4';"/></td>
        <td><input type="button" value="5" onclick="calcFormForm.calc.value+='5';"/></td>
        <td><input type="button" value="6" onclick="calcFormForm.calc.value+='6';"/></td>
        <td><input type="button" value="&#215;" onclick="calcFormForm.calc.value+='*';"/></td>
    </tr>

    <tr>
        <td><input type="button" value="1" onclick="calcFormForm.calc.value+='1';"/></td>
        <td><input type="button" value="2" onclick="calcFormForm.calc.value+='2';"/></td>
        <td><input type="button" value="3" onclick="calcFormForm.calc.value+='3';"/></td>
        <td><input type="button" value="&#8211;" onclick="calcFormForm.calc.value+='-';"/></td>
    </tr>

    <tr>
        <td><input type="button" value="0" onclick="calcFormForm.calc.value+='0';"/></td>
        <td><input type="button" value="." onclick="calcFormForm.calc.value+='.';"/></td>
        <td><input type="submit" value="=" form="expression"/></td>
        <td><input type="button" value="+" onclick="calcFormForm.calc.value+='+';"/></td>
    </tr>
</table>


<table>
    <tr>
        <td></td>

    </tr>

</table>


<%--<form  method="post" name="form">
    Type expression to calculate:<br><textarea name="calc"/>
    <button type="submit">Calculate</button>
</form>--%>
${expression} ${result}
<p style="color: red; font-size: large">${error}</p>

</body>
</html>
