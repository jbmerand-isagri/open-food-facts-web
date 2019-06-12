<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" import="java.util.List, java.util.ArrayList, java.util.Map, java.util.HashMap"%>

<!DOCTYPE html>
<html lang="fr">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<!-- css dependencies -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Off-web - rechercher</title>
</head>

<body class="bg-light">
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="http://localhost:8080/off-web">Off-web</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="http://localhost:8080/off-web/rechercher">Rechercher <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="http://localhost:8080/off-web/ajouter">Ajouter</a>
					</li>
					<%-- <li class="nav-item">
						<a class="nav-link disabled" href="#">Autre</a>
					</li> --%>
				</ul>
			</div>
		</nav>
	</header>
	<main class="p-5">
		<section class="p-2 border border-light rounded bg-white shadow mb-3">

			<h2 class="text-dark text-center m-3">Rechercher des produits</h2>
			<form method="GET" action="http://localhost:8080/off-web/rechercher/resultats">
				<div class="form-group">
					<label for="marqueSelect">Marque</label>
					<select class="form-control" id="categorieSelect" name="marqueSelect" aria-describedby="marqueHelp">
						<% Map<Integer, String> mapMarques = (Map<Integer, String>)request.getAttribute("mapDesMarques"); %>
						<% for(Map.Entry ligne : mapMarques.entrySet()) { %>
							<option value="<%= ligne.getKey() %>"><%= ligne.getValue() %></option>
						<% } %>
						<option value="" selected></option>
					</select>
					<small id="marqueHelp" class="form-text text-muted">Sélectionner la marque du produit (laisser vide si inconnue).</small>
				</div>
				<div class="form-group">
					<label for="categorieSelect">Catégorie</label>
					<select class="form-control" id="categorieSelect" name="categorieSelect" aria-describedby="marqueHelp">
						<!-- TODO: Mettre ici les options parmi celles dans la bdd. -->
						<% Map<Integer, String> mapCategories = (Map<Integer, String>)request.getAttribute("mapDesCategories"); %>
						
						<% for(Map.Entry ligne : mapCategories.entrySet()) { %>
							<option value="<%= ligne.getKey() %>"><%= ligne.getValue() %></option>
						<% } %>
						<option value="" selected></option>
					</select>
					<small id="categorieHelp" class="form-text text-muted">Sélectionner la catégorie du produit (laisser vide si inconnue).</small>
				</div>
				<div class="form-group">
					<label for="nomInput">Nom</label>
					<input type="text" class="form-control" id="nomInput" name="nomInput" aria-describedby="nomHelp"
						placeholder="Crème aux oeufs">
					<small id="nomHelp" class="form-text text-muted">Entrer le nom du produit.</small>
				</div>
				<!-- TODO: Mettre ici choix d'un grade nutritionnel (select) parmi ceux de la bdd. -->
				<div class="form-group">
					<label for="gradeSelect">Grade nutritionnel</label>
					<select class="form-control" id="gradeSelect" name="gradeSelect" aria-describedby="gradeHelp">
						<!-- TODO: Mettre ici les options parmi celles dans la bdd. -->
						<% List<String> listeGrades = (List<String>)request.getAttribute("listeDesGrades"); %>
						<% for(String donnee : listeGrades) { %>
							<option value="<%= donnee %>"><%= donnee.toUpperCase() %></option>
						<% } %>
						<option value="" selected></option>
					</select>
					<small id="gradeHelp" class="form-text text-muted">Sélectionner le grade de qualité du produit (laisser vide si inconnu).</small>
				</div>
				<div class="form-group">
					<label>Energie</label>
					<div class="d-flex">
						<input type="number" step="0.01" class="form-control" id="energieMinInput" name="energieMinInput" placeholder="min">
						<input type="number" step="0.01" class="form-control" id="energieMaxInput" name="energieMaxInput" placeholder="max">
					</div>
				</div>
				<div class="form-group">
					<label>Graisse</label>
					<div class="d-flex">
						<input type="number" step="0.01" class="form-control" id="graisseMinInput" name="graisseMinInput" placeholder="min">
						<input type="number" step="0.01" class="form-control" id="graisseMaxInput" name="graisseMaxInput" placeholder="max">
					</div>
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-dark p-3">Rechercher</button>
				</div>
			</form>
		</section>
	</main>


	<!-- js dependencies -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
	</script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
	</script>
</body>

</html>