package web.clinic.clinicMember.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.clinic.clinicMember.dao.ClinicMemberDao;
import web.clinic.clinicMember.entity.ClinicMember;
import web.clinic.clinicMember.service.ClinicMemberService;

@Service
public class ClinicMemberServiceImpl implements ClinicMemberService {
	@Autowired
	private ClinicMemberDao clinicMemberDao;

	@Transactional
	@Override
	public ClinicMember register(ClinicMember clinicMember) {
		clinicMemberDao.insert(clinicMember);
		return clinicMember;
	}

	@Override
	public List<ClinicMember> findAll() {
		return clinicMemberDao.selectAll();
	}

	@Override
	public boolean remove(Integer id) {
		return clinicMemberDao.deleteById(id) > 0;
	}

}
