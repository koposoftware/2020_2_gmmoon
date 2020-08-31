package kr.ac.hanalife.employee.dao;

import java.util.List;

import kr.ac.hanalife.consulting.vo.ConsultingVO;
import kr.ac.hanalife.employee.vo.EmployeeVO;
import kr.ac.hanalife.member.vo.MemberVO;

public interface EmployeeDAO {
	
	/**
	 * ��� �α����� �ϰ� �ϴ� ���
	 * @param employeeVO ȭ�鿡�� �Է��ϴ� employee ����
	 * @return DB�� ����Ǿ��ִ� employee����
	 */
	EmployeeVO loginEmployee(EmployeeVO employeeVO);
	
	/**
	 * ����� ����ϴ� ������Ʈ�� ��ȸ�ϴ±��
	 * @param empno ����� �����ȣ
	 * @return ����� ����ϴ� ������Ʈ
	 */
	List<MemberVO> myChargingCustomer(int empno);
	
	/**
	 * ����� ����ϴ� ���� ��㳻���� ��ȸ�ϴ� ���
	 * @param empno ����� �����ȣ
	 * @return ����� ����ϴ� ���� ��㳻������Ʈ
	 */
	List<ConsultingVO> selectConsulting(int empno);
	
}
