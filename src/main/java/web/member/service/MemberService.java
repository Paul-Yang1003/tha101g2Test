package web.member.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import core.service.CoreService;
import web.member.entity.Member;

@Transactional
public interface MemberService extends CoreService {

	Member register(Member member);

	Member login(Member member);

	Member edit(Member member);

	List<Member> findAll();

	boolean remove(Integer id);

	boolean save(Member member);
}