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

import com.simplilearn.la.dao.ClassDaoImpl;
import com.simplilearn.la.dao.Dao;
import com.simplilearn.la.dao.SubjectDaoImpl;
import com.simplilearn.la.dao.TeacherDaoImpl;
import com.simplilearn.la.entity.Address;
import com.simplilearn.la.entity.Class;
import com.simplilearn.la.entity.Subject;
import com.simplilearn.la.entity.Teacher;
import com.simplilearn.la.exception.LAException;

@WebServlet(urlPatterns =  {"/teachers/listTeachers","/teachers/showNewForm","/teachers/add",
		"/teachers/showEditForm","/teachers/update", "/teachers/delete","/teachers/showAssignTeacherForm","/teachers/assignTeacher"})
public class TeacherServlet extends HttpServlet {

	public static final String DEFAULT_PATH = "/teachers";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Dao<Teacher> dao = null;
	Dao<Subject> subjectDao = null;
	Dao<Class> classDao = null;
	
	
	public void init() {
		dao = new TeacherDaoImpl();
		subjectDao = new SubjectDaoImpl();
		classDao = new ClassDaoImpl();
		
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
				addTeacher(req, resp);
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
				updateTeacher(req, resp);
				break;
			}
			case DEFAULT_PATH + "/delete" : {
				deleteTeacher(req, resp);
				break;
			}
			case DEFAULT_PATH + "/showAssignTeacherForm" : {
				showAssignTeacherForm(req, resp);
				break;
			}
			case DEFAULT_PATH + "/assignTeacher" : {
				assignTeacher(req, resp);
				break;
			}
			default:
				listTeachers(req, resp);
			} 
		}
		catch (SQLException | LAException exp) {
			throw new ServletException (exp);
		}
	}
	
	private void listTeachers(HttpServletRequest req, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		List<Teacher> teachers = dao.getAll();
		req.setAttribute("teachers", teachers);
		RequestDispatcher dispatcher = req.getRequestDispatcher("teachers_list.jsp");
		dispatcher.forward(req, response);
	
	}

	private void  showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("add-teacher.jsp");
		dispatcher.forward(req, resp);
	}

	private void  showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		Long teacherId = Long.parseLong(req.getParameter("teacherId"));
		Teacher teacher = dao.getById(teacherId);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("edit-teacher.jsp");
		req.setAttribute("teacher", teacher);
		dispatcher.forward(req, resp);
	}

	private void  showAssignTeacherForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		
		Long teacherId = Long.parseLong(req.getParameter("teacherId"));
		List<Class> classes = classDao.getAll();
		List<Subject> subjects = subjectDao.getAll();
		Teacher teacher = dao.getById(teacherId);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("assign-teacher.jsp");
		req.setAttribute("teacher", teacher);
		req.setAttribute("classes", classes);
		req.setAttribute("subjects", subjects);
		
		dispatcher.forward(req, resp);
	}

	private void addTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		
		Teacher teacher = getTeacherObj(req);
		
		dao.save(teacher);
		resp.sendRedirect("listTeachers");
		
	}

	private void assignTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {

		String teacherId = req.getParameter("teacherId");
		String classId = req.getParameter("classId");
		String subjectId = req.getParameter("subjectId");
		
		if (teacherId == null || classId == null || subjectId == null) throw new ServletException("Cannot assign teacher to the class.... Invalid Details provided !");
		long subjId = Long.parseLong(subjectId);
		long clsId = Long.parseLong(classId);
		long tchrId = Long.parseLong(teacherId);
		
		Teacher teacher = dao.getById(tchrId);
		Class cls = classDao.getById(clsId);
		Subject subject = subjectDao.getById(subjId);
		((TeacherDaoImpl)dao).assignTeacherToClass(cls, teacher, subject);

		resp.sendRedirect("listTeachers");
		
	}

	private Teacher getTeacherObj(HttpServletRequest req) {
		String id = req.getParameter("teacherId");
		String studentName = req.getParameter("name");
		String line1 = req.getParameter("line1");
		String line2 =req.getParameter("line2");
		String city =req.getParameter("city");
		String state =req.getParameter("state");
		String pincode = req.getParameter("pincode");
		String emailId =req.getParameter("emailId");
		String phoneNumber = req.getParameter("phoneNumber");
		Long teacherId = null;
		if (id != null) {
			teacherId = Long.parseLong(id);
		}
		Teacher teacher = new Teacher(teacherId, studentName, new Address(line1, line2, city, state, pincode), emailId, phoneNumber);
		return teacher;
	}

	private void updateTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		
		Teacher teacher = getTeacherObj(req);
		dao.update(teacher);
		resp.sendRedirect("listTeachers");
		
	}

	private void deleteTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, SQLException, IOException, LAException {
		Long teacherId = Long.parseLong(req.getParameter("teacherId"));

		dao.delete(teacherId);
		resp.sendRedirect("listTeachers");
		
	}

}
