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
import org.springframework.test.context.web.WebAppConfiguration;

import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.logger.LogBack;
import kr.ac.hanalife.member.dao.MemberDAO;
import kr.ac.hanalife.member.service.MemberService;
import kr.ac.hanalife.member.vo.MemberVO;

@WebAppConfiguration
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
	
	@Autowired
	private LogBack log;
	
	
	@Ignore
	@Test
	public void sqlSession테스트() {
		assertNotNull(session);
	}
	
	@Ignore
	@Test
	public void ds테스트() {
		assertNotNull(ds);
	}
	
	@Ignore
	@Test
	public void log테스트() {
		assertNotNull(log);
	}
	
	@Ignore
	@Test
	public void logAspect테스트() {
		
	}
	
	@Ignore
	@Test
	public void MemberService테스트() {
		assertNotNull(memberService);
	}
	
	@Ignore
	@Test
	public void 로그인테스트() throws Exception {
		
		MemberVO member = new MemberVO();
		member.setId("test0101");
		member.setPassword("1111");
		
		MemberVO loginVO = memberService.loginMember(member);
				
		assertNotNull(loginVO);
		
	}
	
	@Ignore
	@Test
	public void 회원가입테스트() throws Exception {
		
		MemberVO newMember = new MemberVO();
		newMember.setCusno(99998);
		newMember.setEmpno(11111);
		newMember.setId("hanalove");
		newMember.setPassword("1111");
		newMember.setName("송하나");
		newMember.setHp("010-1478-1110");
		newMember.setPost("12345");
		newMember.setAddr("인천시 서구 경서동");
		newMember.setAge(22);
		newMember.setEmail("songhana@naver.com");
		
		memberService.signUpMember(newMember);
		
		assertNotNull(newMember);
	}
	
	@Ignore
	@Test
	public void 고객번호불러오기테스트() throws Exception {
		
		List<MemberVO> list = new ArrayList<>();
		
		list = memberDAO.membercusno();
		
		for(int i = 0;i<list.size();i++) {
			System.out.println(list);
		}
		
//		log.logBefore();
//		log.logException(exception);
		assertNotNull(list);
	}
	
	@Ignore
	@Test
	public void 중복아이디체크테스트() throws Exception{
		 MemberVO member = memberDAO.checkid("test0101");
		 
		 assertNotNull(member);
	}
	
	@Ignore
	@Test
	public void 프로필정보확인() throws Exception{
		MemberVO member = memberDAO.myPageProfile("test0101");
		
		assertNotNull(member);
	}
	
	@Ignore
	@Test
	public void 고객을담당하는사원확인() throws Exception {
		EmployeeVO member = memberDAO.myChargedStaff(71234);
		
		assertNotNull(member);
	}
	
	@Ignore
	@Test
	public void 고객번호로고객정보확인테스트() throws Exception {
		MemberVO member = memberDAO.selectByCusno(10001);
		
		
		
		assertNotNull(member);
	}
	
	@Ignore
	@Test
	public void 고객회원정보수정테스트() throws Exception {
		
		MemberVO member = new MemberVO();
		
		member.setId("hanalove");
		member.setPassword("2222");
		member.setName("송하나");
		member.setHp("010-0101-2098");
		member.setPost("87654");
		member.setAddr("광명시 철산동");
		member.setEmail("hanalove@naver.com");
		
		memberDAO.modifyMyInfo(member);
		
	}
	
	@Ignore
	@Test
	public void 회원탈퇴테스트() throws Exception {
		MemberVO member = new MemberVO();
		
		member.setId("hanalove");
		member.setPassword("2222");
		
		memberDAO.deleteMyInfo(member);
	}
	
	@Ignore
	@Test
	public void 이메일인증테스트() throws Exception {
		MemberVO member = new MemberVO();
		
		member.setId("test0101");
		member.setEmail("koo@naver.com");
		
		assertNotNull(memberDAO.authentication(member));
		
	}

}
