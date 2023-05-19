package web.clinic.clinicMember.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import web.clinic.clinicMember.entity.ClinicMember;

@Transactional
public interface ClinicMemberService {
	
	ClinicMember register(ClinicMember clinicMember);
	
	List<ClinicMember> findAll();
}
