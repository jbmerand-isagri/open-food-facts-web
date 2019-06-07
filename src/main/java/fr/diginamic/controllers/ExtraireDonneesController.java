package fr.diginamic.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe qui définit un utilisateur.
 */
@WebServlet(urlPatterns = "/extraire/*")
public class ExtraireDonneesController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {

		Map<Integer, String> user1 = new HashMap<>();
		user1.put(1, "John");

		// Stocker un utilisateur
		req.setAttribute("utilisateur1", user1);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/recuperer");
		dispatcher.forward(req, rep);

	}
}