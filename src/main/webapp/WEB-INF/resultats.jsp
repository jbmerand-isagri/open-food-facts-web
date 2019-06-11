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
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css'/>
	<title>Off-web - résultats</title>
</head>

<body class="bg-light">
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">Off-web</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Link</a>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Dropdown
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Action</a>
							<a class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div>
					</li>
					<li class="nav-item">
						<a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>

	<main class="p-5">
		<section class="p-2 border border-light rounded bg-white shadow mb-3">
			<h3 class="text-dark text-center m-3">Résultats de la recherche</h2>
				<!-- ID / NOM / CATEGORIE / MARQUE / GRADE / ENERGIE / GRAISSE / SUCRE / FIBRE / PROTEINE / SEL -->
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">NOM</th>
							<th scope="col">CATEGORIE</th>
							<th scope="col">MARQUE</th>
							<th scope="col">GRADE</th>
							<th scope="col">ENERGIE</th>
							<th scope="col">GRAISSE</th>
							<th scope="col">SUCRE</th>
							<th scope="col">FIBRE</th>
							<th scope="col">PROTEINE</th>
							<th scope="col">SEL</th>
                            <th scope="col"><i class="fas fa-edit"></i></th>
                            <th scope="col"><i class="fas fa-trash-alt"></i></th>
						</tr>
					</thead>
					<tbody>
                        <tr>
                            <td><a href="#" data-index="null">@mdo</a></td>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>@mdo</td>
                            <td>@mdo</td>
                            <td>@mdo</td>
                            <td>@mdo</td>
                            <td>@mdo</td>
                            <td>@mdo</td>
                            <td><i class="fas fa-edit"></i></td>
                            <td><i class="fas fa-trash-alt"></i></td>
                        </tr>
					</tbody>
				</table>
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