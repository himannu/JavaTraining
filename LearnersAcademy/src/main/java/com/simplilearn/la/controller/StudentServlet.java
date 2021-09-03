package com.simplilearn.la.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.la.dao.ClassDaoImpl;
import com.simplilearn.la.dao.Dao;
import com.simplilearn.la.dao.StudentDao;
import com.simplilearn.la.dao.StudentDaoImpl;
import com.simplilearn.la.entity.Address;
import com.simplilearn.la.entity.Class;
import com.simplilearn.la.entity.Student;
import com.simplilearn.la.exception.LAException;

@WebServlet(urlPatterns =  {"/students/showNewForm","/students/add",
		"/students/showEditForm","/students/update", "/students/delete","/students/listStudents"})
public class StudentServlet extends HttpServlet {

	public static final String DEFAULT_PATH = "/students";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Dao<Class> classDao = null;
	StudentDao studentDao = null;
	
	public void init() {
		classDao = new ClassDaoImpl();
		studentDao = new StudentDaoImpl();
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
				addOrUpdateStudent(req, resp);
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
				addOrUpdateStudent(req, resp);
				break;
			}
			case DEFAULT_PATH + "/delete" : {
				deleteStudent(req, resp);
				break;
			}
			default:
				listStudents(req, resp);
			} 
		}
		catch (SQLException | LAException exp) {
			throw new ServletException (exp);
		}
	}
	
	private void listStudents(HttpServletRequest req, HttpServletResponse response) 
			throws SQLException, ServletException, IOException, LAException {

		Long classId = null;
		
		// first check if we are getting class from request
		String clsId = req.getParameter("classId");
		if (clsId != null) {
			classId = Long.parseLong(clsId);	
		} else {
			// check if class is in session
			Object obj = req.getSession().getAttribute("cls");
			if (obj != null) {
				
				Class cla = (Class) obj;
				classId = cla.getClassId();
			} else {
				// didnt find the id in request or session so some prob.. throw error
				throw new ServletException("Class cannot be retrieved. Class Id is null");
			}
		}
		
		Class cls = classDao.getById(classId);

		List<Student> students = studentDao.getAll(classId);
		cls.setStudents(students.stream().collect(Collectors.toSet()));

		req.setAttribute("cls", cls);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("students-list.jsp");
		dispatcher.forward(req, response);
	
	}

	private void  showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		
		Long classId = Long.parseLong(req.getParameter("classId"));
		Class cls = classDao.getById(classId);
		req.setAttribute("cls", cls);
		RequestDispatcher dispatcher = req.getRequestDispatcher("add-student.jsp");
		dispatcher.forward(req, resp);

	}

	private void  showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {

		Long studentId = Long.parseLong(req.getParameter("studentId"));
		Student student = studentDao.getById(studentId);

		Long classId = Long.parseLong(req.getParameter("classId"));
		Class cls = classDao.getById(classId);
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("edit-student.jsp");
		req.setAttribute("student", student);
		req.setAttribute("cls", cls);
		dispatcher.forward(req, resp);

	}

	
	private void addOrUpdateStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {

		Long classId = Long.parseLong(req.getParameter("classId"));
		Class cls = classDao.getById(classId);

		String id = req.getParameter("studentId");
		String studentName = req.getParameter("name");
		String line1 = req.getParameter("line1");
		String line2 =req.getParameter("line2");
		String city =req.getParameter("city");
		String state =req.getParameter("state");
		String pincode = req.getParameter("pincode");
		String emailId =req.getParameter("emailId");
		String phoneNumber = req.getParameter("phoneNumber");

		Address address = new Address(line1, line2, city, state, pincode);
		Student student = null;
		
		if (id != null) {
			Long stuId = Long.parseLong(id);
			student = new Student(stuId, studentName, address, emailId, phoneNumber, cls);
			studentDao.update(student);
		} else {
			student = new Student(null, studentName, address, emailId, phoneNumber, cls);
			studentDao.save(student);
		}
		
		req.getSession().setAttribute("cls", cls);
		
		resp.sendRedirect("listStudents");
		
	}


	private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		Long studentId = Long.parseLong(req.getParameter("studentId"));

		studentDao.delete(studentId);
		Long classId = Long.parseLong(req.getParameter("classId"));
		Class cls = classDao.getById(classId);
		
		req.getSession().setAttribute("cls", cls);
		resp.sendRedirect("listStudents");
		
	}

}
