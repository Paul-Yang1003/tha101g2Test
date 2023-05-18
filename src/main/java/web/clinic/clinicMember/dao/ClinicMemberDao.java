package web.clinic.clinicMember.dao;

import core.dao.CoreDao;
import web.clinic.clinicMember.entity.ClinicMember;

public interface ClinicMemberDao extends CoreDao<ClinicMember, Integer>{
	
	ClinicMemberDao selectByClinicName(String clinicName);
	
	ClinicMemberDao selectForLogin(String clinicEmail, String clinicPassword);
}
