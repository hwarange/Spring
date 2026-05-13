package com.ssafy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;

/**
 * BoardController : /board/** 요청을 받는 컨트롤러.
 *
 * <p>Controller 의 책임: 요청 받기 -> Service 호출 -> 결과 -> 뷰 이름 반환.
 *
 * <p>POST 처리 후에는 PRG 패턴 (Post-Redirect-Get) 사용 — F5 중복 등록 방지.
 */
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("boards", boardService.getBoardList());
		return "board/list";
	}

	@GetMapping("detail")
	public String detail(@RequestParam int id, Model model) {
		model.addAttribute("board", boardService.getBoard(id));
		return "board/detail";
	}

	@GetMapping("writeform")
	public String writeform() {
		return "board/writeform";
	}

	@PostMapping("write")
	public String write(Board board) {
		boardService.writeBoard(board);
		return "redirect:/board/list";
	}

	@GetMapping("updateform")
	public String updateform(@RequestParam int id, Model model) {
		model.addAttribute("board", boardService.getBoard(id));
		return "board/updateform";
	}

	@PostMapping("update")
	public String update(Board board) {
		boardService.modifyBoard(board);
		return "redirect:/board/list";
	}

	@GetMapping("delete")
	public String delete(@RequestParam int id) {
		boardService.removeBoard(id);
		return "redirect:/board/list";
	}
}
