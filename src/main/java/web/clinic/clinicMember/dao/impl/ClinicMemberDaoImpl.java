package web.clinic.clinicMember.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import web.clinic.clinicMember.dao.ClinicMemberDao;
import web.clinic.clinicMember.entity.ClinicMember;

@Repository
public class ClinicMemberDaoImpl implements ClinicMemberDao {

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
	public int update(ClinicMember clinicMember) {
		final StringBuilder hql = new StringBuilder().append("UPDATE ClinicMember SET");
		final String password = clinicMember.getClinicPassword();
		if (password != null && !password.isEmpty()) {
			hql.append("clinicPassword = :clinicPassword,");
		}
		hql.append("clinicName = :clinicName,")
		   .append("clinicPrincipal = :clinicPrincipal,")
		   .append("clinicPhone = :clinicPhone,")
		   .append("clinicAddress = :clinicAddress,")
		   .append("clinicPhoto = :clinicPhoto,")
		   .append("clinicService = :clinicService,")
		   .append("clinicMemberLastUpdateDate = NOW() ")
		   .append("WHERE clinicEmail = :clinicEmail");
		Query query = session.createQuery(hql.toString());
		if (password != null && !password.isEmpty()) {
			query.setParameter("clinicPassword", clinicMember.getClinicPassword());
		}
		return query.setParameter("clinicName", clinicMember.getClinicName())
					.setParameter("clinicPrincipal", clinicMember.getClinicPrincipal())
					.setParameter("clinicPhone", clinicMember.getClinicPhone())
					.setParameter("clinicAddress", clinicMember.getClinicAddress())
					.setParameter("clinicPhoto", clinicMember.getClinicPhoto())
					.setParameter("clinicService", clinicMember.getClinicService())
					.setParameter("clinicEmail", clinicMember.getClinicEmail())
					.executeUpdate();
	}

	@Override
	public ClinicMember selectById(Integer id) {
		return session.get(ClinicMember.class, id);
	}

	@Override
	public List<ClinicMember> selectAll() {
		final String hql = "FROM ClinicMember ORDER BY clinicId";
		return session.createQuery(hql, ClinicMember.class).getResultList();
	}

	@Override
	public ClinicMember selectByClinicName(String clinicName) {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<ClinicMember> criteriaQuery = criteriaBuilder.createQuery(ClinicMember.class);
		Root<ClinicMember> root = criteriaQuery.from(ClinicMember.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("clinicName"), clinicName));
		return session.createQuery(criteriaQuery).uniqueResult();
	}

	@Override
	public ClinicMember selectForLogin(String clinicEmail, String clinicPassword) {
		final String sql = "select * from clinic_member "
				+ "where clinicEmail = :clinicEmail and clinicPassword = :clinicPassword";
		return session.createNativeQuery(sql, ClinicMember.class)
				.setParameter("clinicEmail", clinicEmail)
				.setParameter("clinicPassword", clinicPassword)
				.uniqueResult();
	}

}
