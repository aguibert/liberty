package com.agg.tron.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agg.tron.logging.Logger;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -2981073427509024609L;
	
	@EJB
	private DatabaseBean dbBean;
	
	@EJB
	private UserSessionBean userSession;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		String userID = req.getUserPrincipal().getName();
		
		Logger.log("User " + userID + " is attempting to login.");
		
		String playerName = dbBean.getPlayerName(userID);
		if(playerName == null) {
			playerName = req.getParameter("username");
			if(playerName != null) {
				dbBean.registerPlayer(userID, playerName);
			}
		}
		
		if(playerName == null) {
			Logger.log("User " + userID + " has not registered yet.");
			resp.sendRedirect("register.xhtml");
		} else {
			Logger.log("User " + userID + " is logging in as " + playerName);
			userSession.setDisplayName(playerName);
			userSession.setLoggedIn(true);
			resp.sendRedirect("game.xhtml");
		}
	}
}
