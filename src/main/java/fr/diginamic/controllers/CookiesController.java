/**
 * 
 */
package fr.diginamic.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
@WebServlet(urlPatterns = "/cookies/*")
public class CookiesController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
		// Récupérer la session existante ou création d'une session
		HttpSession session = req.getSession(true);
		// Récupérer une valeur stockée
		Object utilisateur = session.getAttribute("utilisateur1");
		// Invalider une session
		// session.invalidate();

		// Identifiant de la session
		String sessionID = session.getId();
		rep.getWriter().write("<h1>Utilisateur connecté</h1>" + "<ul>" + "<li>utilisateur : " + utilisateur + "</li>"
				+ "<li>sessionID : " + sessionID + "</li>" + "</ul>");

	}
}
