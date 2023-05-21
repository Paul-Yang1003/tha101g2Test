package web.clinic.clinicMember.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import core.util.CommonUtil;
import web.clinic.clinicMember.entity.ClinicMember;
import web.clinic.clinicMember.service.ClinicMemberService;

@WebServlet("/clinicMember/FindAllServlet")
public class FindAllServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ClinicMemberService service;
	
	@Override
	public void init() throws ServletException {
		service = CommonUtil.getBean(getServletContext(), ClinicMemberService.class);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ClinicMember> list;
		list = service.findAll();
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);
		resp.getWriter().write(jsonStr);
	}
}
