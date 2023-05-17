package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import core.config.AppConfig;
import web.member.dao.MemberDao;
import web.member.entity.Member;
import web.member.service.MemberService;

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
		MemberService memberService = applicationContext.getBean(MemberService.class);
		memberService.findAll().forEach(member -> System.out.println(member.getNickname()));
		((ConfigurableApplicationContext) applicationContext).close();

	}
}
