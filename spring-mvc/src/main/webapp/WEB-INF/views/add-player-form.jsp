<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<style>
    .error {
        color: red;
        font-style: italic;
    }
</style>
<html>
<head>
    <title>Date Selection Form with Datepicker</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#selectedDate").datepicker({ dateFormat: "dd-mm-yy" });
        });
    </script>
</head>

<%--<head>--%>
<%--    <meta charset="ISO-8859-1">--%>
<%--    <title>Add Player</title>--%>
<%--</head>--%>
<body>
<h2>Player Form</h2>
<hr>
<form:form action="processPlayerForm" modelAttribute="athlete">
    <br><br>
    Name: <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br><br>
    Country: <form:select path="country">
    <form:option value="AUT" label="Austria"/>
    <form:option value="FRA" label="France"/>
    <form:option value="SRB" label="Serbia"/>
    <form:option value="SUI" label="Switzerland"/>
    <form:option value="USA" label="United States of America"/>
</form:select>
    <form:errors path="country" cssClass="error"/>

    <br><br>
    Handedness: &emsp;
    Left-Handed <form:radiobutton path="handedness" value="Left-Handed"/> &emsp;
    Right-Handed <form:radiobutton path="handedness" value="Right-Handed"/> &emsp;
    Ambidextrous <form:radiobutton path="handedness" value="Ambidextrous"/>
    <form:errors path="handedness" cssClass="error"/>
    <br><br>

    Grand Slam Titles Won: &emsp;
    Australian Open <form:checkbox path="grandSlams" value="Australian Open"/> &emsp;
    French Open <form:checkbox path="grandSlams" value="French Open"/> &emsp;
    Wimbledon <form:checkbox path="grandSlams" value="Wimbledon"/> &emsp;
    US Open <form:checkbox path="grandSlams" value="US Open"/>
    <br><br>
    Rank: &emsp;<form:input path="rank"/>
    <form:errors path="rank" cssClass="error"/>
    <br><br>
    Prize Money (USD):<form:input path="prizeMoney" placeholder="#,###,###"/>
    <form:errors path="prizeMoney" cssClass="error" />
    <br><br>
    Last Won (dd-mm-yyyy):<form:input path="lastWon" id="selectedDate" />
    <form:errors path="lastWon" cssClass="error" />
    <input type="submit" value="Add Player"/>

</form:form>

</body>
</html>
