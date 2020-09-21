package kr.ac.hanalife.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.hanalife.insurance.contract.service.InsuranceContractService;
import kr.ac.hanalife.insurance.contract.vo.InsuranceContractVO;
import kr.ac.hanalife.insurance.product.service.InsuranceProductService;
import kr.ac.hanalife.insurance.product.vo.InsuranceProductVO;

@Controller
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private InsuranceContractService insurancecontractService;
	
	@Autowired
	private InsuranceProductService insuranceproductService;
	
	@RequestMapping(value = "auth/{check}" , method=RequestMethod.GET)
	public String mailSendingForm(@PathVariable("check") int check, HttpSession session) {
		session.setAttribute("check", check);
		return "email/auth";
	}
	
	 // mailSending �ڵ�
    @RequestMapping( value = "auth/{check}" , method=RequestMethod.POST )
    public ModelAndView mailSending(HttpServletRequest request, String e_mail, HttpServletResponse response_email
    								,@PathVariable("check") int check, HttpSession session) throws IOException {
        Random r = new Random();
        int dice = r.nextInt(4589362) + 49311; //�̸��Ϸ� �޴� �����ڵ� �κ� (����)
        
        String setfrom = "dlgkstjq623@gamil.com";
        String tomail = request.getParameter("e_mail"); // �޴� ��� �̸���
        String title = "�������� ���������Դϴ�"; // ����
        String content =
        
        System.getProperty("line.separator")+ //���پ� �ٰ����� �α����� �ۼ�
        
        System.getProperty("line.separator")+
                
        "�ȳ��ϼ��� ȸ���� ���������� ���� ������ ������ȣ�� �Է����ּ���"
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+

        " ������ȣ�� " +dice+ " �Դϴ�. "
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "������ ������ȣ�� Ȩ�������� �Է��� �ֽø� �������� �Ѿ�ϴ�."; // ����
        
        
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");

            messageHelper.setFrom(setfrom); // �����»�� �����ϸ� �����۵��� ����
            messageHelper.setTo(tomail); // �޴»�� �̸���
            messageHelper.setSubject(title); // ���������� ������ �����ϴ�
            messageHelper.setText(content); // ���� ����
            
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        ModelAndView mv = new ModelAndView();    //ModelAndView�� ���� �������� �����ϰ�, ���� ���� �����Ѵ�.
        mv.setViewName("/email/email_injeung");     //�����̸�
        mv.addObject("dice", dice);
        
        System.out.println("mv : "+mv);

        response_email.setContentType("text/html; charset=UTF-8");
        PrintWriter out_email = response_email.getWriter();
        out_email.println("<script>alert('�̸����� �߼۵Ǿ����ϴ�. ������ȣ�� �Է����ּ���.');</script>");
        out_email.flush();
        
        
        return mv;
        
    }
    
    //�̸��� ���� ������ ���� �޼ҵ�
    @RequestMapping("/email/email_injeung")
    public String email() {
        return "email/email_injeung";
    }
    
    //�̸��Ϸ� ���� ������ȣ�� �Է��ϰ� ���� ��ư�� ������ ���εǴ� �޼ҵ�.
    //���� �Է��� ������ȣ�� ���Ϸ� �Է��� ������ȣ�� �´��� Ȯ���ؼ� ������ ȸ������ �������� �Ѿ��,
    //Ʋ���� �ٽ� ���� �������� ���ƿ��� �޼ҵ�
    @RequestMapping(value = "join_injeung/{dice}", method = RequestMethod.POST)
    public ModelAndView join_injeung(String email_injeung, @PathVariable("dice") String dice, HttpServletResponse response_equals
    								, HttpSession session) throws IOException {
 
        
        
        
        System.out.println("������ : email_injeung : "+email_injeung);
        
        System.out.println("������ : dice : "+dice);
        
        
        //�������̵��� �ڷḦ ���ÿ� �ϱ����� ModelAndView�� ����ؼ� �̵��� �������� �ڷḦ ����
         
        ModelAndView mv = new ModelAndView();
        
        mv.setViewName("/email/email_injeung");
        
        mv.addObject("e_mail",email_injeung);
        
        if (email_injeung.equals(dice)) {
            
            //������ȣ�� ��ġ�� ��� ������ȣ�� �´ٴ� â�� ����ϰ� ȸ������â���� �̵���
        	int ic_serialno = (int)session.getAttribute("check");
    		ModelAndView mav = new ModelAndView("insurancecontract/insuranceTermination");
    		InsuranceContractVO icVO = insurancecontractService.InsuranceMyOneContract(ic_serialno);
    		
    		String ipcode = icVO.getCode();
    		InsuranceProductVO ipVO = insuranceproductService.searchProduct(ipcode);
    		
    		mav.addObject("icVO", icVO);
    		mav.addObject("ipVO", ipVO);
            
//            mv.setViewName("insurancecontract/insuranceTermination");
            
            mav.addObject("e_mail",email_injeung);
            
            //���� ������ȣ�� ���ٸ� �̸����� ȸ������ �������� ���� �Ѱܼ� �̸�����
            //�ѹ��� �Է��� �ʿ䰡 ���� �Ѵ�.
            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('������ȣ�� ��ġ�Ͽ����ϴ�. ���������� �����մϴ�.');</script>");
            out_equals.flush();
    
            return mav;
            
            
        }else if (email_injeung != dice) {
            
            
            ModelAndView mv2 = new ModelAndView(); 
            
            mv2.setViewName("email/email_injeung");
            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('������ȣ�� ��ġ�����ʽ��ϴ�. ������ȣ�� �ٽ� �Է����ּ���.'); history.go(-1);</script>");
            out_equals.flush();
            
    
            return mv2;
            
        }    
    
        return mv;
    }
    
    //������� �̸��� ���� GET����
    @RequestMapping(value = "authContract/{code}" , method=RequestMethod.GET)
	public String mailSendingForm2(@PathVariable("code") String code, HttpSession session) {
    	session.setAttribute("code", code);
    	return "insuranceproduct/insuranceContract";
	}
    
    // ������ mailSending �ڵ�
    @RequestMapping( value = "authContract/{code}" , method=RequestMethod.POST )
    public ModelAndView mailSending2(HttpServletRequest request, String e_mail, HttpServletResponse response_email
    								, HttpSession session, @PathVariable("code") String code) throws IOException {
        Random r = new Random();
        int dice = r.nextInt(4589362) + 49311; //�̸��Ϸ� �޴� �����ڵ� �κ� (����)
        
        String setfrom = "dlgkstjq623@gamil.com";
        String tomail = request.getParameter("e_mail"); // �޴� ��� �̸���
        String title = "������ ���������Դϴ�"; // ����
        String content =
        
        System.getProperty("line.separator")+ //���پ� �ٰ����� �α����� �ۼ�
        
        System.getProperty("line.separator")+
                
        "�ȳ��ϼ��� ȸ���� �����ฦ ���� ������ ������ȣ�� �Է����ּ���"
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+

        " ������ȣ�� " +dice+ " �Դϴ�. "
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "������ ������ȣ�� Ȩ�������� �Է��� �ֽø� �������� �Ѿ�ϴ�." // ����
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "���� ������ �̸����� ���Ͽ� �ƹ� ������ ���ٸ� �����ϼŵ� �����ϴ�";
        
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");

            messageHelper.setFrom(setfrom); // �����»�� �����ϸ� �����۵��� ����
            messageHelper.setTo(tomail); // �޴»�� �̸���
            messageHelper.setSubject(title); // ���������� ������ �����ϴ�
            messageHelper.setText(content); // ���� ����
            
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        ModelAndView mv = new ModelAndView();    //ModelAndView�� ���� �������� �����ϰ�, ���� ���� �����Ѵ�.
        mv.setViewName("/email/email_injeung2");     //�����̸�
        mv.addObject("dice", dice);
        
        System.out.println("mv : "+mv);

        response_email.setContentType("text/html; charset=UTF-8");
        PrintWriter out_email = response_email.getWriter();
        out_email.println("<script>alert('�̸����� �߼۵Ǿ����ϴ�. ������ȣ�� �Է����ּ���.');</script>");
        out_email.flush();
        
        session.setAttribute("code", code);
        return mv;
        
    }
    
    
    //������ ���� �ܰ�2
    @RequestMapping(value = "join_injeung2/{dice}", method = RequestMethod.POST)
    public ModelAndView join_injeung2(String email_injeung, @PathVariable("dice") String dice, HttpServletResponse response_equals
    								, HttpSession session) throws IOException {
 
        
        
        
        System.out.println("������ : email_injeung : "+email_injeung);
        
        System.out.println("������ : dice : "+dice);
        
        
        //�������̵��� �ڷḦ ���ÿ� �ϱ����� ModelAndView�� ����ؼ� �̵��� �������� �ڷḦ ����
         
        ModelAndView mv = new ModelAndView();
        
        mv.setViewName("/email/email_injeung2");
        
        mv.addObject("e_mail",email_injeung);
        
        if (email_injeung.equals(dice)) {
            
            //������ȣ�� ��ġ�� ��� ������ȣ�� �´ٴ� â�� ����ϰ� ���谡��â���� �̵���
        	
        	
    		ModelAndView mav = new ModelAndView("insuranceproduct/insuranceContractForm");
    		
    		String code = (String)session.getAttribute("code");
    		mav.addObject("code", code);
            
            mav.addObject("e_mail",email_injeung);
            
            //���� ������ȣ�� ���ٸ� �̸����� ȸ������ �������� ���� �Ѱܼ� �̸�����
            //�ѹ��� �Է��� �ʿ䰡 ���� �Ѵ�.
            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('������ȣ�� ��ġ�Ͽ����ϴ�. �������� �����մϴ�.');</script>");
            out_equals.flush();
    
            return mav;
            
            
        }else if (email_injeung != dice) {
            
            
            ModelAndView mv2 = new ModelAndView(); 
            
            mv2.setViewName("email/email_injeung2");
            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('������ȣ�� ��ġ�����ʽ��ϴ�. ������ȣ�� �ٽ� �Է����ּ���.'); history.go(-1);</script>");
            out_equals.flush();
            
    
            return mv2;
            
        }    
    
        return mv;
    }
    
    
    
}
