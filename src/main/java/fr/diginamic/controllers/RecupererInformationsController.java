package fr.diginamic.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe qui récupère l'utilisateur connecté.
 */
@WebServlet(urlPatterns = "/recuperer/*")
public class RecupererInformationsController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {

		// Récupérer une valeur stockée
		Map utilisateur = (Map) req.getAttribute("utilisateur1");

		StringBuilder sbHtml = new StringBuilder("<h1>Utilisateur connecté</h1>").append("<ul><li>utilisateur : ")
				.append(utilisateur.get(1)).append("</li></ul>");

		rep.getWriter().write(sbHtml.toString());
	}

}