package kr.co.goodee39.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.goodee39.service.SelfFlyerService;
import kr.co.goodee39.vo.ImageVO;
import kr.co.goodee39.vo.mnwCmtVO;
import kr.co.goodee39.vo.mnwVO;
import kr.co.goodee39.vo.selfFlyerVO;

@Controller
public class SelfFlyerController {

	@Autowired
	SelfFlyerService service;

	// 셀프 전단지 페이지 이동
	@GetMapping("/selfFlyer")
	public String selfFlyer(Model model) {

		service.selectFlyerList(model);
		
		return "d_selfFlyer";
	}

	// 전단지 만들기 페이지 이동
	@GetMapping("/makeFlyer")
	public String makeFlyer(@ModelAttribute("selfVO") selfFlyerVO vo, HttpSession session) {

		String path = "";

		// 로그인 정보 없을 시 로그인 페이지로 이동 : 연동시 수정 필수
		// if(session.getAttribute("account") != null) {
		path = "d_selfFlyer_make";
		// }
		// else if(session.getAttribute("account") == null) {
		// path = "redirect:/member/login";
		// }

		return path;
	}

	// 전단지 읽기
	@GetMapping("/readFlyer")
	public String readFlyer(@RequestParam int bdiv, @RequestParam int num, @ModelAttribute("selfVO") selfFlyerVO vo,
			Model model, HttpSession session) {

		service.selectFlyer(bdiv, num, vo, model);

		// 로그인 기능 생성 전 임시 코드//로그인 기능 생성 전 임시 코드
		// 로그인 기능 생성 전 임시 코드//로그인 기능 생성 전 임시 코드
		// session.getAttribute("account");
		// 임시세션 정보
		session.setAttribute("account", "sessionId");
		// 로그인 기능 생성 전 임시 코드//로그인 기능 생성 전 임시 코드
		// 로그인 기능 생성 전 임시 코드//로그인 기능 생성 전 임시 코드

		return "d_selfFlyer_read";
	}

	// 게시글 댓글 가져오기
	@GetMapping("/getFlyerComment/{num}/{bdiv}")
	public ResponseEntity<List<mnwCmtVO>> getCommentList(@PathVariable int num, @PathVariable int bdiv) {

		// 게시글 번호 num을 bnum으로 설정
		mnwCmtVO cvo = new mnwCmtVO();
		cvo.setBnum(num);
		cvo.setBdiv(bdiv);

		// service통해 코멘트 db긁어오기
		List<mnwCmtVO> list = service.selectFlyerCmt(cvo);

		// 리턴타입 변수에 결과 담기 (단, status가 ok인 상황에서만!)
		ResponseEntity<List<mnwCmtVO>> entity = new ResponseEntity<List<mnwCmtVO>>(list, HttpStatus.OK);

		return entity;
	}

	// 게시글 댓글 추가
	@PostMapping("/createFlyerComment")
	public ResponseEntity<mnwCmtVO> createComment(@RequestBody mnwCmtVO vo, HttpSession session) {
		System.out.println("코멘트 : " + vo.getCmt());
		System.out.println("글번호 : " + vo.getBnum());
		System.out.println("게시판구분 : " + vo.getBdiv());

		// MemberVO mvo = (MemberVO)session.getAttribute("account");
		// vo.setId(mvo.getId());
		// 임시id : 후에 세션정보로 교체 필요
		vo.setId("sessionId");

		// 코멘트 db추가
		service.insertFlyerCmt(vo);

		ResponseEntity<mnwCmtVO> entity = new ResponseEntity<mnwCmtVO>(vo, HttpStatus.OK);

		return entity;
	}

	// 게시글 댓글 삭제
	@DeleteMapping("/deleteFlyerComment")
	public ResponseEntity<String> deletetComment(@RequestBody mnwCmtVO vo, HttpSession session) {

		System.out.println("어떤 댓글 삭제? : " + vo.getNum());
		System.out.println("어디 게시판? : " + vo.getBdiv());

		// MemberVO mvo = (MemberVO)session.getAttribute("account");
		// vo.setId(mvo.getId());
		// 임시id : 후에 세션정보로 교체 필요
		vo.setId("sessionId");

		service.deleteFlyerCmt(vo);

		String msg = "삭제 완.";

		ResponseEntity<String> entity = new ResponseEntity<String>(msg, HttpStatus.OK);

		return entity;
	}

	// 전단지 만들기 제출
	@PostMapping("/createFlyerResult")
	public String createFlyerResult(@ModelAttribute("selfVO") selfFlyerVO vo) {

		// 데이터 오는지 출력해보기
		/*
		 * System.out.println("이름 : "+vo.getPetName());
		 * System.out.println("견종 : "+vo.getSpecies());
		 * System.out.println("성별 : "+vo.getSex());
		 * System.out.println("나이 : "+vo.getAge());
		 * System.out.println("특징 : "+vo.getCharacters());
		 * System.out.println("실종장소 : "+vo.getLocation());
		 * System.out.println("사례금 : "+vo.getGratuity());
		 * System.out.println("연락처 : "+vo.getPhone());
		 * System.out.println("사진 : "+vo.getFileList());
		 * System.out.println("배경색 : "+vo.getColor());
		 */

		service.insertFlyer(vo);

		return "redirect:/selfFlyer";
	}
	

	// 전단지 만들기 미리보기창
	@GetMapping("/preview")
	public String preview() {

		return "d_selfFlyer_preview";
	}

	// 전단지 수정 페이지 이동
	@GetMapping("/reviseFlyer")
	public String reviseFlyer(@RequestParam int bdiv, @RequestParam int num, @ModelAttribute("selfVO") selfFlyerVO vo,
			Model model) {

		service.selectFlyer(bdiv, num, vo, model);

		return "d_selfFlyer_revise";
	}
	

	// 게시글 수정완료
	@PostMapping("/reviseFlyerResult")
	public String reviseFlyerResult(@ModelAttribute("selfVO") selfFlyerVO vo) {

		service.updateFlyer(vo);
		
		return "redirect:/selfFlyer";
	}

	/*
	 * //상태처리(귀가/종료)
	 * 
	 * @GetMapping("/backFlyer") public String backFlyer() { return ""; }
	 * 
	 * @GetMapping("/endFlyer") public String endFlyer() { return ""; }
	 * 
	 * //전단지 삭제
	 * 
	 * @GetMapping("/isdeleteFlyer") public String isdeleteFlyer() { return ""; }
	 */

}