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
	
	/**
	 * ����� ȸ������ ���
	 * @param employeeVO Ȩ���������� �Է��ϴ� ����� ����
	 */
	void employeeSignUp(EmployeeVO employeeVO);
	
	/**
	 * ����� ���̵� �ߺ�üũ ���
	 * @param eid �ߺ�üũ�� ����� ���̵�
	 * @return ���̵� ���� ��ü, ������ null
	 */
	EmployeeVO employeeCheckID(String eid);
	
	/**
	 * �������Ʈ(�븮,���) ��ȸ ���, ���Ŀ� �μ����� ��ȸ�� �� �ֵ���
	 * '@param'���� �μ��� ��ȣ�� �߰����ش�
	 * @return �������Ʈ
	 */
	List<EmployeeVO> selectEmployeeAll();
	
	
	/**
	 * �����̻������� ����������������� ����� �������ִ� ���
	 * @param member ������ ��� ��ȣ�� ���� ������
	 */
	void AssignCustomer(MemberVO member);
	
	/**
	 * ����� ��� �� ���� ��ȸ�ϴ� ���
	 * @param empno �����ȣ
	 * @return ��� �� ��
	 */
	EmployeeVO countEmployeeInCharge(int empno);
	
	/**
	 * ����� ����ϴ� ���
	 * @param employeeVO ����� ��� ����
	 */
	void withdrawalEmployee(EmployeeVO employeeVO);
	
}
