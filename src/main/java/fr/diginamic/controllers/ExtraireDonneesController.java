package fr.diginamic.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/extraire/*")
public class ExtraireDonneesController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
		// Récupérer la session existante ou création d'une session
		HttpSession session = req.getSession(true);

		Map<Integer, String> user1 = new HashMap<>();
		user1.put(1, "John");

		// Stocker un utilisateur
		session.setAttribute("utilisateur1", user1);

		// Durée d'inactivité avant invalidation de la session
		session.setMaxInactiveInterval(10000);

		rep.getWriter().write("<a href='http://localhost:8080/off-web/cookies'>Infos cookies.</a>");

	}
}