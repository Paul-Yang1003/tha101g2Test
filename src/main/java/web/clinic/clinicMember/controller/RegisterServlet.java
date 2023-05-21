package web.clinic.clinicMember.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.util.CommonUtil;
import web.clinic.clinicMember.entity.ClinicMember;
import web.clinic.clinicMember.service.ClinicMemberService;

@WebServlet("/clinicMember/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClinicMemberService service;

	@Override
	public void init() throws ServletException {
		service = CommonUtil.getBean(getServletContext(), ClinicMemberService.class);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ClinicMember clinicMember = json2Pojo(req, ClinicMember.class);
//		if (clinicMember == null) {
//			clinicMember = new ClinicMember();
//			writePojo2Json(resp, clinicMember);
//			return;
//		}
//		clinicMember = service.register(clinicMember);
//		writePojo2Json(resp, clinicMember);

//		可執行		
		ClinicMember clinicMember = new ClinicMember();
		clinicMember.setClinicName(req.getParameter("clinicName"));
		clinicMember.setClinicPrincipal(req.getParameter("clinicPrincipal"));
		clinicMember.setClinicEmail(req.getParameter("clinicEmail"));
		clinicMember.setClinicPassword(req.getParameter("clinicPassword"));
		clinicMember.setClinicPhone(req.getParameter("clinicPhone"));
		clinicMember.setClinicAddress(req.getParameter("clinicAddress"));
		clinicMember.setClinicService(req.getParameter("clinicService"));
		
		service.register(clinicMember);
	}

}
