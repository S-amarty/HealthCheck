<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- Add more application links as needed -->
    <!-- You can dynamically generate the application links based on your data -->
  </div>

  <div id="content">
    
  </div>
</div>

   <div id="logo">
    <img src="${pageContext.request.contextPath}/static/images/nuudayLogo.png" width="180px" height="80px">
  </div>

  <!-- <div id="sidebar-btn" onclick="toggleSidebar()">☰</div> -->

  <!-- <div class="extra-boxes">
    <button class="btn"> TEST </button>
    <button class="btn"> PROD </button>
  </div> -->

  <footer id="footer">
    <div style="text-align:center"> &copy; © Capgemini 2024. All rights reserved.</div>
  </footer>
</body>
</html>
<script>
    function showHealth(applicationName) {
      // In a real-world scenario, you would fetch health data for the selected application
      // Here, I'm just using placeholders for test and prod health
      const testHealth = Math.random() < 0.8 ? 'Healthy' : 'Unhealthy';
      const prodHealth = Math.random() < 0.8 ? 'Healthy' : 'Unhealthy';

      const healthStatusDiv = document.getElementById('healthStatus');
      healthStatusDiv.innerHTML = `
        <div class="application-name">${applicationName}</div>
        <div class="test-health">Test Health: ${testHealth}</div>
        <div class="prod-health">Prod Health: ${prodHealth}</div>
      `;
    }

    // function toggleSidebar() {
    //   const sidebar = document.getElementById('sidebar');
    //   const content = document.getElementById('content');
    //   sidebar.style.width = sidebar.style.width === '250px' ? '0' : '250px';
    //   content.style.marginLeft = content.style.marginLeft === '250px' ? '0' : '250px';
    // }
  </script>
