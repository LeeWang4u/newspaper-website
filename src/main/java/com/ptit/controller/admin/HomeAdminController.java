package com.ptit.controller.admin;

import com.ptit.Dto.UserDto;
import com.ptit.Entities.Category;
import com.ptit.Entities.Post;
import com.ptit.Service.CategoryService;
import com.ptit.Service.CommentService;
import com.ptit.Service.PostService;
import com.ptit.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
@SessionAttributes("userdto")
public class HomeAdminController {

    private PostService postService;
    private CommentService commentService;
    private UserService userService;
    private CategoryService categoryService;

    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }

     @GetMapping("/home")
    public String Home(){return "admin/home";}
    @GetMapping("/post/{pageNum}")
    public String Post(Model model,
                       @PathVariable(name = "pageNum") int pageNum){
        Page<Post> page = postService.findAllByOrderByIdPostDesc(pageNum);
        int totalItems =page.getNumberOfElements() ;
        int totalPages= page.getTotalPages();
        List<Post> listPost = page.getContent();
        List<Category> categories = categoryService.findAllByOrderByIdCategoryDesc();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("listPost", listPost);
        model.addAttribute("categories",categories);
       // model.addAttribute()
        for (Post post : listPost) {
            String username = post.getEmail().getUserName();
            System.out.println(username);
        }


        return "admin/postAdmin";}

  //  public String Post(){return "admin/postAdmin";}
}

