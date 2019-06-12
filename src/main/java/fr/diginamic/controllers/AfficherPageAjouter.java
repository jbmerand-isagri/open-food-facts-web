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

/**
 * Servlet chargeant la page d'ajout d'un produit dans la base de données.
 */
@WebServlet(urlPatterns = "/ajouter")
public class AfficherPageAjouter extends HttpServlet {

	/** SERVICE_LOG : Logger */
	private static final Logger SERVICE_LOG = LoggerFactory.getLogger(AfficherPageAjouter.class);

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

		request.getRequestDispatcher("/WEB-INF/ajouter.jsp").forward(request, response);
	}
}
