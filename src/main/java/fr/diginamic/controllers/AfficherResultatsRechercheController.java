package fr.diginamic.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.exception.TechnicalException;
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

		/**
		 * ProduitDao produitDao = new ProduitDao(); List<String> gradesList =
		 * produitDao.recupererDifferentsGradesNutritionnels();
		 * 
		 * CategorieDao categorieDao = new CategorieDao(); Map<Integer, String>
		 * categoriesMap = categorieDao.recupererToutesCategories();
		 * 
		 * MarqueDao marqueDao = new MarqueDao(); Map<Integer, String> marquesMap =
		 * marqueDao.recupererToutesMarques();
		 * 
		 * System.out.println(gradesList.get(0)); SERVICE_LOG.info("Chargement des
		 * données utiles de la bdd."); System.out.println("Chargement des données
		 * utiles de la bdd.");
		 * 
		 * request.setAttribute("listeDesGrades", gradesList);
		 * request.setAttribute("mapDesCategories", categoriesMap);
		 * request.setAttribute("mapDesMarques", marquesMap);
		 * 
		 **/
		request.getRequestDispatcher("/WEB-INF/resultats.jsp").forward(request, response);
	}
}
