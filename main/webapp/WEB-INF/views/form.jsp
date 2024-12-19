<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form Page</title>
    <style>
        .error { color: red; font-size: 12px; margin-left: 10px; }
    </style>
</head>
<body>
    <h1>Enter Your Details</h1>
    <form:form action="/submitForm" method="post" modelAttribute="formData">
        <label for="firstName">First Name:</label>
        <form:input path="firstName" id="firstName" />
        <form:errors path="firstName" cssClass="error" /><br><br>

        <label for="lastName">Last Name:</label>
        <form:input path="lastName" id="lastName" />
        <form:errors path="lastName" cssClass="error" /><br><br>

        <label for="email">Email:</label>
        <form:input path="email" type="email" id="email" />
        <form:errors path="email" cssClass="error" /><br><br>

        <label>Degree:</label><br>
        <form:radiobutton path="degree" value="Bachelor" id="bachelor" />
        <label for="bachelor">Bachelor</label>
        <form:radiobutton path="degree" value="Master" id="master" />
        <label for="master">Master</label>
        <form:radiobutton path="degree" value="PhD" id="phd" />
        <label for="phd">PhD</label>
        <form:errors path="degree" cssClass="error" /><br><br>

        <label for="specialization">Specialization:</label>
        <form:select path="specialization" id="specialization">
            <form:option value="" label="Select Specialization" />
            <form:option value="CSE" label="CSE" />
            <form:option value="ECE" label="ECE" />
            <form:option value="MECH" label="MECH" />
            <form:option value="CIVIL" label="CIVIL" />
        </form:select>
        <form:errors path="specialization" cssClass="error" /><br><br>

        <label for="phoneNumber">Phone Number:</label>
        <form:input path="phoneNumber" id="phoneNumber" />
        <form:errors path="phoneNumber" cssClass="error" /><br><br>

        <label for="percentage">Percentage:</label>
        <form:input path="percentage" id="percentage" type="number" />
        <form:errors path="percentage" cssClass="error" /><br><br>


        <button type="submit">Submit</button>
    </form:form>
</body>
</html>
