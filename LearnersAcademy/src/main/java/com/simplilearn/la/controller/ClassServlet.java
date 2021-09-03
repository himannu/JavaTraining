package com.simplilearn.la.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.la.dao.ClassDaoImpl;
import com.simplilearn.la.entity.Class;
import com.simplilearn.la.entity.Subject;
import com.simplilearn.la.exception.LAException;

@WebServlet(urlPatterns =  {"/classes/listClasses","/classes/showNewForm","/classes/add",
		"/classes/showEditForm","/classes/update", "/classes/delete","/classes/addSubjects","/classes/listSubjects","/classes/showReport"})
public class ClassServlet extends HttpServlet {

	public static final String DEFAULT_PATH = "/classes";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ClassDaoImpl dao = null;
	
	public void init() {
		dao = new ClassDaoImpl();
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
				addClass(req, resp);
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
				updateClass(req, resp);
				break;
			}
			case DEFAULT_PATH + "/delete" : {
				deleteClass(req, resp);
				break;
			}
			case DEFAULT_PATH + "/addSubjects" : {
				addSubjects(req, resp);
				break;
			}
			case DEFAULT_PATH + "/listSubjects" : {
				listSubjects(req, resp);
				break;
			}
			case DEFAULT_PATH + "/showReport" : {
				showReport(req, resp);
				break;
			}
			default:
				listClasses(req, resp);
			} 
		}
		catch (SQLException | LAException exp) {
			throw new ServletException (exp);
		}
	}
	
	private void listClasses(HttpServletRequest req, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		List<Class> classes = dao.getAll();
		req.setAttribute("classes", classes);
		RequestDispatcher dispatcher = req.getRequestDispatcher("classes_list.jsp");
		dispatcher.forward(req, response);
	
	}

	private void  showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("add-class.jsp");
		dispatcher.forward(req, resp);
	}

	private void  showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		Long classId = Long.parseLong(req.getParameter("classId"));
		Class cls = dao.getById(classId);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("edit-class.jsp");
		req.setAttribute("cls", cls);
		dispatcher.forward(req, resp);
	}

	private void addClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		
		String className = req.getParameter("className");
		String classDesc = req.getParameter("classDesc");
		Class schoolClass = new Class(className, classDesc);
		
		dao.save(schoolClass);
		
		resp.sendRedirect("listClasses");
		
	}

	
	private void updateClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		Long classId = Long.parseLong(req.getParameter("classId"));
		String className = req.getParameter("className");
		String classDesc = req.getParameter("classDesc");
		Class schoolClass = new Class(classId, className, classDesc);
		
		dao.update(schoolClass);
		
		resp.sendRedirect("listClasses");
		
	}

	private void deleteClass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		Long classId = Long.parseLong(req.getParameter("classId"));
		dao.delete(classId);
		resp.sendRedirect("listClasses");
		
	}

	private void addSubjects(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		String[] parameterValues = req.getParameterValues("subjs");
		// nothing to save so return
		if (parameterValues != null && parameterValues.length > 0) {
			List<String> subjectIds = Stream.of(parameterValues).collect(Collectors.toList());
			
			String classId = req.getParameter("classId");
			if (classId == null) throw new ServletException("Class Details cannot be empty! PLease contact administrator");
			Long clsId = Long.parseLong(classId);
			dao.addSubjects(subjectIds, clsId);
		}
		resp.sendRedirect("listClasses");
		
	}

	private void listSubjects(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		
		String classId = req.getParameter("classId");
		if (classId == null) throw new ServletException("Class Details cannot be empty! PLease contact administrator");
		Long clsId = Long.parseLong(classId);
		Class cls = dao.getById(clsId);
		List<Subject> listSubjectsNotInClass = dao.listSubjectsNotInClass(clsId);
		req.setAttribute("subjects", listSubjectsNotInClass);
		req.setAttribute("cls", cls);
		RequestDispatcher dispatcher = req.getRequestDispatcher("assign-subjects.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	private void showReport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		String classId = req.getParameter("classId");
		if (classId == null) throw new ServletException("Class Details cannot be empty! PLease contact administrator");
		Long clsId = Long.parseLong(classId);
		Class cls = dao.getClassReport(clsId);
		req.setAttribute("cls", cls);
		RequestDispatcher dispatcher = req.getRequestDispatcher("class-report.jsp");
		dispatcher.forward(req, resp);
	}
}


