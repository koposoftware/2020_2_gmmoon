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
	
	 // mailSending 코드
    @RequestMapping( value = "auth/{check}" , method=RequestMethod.POST )
    public ModelAndView mailSending(HttpServletRequest request, String e_mail, HttpServletResponse response_email
    								,@PathVariable("check") int check, HttpSession session) throws IOException {
        Random r = new Random();
        int dice = r.nextInt(4589362) + 49311; //이메일로 받는 인증코드 부분 (난수)
        
        String setfrom = "dlgkstjq623@gamil.com";
        String tomail = request.getParameter("e_mail"); // 받는 사람 이메일
        String title = "보험해지 인증과정입니다"; // 제목
        String content =
        
        System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
        
        System.getProperty("line.separator")+
                
        "안녕하세요 회원님 보험해지를 위해 받으신 인증번호를 입력해주세요"
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+

        " 인증번호는 " +dice+ " 입니다. "
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다."; // 내용
        
        
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");

            messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
            messageHelper.setTo(tomail); // 받는사람 이메일
            messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
            messageHelper.setText(content); // 메일 내용
            
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
        mv.setViewName("/email/email_injeung");     //뷰의이름
        mv.addObject("dice", dice);
        
        System.out.println("mv : "+mv);

        response_email.setContentType("text/html; charset=UTF-8");
        PrintWriter out_email = response_email.getWriter();
        out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
        out_email.flush();
        
        
        return mv;
        
    }
    
    //이메일 인증 페이지 맵핑 메소드
    @RequestMapping("/email/email_injeung")
    public String email() {
        return "email/email_injeung";
    }
    
    //이메일로 받은 인증번호를 입력하고 전송 버튼을 누르면 맵핑되는 메소드.
    //내가 입력한 인증번호와 메일로 입력한 인증번호가 맞는지 확인해서 맞으면 회원가입 페이지로 넘어가고,
    //틀리면 다시 원래 페이지로 돌아오는 메소드
    @RequestMapping(value = "join_injeung/{dice}", method = RequestMethod.POST)
    public ModelAndView join_injeung(String email_injeung, @PathVariable("dice") String dice, HttpServletResponse response_equals
    								, HttpSession session) throws IOException {
 
        
        
        
        System.out.println("마지막 : email_injeung : "+email_injeung);
        
        System.out.println("마지막 : dice : "+dice);
        
        
        //페이지이동과 자료를 동시에 하기위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음
         
        ModelAndView mv = new ModelAndView();
        
        mv.setViewName("/email/email_injeung");
        
        mv.addObject("e_mail",email_injeung);
        
        if (email_injeung.equals(dice)) {
            
            //인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 회원가입창으로 이동함
        	int ic_serialno = (int)session.getAttribute("check");
    		ModelAndView mav = new ModelAndView("insurancecontract/insuranceTermination");
    		InsuranceContractVO icVO = insurancecontractService.InsuranceMyOneContract(ic_serialno);
    		
    		String ipcode = icVO.getCode();
    		InsuranceProductVO ipVO = insuranceproductService.searchProduct(ipcode);
    		
    		mav.addObject("icVO", icVO);
    		mav.addObject("ipVO", ipVO);
            
//            mv.setViewName("insurancecontract/insuranceTermination");
            
            mav.addObject("e_mail",email_injeung);
            
            //만약 인증번호가 같다면 이메일을 회원가입 페이지로 같이 넘겨서 이메일을
            //한번더 입력할 필요가 없게 한다.
            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('인증번호가 일치하였습니다. 보험해지를 진행합니다.');</script>");
            out_equals.flush();
    
            return mav;
            
            
        }else if (email_injeung != dice) {
            
            
            ModelAndView mv2 = new ModelAndView(); 
            
            mv2.setViewName("email/email_injeung");
            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); history.go(-1);</script>");
            out_equals.flush();
            
    
            return mv2;
            
        }    
    
        return mv;
    }
    
    //보험계약시 이메일 인증 GET맵핑
    @RequestMapping(value = "authContract/{code}" , method=RequestMethod.GET)
	public String mailSendingForm2(@PathVariable("code") String code, HttpSession session) {
    	session.setAttribute("code", code);
    	return "insuranceproduct/insuranceContract";
	}
    
    // 보험계약 mailSending 코드
    @RequestMapping( value = "authContract/{code}" , method=RequestMethod.POST )
    public ModelAndView mailSending2(HttpServletRequest request, String e_mail, HttpServletResponse response_email
    								, HttpSession session, @PathVariable("code") String code) throws IOException {
        Random r = new Random();
        int dice = r.nextInt(4589362) + 49311; //이메일로 받는 인증코드 부분 (난수)
        
        String setfrom = "dlgkstjq623@gamil.com";
        String tomail = request.getParameter("e_mail"); // 받는 사람 이메일
        String title = "보험계약 인증과정입니다"; // 제목
        String content =
        
        System.getProperty("line.separator")+ //한줄씩 줄간격을 두기위해 작성
        
        System.getProperty("line.separator")+
                
        "안녕하세요 회원님 보험계약를 위해 받으신 인증번호를 입력해주세요"
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+

        " 인증번호는 " +dice+ " 입니다. "
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다." // 내용
        
        +System.getProperty("line.separator")+
        
        System.getProperty("line.separator")+
        
        "만약 받으신 이메일이 귀하와 아무 연관이 없다면 무시하셔도 좋습니다";
        
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,
                    true, "UTF-8");

            messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
            messageHelper.setTo(tomail); // 받는사람 이메일
            messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
            messageHelper.setText(content); // 메일 내용
            
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        ModelAndView mv = new ModelAndView();    //ModelAndView로 보낼 페이지를 지정하고, 보낼 값을 지정한다.
        mv.setViewName("/email/email_injeung2");     //뷰의이름
        mv.addObject("dice", dice);
        
        System.out.println("mv : "+mv);

        response_email.setContentType("text/html; charset=UTF-8");
        PrintWriter out_email = response_email.getWriter();
        out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
        out_email.flush();
        
        session.setAttribute("code", code);
        return mv;
        
    }
    
    
    //보험계약 인증 단계2
    @RequestMapping(value = "join_injeung2/{dice}", method = RequestMethod.POST)
    public ModelAndView join_injeung2(String email_injeung, @PathVariable("dice") String dice, HttpServletResponse response_equals
    								, HttpSession session) throws IOException {
 
        
        
        
        System.out.println("마지막 : email_injeung : "+email_injeung);
        
        System.out.println("마지막 : dice : "+dice);
        
        
        //페이지이동과 자료를 동시에 하기위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음
         
        ModelAndView mv = new ModelAndView();
        
        mv.setViewName("/email/email_injeung2");
        
        mv.addObject("e_mail",email_injeung);
        
        if (email_injeung.equals(dice)) {
            
            //인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 보험가입창으로 이동함
        	
        	
    		ModelAndView mav = new ModelAndView("insuranceproduct/insuranceContractForm");
    		
    		String code = (String)session.getAttribute("code");
    		mav.addObject("code", code);
            
            mav.addObject("e_mail",email_injeung);
            
            //만약 인증번호가 같다면 이메일을 회원가입 페이지로 같이 넘겨서 이메일을
            //한번더 입력할 필요가 없게 한다.
            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('인증번호가 일치하였습니다. 보험계약을 진행합니다.');</script>");
            out_equals.flush();
    
            return mav;
            
            
        }else if (email_injeung != dice) {
            
            
            ModelAndView mv2 = new ModelAndView(); 
            
            mv2.setViewName("email/email_injeung2");
            
            response_equals.setContentType("text/html; charset=UTF-8");
            PrintWriter out_equals = response_equals.getWriter();
            out_equals.println("<script>alert('인증번호가 일치하지않습니다. 인증번호를 다시 입력해주세요.'); history.go(-1);</script>");
            out_equals.flush();
            
    
            return mv2;
            
        }    
    
        return mv;
    }
    
    
    
}
