<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" import="java.util.List, java.util.ArrayList, java.util.Map, java.util.HashMap, fr.diginamic.model.Produit"%>
<% List<Produit> listeDesProduits = (List<Produit>)request.getAttribute("listeDesProduits"); %>

<!DOCTYPE html>
<html lang="fr">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<!-- css dependencies -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css'/>
	<title>Off-web - résultats</title>
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
				</ul>
			</div>
		</nav>
	</header>

	<main class="p-5">
		<section class="p-2 border border-light rounded bg-white shadow mb-3">
			<h3 class="text-dark text-center m-3">Résultats de la recherche</h2>
			<p>L'affichage des résultats est limité à 100 lignes.</p>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">NOM</th>
							<th scope="col">CATEGORIE</th>
							<th scope="col">MARQUE</th>
							<th scope="col">GRADE</th>
							<th scope="col">ENERGIE</th>
							<th scope="col">GRAISSE</th>
                            <th scope="col"><i class="fas fa-edit"></i></th>
                            <th scope="col"><i class="fas fa-trash-alt"></i></th>
						</tr>
					</thead>
					<tbody>
					<% for(Produit produit : listeDesProduits) { %>
                        <tr>
                            <td><%= produit.getNom() %><a onmouseover="" style="cursor: pointer;" data-toggle="modal" data-target="#myModal"><i class="nomProduit m-2 fas fa-info-circle" data-index="<%= produit.getId() %>"></i></a></td>
                            <td><%= produit.getCategorie() %></td>
                            <td><%= produit.getMarque() %></td>
                            <td><%= produit.getGrade().toUpperCase() %></td>
                            <td><%= produit.getEnergie() %></td>
                            <td><%= produit.getGraisse() %></td>
                            <td><i class="fas fa-edit"></i></td>
                            <td><i class="fas fa-trash-alt"></i></td>
                        </tr>
					<% } %>
					</tbody>
				</table>
		</section>
	</main>


	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<%-- <h4 class="modal-title">Modal Header</h4> --%>
				</div>
				<div class="modal-body">
					<p id="modal-body"></p>
				</div>
			</div>

		</div>
	</div>

	<!-- js dependencies -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
	</script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
	</script>

	<!-- my js code -->
	<script>

		// AFFICHER LA MODALE AVEC LES INGREDIENTS
		$(".nomProduit").click(event, () => {
			let elementId = event.target.getAttribute("data-index");
			console.log(elementId);

			// RECUPERER LES INGREDIENTS ET LES INSERER DANS LA MODAL (AJAX)
			$.ajax({
				url: "http://localhost:8080/off-web/rechercher/resultats/ingredients?id=" + elementId,
				dataType: 'json', // parses JSON
				success: function (result) {
					console.log(result);
					let html = "<h2>Ingredients</h2><ul>";
					result.forEach((ingredient) => {
						html += "<li>" + ingredient + "</li>";
					})
					html += "</ul>"
					
					$("#modal-body").html(html);
				},
				error: function (error) {
					console.log("Problème lors de la requête ajax.", error);
				}
			})
		});

		
	</script>
</body>

</html>