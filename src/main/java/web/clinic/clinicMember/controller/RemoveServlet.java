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
import entity.Core;
import web.clinic.clinicMember.entity.ClinicMember;
import web.clinic.clinicMember.service.ClinicMemberService;

@WebServlet("/clinicMember/RemoveServlet")
public class RemoveServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ClinicMemberService service;
	
	@Override
	public void init() throws ServletException {
		service = CommonUtil.getBean(getServletContext(), ClinicMemberService.class);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final Integer id = json2Pojo(req, ClinicMember.class).getClinicId();
		final Core core = new Core();
		if (id == null) {
			core.setMessage("無此Id");
			core.setSuccessful(false);
		} else {
			core.setSuccessful(service.remove(id));
		}
		writePojo2Json(resp, core);
	}
}
