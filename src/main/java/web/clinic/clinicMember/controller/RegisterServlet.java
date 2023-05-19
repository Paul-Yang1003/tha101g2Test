package web.clinic.clinicMember.controller;

import static core.util.CommonUtil.json2Pojo;
import static core.util.CommonUtil.writePojo2Json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.util.CommonUtil;
import web.clinic.clinicMember.entity.ClinicMember;
import web.clinic.clinicMember.service.ClinicMemberService;

@WebServlet("register")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ClinicMemberService service;
	
	@Override
	public void init() throws ServletException {
		service = CommonUtil.getBean(getServletContext(), ClinicMemberService.class);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClinicMember clinicMember = json2Pojo(req, ClinicMember.class);
		clinicMember = service.register(clinicMember);
		writePojo2Json(resp, clinicMember);
	}
}
