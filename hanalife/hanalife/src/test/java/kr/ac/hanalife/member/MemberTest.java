package kr.ac.hanalife.member;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.dao.MemberDAO;
import kr.ac.hanalife.member.service.MemberService;
import kr.ac.hanalife.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
public class MemberTest {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Ignore
	@Test
	public void sqlSession�׽�Ʈ() {
		assertNotNull(session);
	}
	
	@Ignore
	@Test
	public void ds�׽�Ʈ() {
		assertNotNull(ds);
	}
	
	@Ignore
	@Test
	public void MemberService�׽�Ʈ() {
		assertNotNull(memberService);
	}
	
	@Ignore
	@Test
	public void �α����׽�Ʈ() throws Exception {
		
		MemberVO member = new MemberVO();
		member.setId("test0101");
		member.setPassword("1111");
		
		MemberVO loginVO = memberService.loginMember(member);
				
		assertNotNull(loginVO);
		
	}
	
	@Test
	public void ȸ�������׽�Ʈ() throws Exception {
		
		MemberVO newMember = new MemberVO();
		newMember.setCusno(99998);
		newMember.setEmpno(11111);
		newMember.setId("hanalove");
		newMember.setPassword("1111");
		newMember.setName("���ϳ�");
		newMember.setHp("010-1478-1110");
		newMember.setPost("12345");
		newMember.setAddr("��õ�� ���� �漭��");
		newMember.setAge(22);
		newMember.setEmail("songhana@naver.com");
		
		memberService.signUpMember(newMember);
		
		assertNotNull(newMember);
	}
	
	@Ignore
	@Test
	public void ������ȣ�ҷ������׽�Ʈ() throws Exception {
		
		List<MemberVO> list = new ArrayList<>();
		
		list = memberDAO.membercusno();
		
		for(int i = 0;i<list.size();i++) {
			System.out.println(list);
		}
		
		assertNotNull(list);
	}
	
	@Ignore
	@Test
	public void �ߺ����̵�üũ�׽�Ʈ() throws Exception{
		 MemberVO member = memberDAO.checkid("test0101");
		 
		 assertNotNull(member);
	}
	
	@Ignore
	@Test
	public void ����������Ȯ��() throws Exception{
		MemberVO member = memberDAO.myPageProfile("test0101");
		
		assertNotNull(member);
	}
	
	@Test
	public void ����������ϴ»��Ȯ��() throws Exception {
		EmployeeVO member = memberDAO.myChargedStaff(71234);
		
		assertNotNull(member);
	}

}