package kr.ac.hanalife.member.dao;

import java.util.List;

import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;

public interface MemberDAO {
	
	/**
	 * ���� �α����� �ϰ� �ϴ� ���
	 * @param member ȭ�鿡�� �Է��ϴ� member����
	 * @return DB�� ����Ǿ��ִ� member����
	 */
	MemberVO login(MemberVO member);
	
	/**
	 * ȸ�������� �ϰ� �ϴ� ���
	 * @param ���� �Է� ����
	 */
	void signUp(MemberVO member);
	
	/**
	 * ������ȣ�� �����ϱ� ���� ���
	 * @return DB�� �ִ� ���� ���� ��ȣ��
	 */
	List<MemberVO> membercusno();
	
	/**
	 * ���̵� �ߺ�üũ�� ���� ���
	 * @param id �Է��ϴ� ���̵�
	 * @return ���̵� �ִ� member, ������ null
	 */
	MemberVO checkid(String id);
	
	/**
	 * My Page���� �ڽ��� ������ ������ �� �� �ִ� ���
	 * @param ������ �ִ� loginVO�� id
	 * @return loginVO�� ��ü ����
	 */
	MemberVO myPageProfile(String id);
	
	/**
	 * My Page���� �ڽ��� ������� Ȯ���� �� �ִ� ���
	 * @param �ش������ ����ϰ� �ִ� ����� �����ȣ
	 * @return �������� ������ ��� ���
	 */
	EmployeeVO myChargedStaff(int empno);

}