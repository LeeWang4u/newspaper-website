package com.ptit.controller.user;

import com.ptit.Dto.UserDto;
import com.ptit.Entities.Comment;
import com.ptit.Entities.Post;
import com.ptit.Service.CommentService;
import com.ptit.Service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
@SessionAttributes("userdto")
public class HomeController {
	private PostService postService;
	private CommentService commentService;
	@ModelAttribute("userdto")
	public UserDto userDto(){
		return new UserDto();
	}
//	@GetMapping("/home/page/1")
//	public String home( Model model ) {
//		Page<Post> page = postService.findAllByOrderByIdPostDesc();
//		int totalItems =page.getNumberOfElements() ;
//		int totalPages= page.getTotalPages();
//		List<Post> listPost = page.getContent();
//		model.addAttribute("listPost",listPost);
//		model.addAttribute("totalPages", totalPages);
//		model.addAttribute("totalItems",totalItems);
//		return "user/home";
//	}
	@PostMapping("/post")
	public String viewPost(@RequestParam("idPost") int idPost, Model model){
		Post post = postService.getPostbyIdPost(idPost);
		List<Comment> cmt = commentService.findByIdPostOrderByIdCmtDesc(post);
		model.addAttribute("post",post);
		model.addAttribute("cmt",cmt);

		return "user/post";

	}
	@GetMapping("/home/page/{pageNum}")
	public String viewPage(Model model,
						   @PathVariable(name = "pageNum") int pageNum) {

		Page<Post> page = postService.findAllByOrderByIdPostDesc(pageNum);
		int totalItems =page.getNumberOfElements() ;
		int totalPages= page.getTotalPages();
		List<Post> listPost = page.getContent();

		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("totalItems",totalItems);
		model.addAttribute("listPost", listPost);
		return "user/home";
	}
}

