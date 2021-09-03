package com.simplilearn.la.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.la.dao.Dao;
import com.simplilearn.la.dao.SubjectDaoImpl;
import com.simplilearn.la.entity.Subject;
import com.simplilearn.la.exception.LAException;

@WebServlet(urlPatterns =  {"/subjects/listSubjects","/subjects/showNewForm","/subjects/add",
		"/subjects/showEditForm","/subjects/update", "/subjects/delete"})
public class SubjectServlet extends HttpServlet {

	public static final String DEFAULT_PATH = "/subjects";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Dao<Subject> dao = null;
	
	public void init() {
		dao = new SubjectDaoImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		try {
			switch (action) {
			case DEFAULT_PATH + "/add" : {
				addSubject(req, resp);
				break;
			}
			case DEFAULT_PATH + "/showNewForm" : {
				showNewForm(req, resp);
				break;
			}
			case DEFAULT_PATH + "/showEditForm" : {
				showEditForm(req, resp);
				break;
			}
			case DEFAULT_PATH + "/update" : {
				updateSubject(req, resp);
				break;
			}
			case DEFAULT_PATH + "/delete" : {
				deleteSubject(req, resp);
				break;
			}
			default:
				listSubjects(req, resp);
			} 
		}
		catch (SQLException | LAException exp) {
			throw new ServletException (exp);
		}
	}
	
	private void listSubjects(HttpServletRequest req, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		
		List<Subject> subjects = dao.getAll();
		req.setAttribute("subjects", subjects);
		RequestDispatcher dispatcher = req.getRequestDispatcher("subjects_list.jsp");
		dispatcher.forward(req, response);
	
	}
	
	private void  showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("add-subject.jsp");
		dispatcher.forward(req, resp);
	}

	private void  showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		Long subjectId = Long.parseLong(req.getParameter("subjectId"));
		Subject subject = dao.getById(subjectId);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("edit-subject.jsp");
		req.setAttribute("subject", subject);
		dispatcher.forward(req, resp);
	}

	private void addSubject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		
		String subjectName = req.getParameter("subjectName");
		String subjectType = req.getParameter("subjectType");
		Subject subject = new Subject(subjectName, subjectType);
		
		dao.save(subject);
		resp.sendRedirect("listSubjects");
		
	}

	private void updateSubject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		Long subjectId = Long.parseLong(req.getParameter("subjectId"));
		String subjectName = req.getParameter("subjectName");
		String subjectType = req.getParameter("subjectType");
		Subject subject = new Subject(subjectId, subjectName, subjectType);
		
		dao.update(subject);
		resp.sendRedirect("listSubjects");
		
	}

	private void deleteSubject(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		Long subjectId = Long.parseLong(req.getParameter("subjectId"));

		dao.delete(subjectId);
		resp.sendRedirect("listSubjects");
		
	}

}
