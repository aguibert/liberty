package com.example.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/*")
public class TestServlet extends HttpServlet {
	
	@Resource(lookup = "jdbc/ds")
	DataSource ds;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ds.getConnection().close();
			resp.getWriter().println("Got a conneciton");
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}

}
