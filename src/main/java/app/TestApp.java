package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import core.config.AppConfig;
import web.clinic.clinicMember.service.ClinicMemberService;

public class TestApp {

	public static void main(String[] args) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Member member = session.get(Member.class, 1);
//		System.out.println(member.getNickname());
//		HibernateUtil.shutdown();

//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		MemberDao memberDao = applicationContext.getBean(MemberDao.class);
//		Member member = memberDao.selectById(1);
//		System.out.println(member.getNickname());
//		((ConfigurableApplicationContext) applicationContext).close();

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		ClinicMemberService clinicMemberService = applicationContext.getBean(ClinicMemberService.class);
		clinicMemberService.findAll().forEach(member -> System.out.println(member.getClinicName()));
		((ConfigurableApplicationContext) applicationContext).close();

	}
}
