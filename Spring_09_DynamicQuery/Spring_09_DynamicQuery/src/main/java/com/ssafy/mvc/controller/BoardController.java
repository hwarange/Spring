package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.service.BoardService;

@Controller
public class BoardController {

	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	// ── 기본 CRUD (이미 완성) ────────────────────────────────────

	@GetMapping("/writeform")
	public String writeform() {
		return "board/writeform";
	}

	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {
		boardService.writeBoard(board);
		return "redirect:list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/list";
	}

	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) {
		model.addAttribute("board", boardService.readBoard(id));
		return "board/detail";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		boardService.removeBoard(id);
		return "redirect:list";
	}

	@GetMapping("/updateform")
	public String updateForm(@RequestParam("id") int id, Model model) {
		model.addAttribute("board", boardService.getBoard(id));
		return "board/updateform";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Board board) {
		boardService.modifyBoard(board);
		return "redirect:detail?id=" + board.getId();
	}

	//  05 : @GetMapping("/updateDynamic")
	//          → @ModelAttribute Board 받기 → boardService.modifyBoardDynamic(board) 호출
	//          → redirect:detail?id={id}
	@GetMapping("/updateDynamic")
	public String updateDynamic(@ModelAttribute Board board) {
		boardService.modifyBoardDynamic(board);
		return "redirect:detail?id=" + board.getId();
	}
	
	// TODO 10 : @PostMapping("/deleteMany")
	//          → @RequestParam(value="ids", required=false) List<Integer> ids 받기
	//          → boardService.removeBoards(ids) 호출 → redirect:list

	// TODO 17 : @GetMapping("/popular")
	//          → @RequestParam(defaultValue="10") int min 받기
	//          → boardService.getPopularBoards(min) 결과를 "boardList" 로 모델에 담고 "board/list" 반환

	// TODO 22 : @GetMapping("/search")
	//          → @ModelAttribute SearchCondition condition 받기
	//          → boardService.search(condition) 결과를 "boardList" 로 모델에 담고 "board/list" 반환

	// TODO 31 : @GetMapping("/readTx")
	//          → @RequestParam("id") int id, @RequestParam(defaultValue="false") boolean fail 받기
	//          → try : boardService.readBoardWithRollback(id, fail) 호출 → 결과를 "board" 로 모델에 담고 "board/detail" 반환
	//          → catch (RuntimeException) : boardService.getBoard(id) 로 현재 상태 다시 조회 후 화면에 보여주기

}
