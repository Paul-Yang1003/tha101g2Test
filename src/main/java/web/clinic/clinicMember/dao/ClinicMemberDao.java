package web.clinic.clinicMember.dao;

import core.dao.CoreDao;
import web.clinic.clinicMember.entity.ClinicMember;

public interface ClinicMemberDao extends CoreDao<ClinicMember, Integer>{
	
	ClinicMember selectByClinicName(String clinicName);
	
	ClinicMember selectForLogin(String clinicEmail, String clinicPassword);
}
