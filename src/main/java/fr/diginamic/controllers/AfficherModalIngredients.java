package fr.diginamic.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

import fr.diginamic.dao.IngredientDao;
import fr.diginamic.exception.TechnicalException;
import fr.diginamic.utils.ConnectionUtils;

/**
 * Servlet pour insérer la liste des ingrédients dans la modale de la page des
 * résultats.
 */
@WebServlet(urlPatterns = "/rechercher/resultats/ingredients")
public class AfficherModalIngredients extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(AfficherModalIngredients.class);

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

		Integer idDuProduit = Integer.parseInt(request.getParameter("id"));

		IngredientDao ingredientDao = new IngredientDao();
		List<String> listeDesIngredients = ingredientDao.recupererIngredientsDUnProduit(idDuProduit);

		String json = new Gson().toJson(listeDesIngredients);

		response.setCharacterEncoding("utf8");
		response.getWriter().write(json.toString());
	}

}
