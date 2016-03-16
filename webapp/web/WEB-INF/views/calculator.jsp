<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<form  method="post">
    Type expression to calculate:<br><input type="text" name="calc">
    <button type="submit">Calculate</button>
</form>
${expression} ${result}


</body>
</html>
