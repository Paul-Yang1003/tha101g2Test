package web.clinic.clinicMember.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import web.clinic.clinicMember.dao.ClinicMemberDao;
import web.clinic.clinicMember.entity.ClinicMember;

@Repository
public class ClinicMemberDaoImpl implements ClinicMemberDao{
	
	@PersistenceContext
	private Session session;
	
	@Override
	public int insert(ClinicMember clinicMember) {
		session.persist(clinicMember);
		return 1;
	}

	@Override
	public int deleteById(Integer clinicId) {
		ClinicMember clinicMember = session.load(ClinicMember.class, clinicId);
		session.remove(clinicMember);
		return 1;
	}

	@Override
	public int update(ClinicMember pojo) {
		return 0;
	}

	@Override
	public ClinicMember selectById(Integer id) {
		return null;
	}

	@Override
	public List<ClinicMember> selectAll() {
		return null;
	}

	@Override
	public ClinicMemberDao selectByClinicName(String clinicName) {
		return null;
	}

	@Override
	public ClinicMemberDao selectForLogin(String clinicEmail, String clinicPassword) {
		return null;
	}

}
