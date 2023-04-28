<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Modifier un Videogame</title>
</head>
<body>
<div class="container mt-5">
<div class="card-body">
<form action="updateVideogame" method="post">
 <div class="form-group">
 <label class="control-label">ID Videogame :</label>
 <input type="text" name="idVideogame" value="${Videogame.idVideogame}"
readonly class="form-control"/>
 </div>
 <div class="form-group">
 <label class="control-label">Nom Videogame :</label>
 <input type="text" name="nomVideogame" value="${Videogame.nomVideogame}"
class="form-control"/>
 </div>
 <div class="form-group">
 <label class="control-label">Prix Videogame :</label>
 <input type="text" name="prixVideogame" value="${Videogame.prixVideogame}"
class="form-control"/>
 </div> 
 <div class="form-group">
 <label class="control-label"> Date création :</label>
 <fmt:formatDate pattern="yyyy-MM-dd" value="${Videogame.dateCreation}"
var="formatDate" />
 <input type="date" name="date" value="${formatDate}" class="formcontrol"/>
</div>
<div>
<button type="submit" class="btn btn-primary">Modifier</button>
</div>
</form>
</div>
<br/>
<br/>
<a href="ListeVideogames">Liste Videogames</a>
</div>
</body>
</html>