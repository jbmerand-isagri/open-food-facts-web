package fr.diginamic.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.dao.ProduitDao;
import fr.diginamic.exception.TechnicalException;
import fr.diginamic.model.Produit;
import fr.diginamic.utils.ConnectionUtils;

@WebServlet(urlPatterns = "/rechercher/resultats")
public class AfficherResultatsRechercheController extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(AfficherResultatsRechercheController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// initialisation du driver de la base de données
		try {
			String driverName = ConnectionUtils.getDriverName();
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			SERVICE_LOG.error("Impossible de charger le driver.", e1);
			throw new TechnicalException("Impossible de charger le driver.", e1);
		}

		// récupération des paramètres de la recherche
		String marqueId = (request.getParameter("marqueSelect") != null) ? request.getParameter("marqueSelect") : "";
		String categorieId = (request.getParameter("categorieSelect") != null) ? request.getParameter("categorieSelect")
				: "";
		String produitNom = (request.getParameter("nomInput") != null) ? request.getParameter("nomInput") : "";
		String produitGrade = (request.getParameter("gradeSelect") != null) ? request.getParameter("gradeSelect") : "";
		String produitEnergieMin = (request.getParameter("energieMinInput") != null)
				? request.getParameter("energieMinInput")
				: "";
		String produitEnergieMax = (request.getParameter("energieMaxInput") != null)
				? request.getParameter("energieMaxInput")
				: "";
		String produitGraisseMin = (request.getParameter("graisseMinInput") != null)
				? request.getParameter("graisseMinInput")
				: "";
		String produitGraisseMax = (request.getParameter("graisseMaxInput") != null)
				? request.getParameter("graisseMaxInput")
				: "";

		// stockage des paramètres dans une map
		Map<String, String> mapDesCriteres = new HashMap<>();
		System.out.println("cateID = " + categorieId);

		if (marqueId != null && !marqueId.isEmpty() && !marqueId.contentEquals("null"))
			mapDesCriteres.put("PDT_MARQUE", marqueId);
		if (categorieId != null && !categorieId.isEmpty() && !categorieId.contentEquals("null"))
			mapDesCriteres.put("PDT_CATEGORIE", categorieId);
		if (produitNom != null && !produitNom.isEmpty() && !produitNom.contentEquals("null"))
			mapDesCriteres.put("PDT_NOM", produitNom);
		if (produitGrade != null && !produitGrade.isEmpty() && !produitGrade.contentEquals("null"))
			mapDesCriteres.put("PDT_NUTRITIONGRADE", produitGrade);
		if (produitEnergieMax != null && !produitEnergieMax.isEmpty() && !produitEnergieMax.contentEquals("null"))
			mapDesCriteres.put("PDT_ENERGIE_MAX", produitEnergieMax);
		if (produitEnergieMin != null && !produitEnergieMin.isEmpty() && !produitEnergieMin.contentEquals("null"))
			mapDesCriteres.put("PDT_ENERGIE_MIN", produitEnergieMin);
		if (produitGraisseMax != null && !produitGraisseMax.isEmpty() && !produitGraisseMax.contentEquals("null"))
			mapDesCriteres.put("PDT_GRAISSE_MAX", produitGraisseMax);
		if (produitGraisseMin != null && !produitGraisseMin.isEmpty() && !produitGraisseMin.contentEquals("null"))
			mapDesCriteres.put("PDT_GRAISSE_MIN", produitGraisseMin);

		// récupération des produits
		ProduitDao produitDao = new ProduitDao();
		List<Produit> listeDesProduits = produitDao.recupererProduits(mapDesCriteres);

		// affichage de resultats.jsp avec transmission de la liste des produits
		request.setAttribute("listeDesProduits", listeDesProduits);
		request.getRequestDispatcher("/WEB-INF/resultats.jsp").forward(request, response);
	}
}
