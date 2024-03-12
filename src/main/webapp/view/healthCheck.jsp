<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*,java.util.*,javax.servlet.*, org.springframework.http.HttpStatus" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Health Monitoring</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css">
  
</head>
<body>
  <div id="sidebar">
    <a href="#"> <img src="${pageContext.request.contextPath}/static/images/logo.png" width="150px" height="100px" style="vertical-align:top;margin:-35px 0px"/></a>
    <c:forEach var="applicationMap" items="${applicationMap}">
      <a href="${pageContext.request.contextPath}/healthCheck" >${applicationMap.value}</a>
    </c:forEach>
  </div>
  applicationDetailDTOList
  <div class="container">
    <h2>EAIFTP</h2>
    <table>
      <tr>
        <th>Environment</th>
        <c:forEach var="applicationDetailDTO" items="${applicationDetailDTOList}">
          <th>${applicationDetailDTO.application_type}</th>
        </c:forEach>
        <th>Database</th>
        <th>Date and Time</th>
        <th>History Report</th>
      </tr>
      <tr>
        <td>Test</td>
        <c:forEach var="status" items="${statusCodeList}">
          <td class="${status.value() == 200 ? 'status-ok' : 'status-not-ok'}">${status}</td>
        </c:forEach>
        <td class="status-ok">OK</td>
        <% Date date = new Date();
         out.print( "<td align = \"center\">" +date.toString()+"</td>"); %>
         <td> <input type="button" value="Download" onclick="downloadReport('TEST')"></td>
      </tr>
      <tr>
        <td>Production</td>
        <c:forEach var="status" items="${statusCodeList}">
          <td class="${status.value() == 200 ? 'status-ok' : 'status-not-ok'}">${status}</td>
        </c:forEach>
        <td class="status-ok">OK</td>
        <% out.print( "<td align = \"center\">" +date.toString()+"</td>"); %>
        <td><input type="button" value="Download" onclick="downloadReport('PROD')"></td>
      </tr>
    </table>
  </div>

  <div id="logo">
    <img src="${pageContext.request.contextPath}/static/images/nuudayLogo.png" width="180px" height="80px">
  </div>
  <footer id="footer">
    <div style="text-align:center"> &copy;© Capgemini 2024. All rights reserved.</div>
  </footer>
 
</body>
</html>

<style>
      td.status-ok {
      color: green;
    }

    td.status-not-ok {
      color: red;
    }
  table {
    width: 70%;
    border-collapse: collapse;
    margin: 150px 80px 20px auto;
    padding: 50px;
  }

  th, td {
    border: 1px solid #ffffff;
    padding: 8px;
    text-align: left;
  }

  th {
    background-color: #0071ae;
    color: rgb(255, 255, 255);
  }

  td {
    background-color: #000000;
  }
</style>

<script>
  function downloadReport(environmentType) {
    window.location.href = '${pageContext.request.contextPath}/downloadReport/' + environmentType;
  }
</script>
