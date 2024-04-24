package com.ptit.controller.admin;

import com.ptit.Dto.PostDto;
import com.ptit.Dto.UserDto;
import com.ptit.Entities.Category;
import com.ptit.Entities.Post;
import com.ptit.Entities.User;
import com.ptit.Service.CategoryService;
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
    private UserService userService;
    private CategoryService categoryService;

    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }
    @ModelAttribute("postdto")
    public PostDto postDto(){
        return new PostDto();
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
//        for (Post post : listPost) {
//            String username = post.getEmail().getUserName();
//            System.out.println(username);
//        }


        return "admin/postAdmin";}

    @GetMapping("/userAdmin/page/{pageNum}")
    public String User(Model model,@PathVariable(name = "pageNum") int pageNum ){
        Page<User> page = userService.findAllByOrderByEmailDesc(pageNum);
        int totalItems =page.getNumberOfElements() ;
        int totalPages= page.getTotalPages();
        List<User> listUser = page.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("listUser", listUser);
        return "admin/userAdmin";
    }
    @PostMapping("userAdmin/page/{pageNum}")
    public String UserDelete(Model model,@PathVariable(name = "pageNum") int pageNum,@RequestParam("email") String email ){
        User user = userService.getUserByEmail(email);
        UserDto currentUser = (UserDto) model.getAttribute("userdto");
        if(!user.getEmail().trim().equals(currentUser.getEmail().trim()) ){
            userService.delete(user);
        }
        Page<User> page = userService.findAllByOrderByEmailDesc(pageNum);
        int totalItems =page.getNumberOfElements() ;
        int totalPages= page.getTotalPages();
        List<User> listUser = page.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("listUser", listUser);
        if(user.getEmail().trim().equals(currentUser.getEmail().trim()) ){
            return "redirect:/admin/userAdmin/page/1?wrong";
        }
        return "admin/userAdmin";
    }

    @GetMapping("/post/new-post")
    public String newPost(Model model){
        System.out.println("vi sao khong duocccc");
        List<Category> categories = categoryService.findAllByOrderByIdCategoryDesc();
        model.addAttribute(categories);



        for (Category cate : categories) {
            String username = cate.getCategoryName();
            System.out.println(username);
        }


        return "admin/newPost";
    }

    @PostMapping("/post/new-post")
    public String saveNewPost(Model model, @ModelAttribute("postdto") PostDto postDto, @RequestParam("category") String selectedOption){
        System.out.println("dayyyyyyyyyyyyyyyyyyyyy");

                try {
                    System.out.println(selectedOption);

                    System.out.println("them duoccccccccccccc");
                    UserDto currentUser = (UserDto) model.getAttribute("userdto");

                    User user = userService.getUserByEmail(currentUser.getEmail().trim());
                    postDto.setUser(user);
                    System.out.println("them duoc usser");

                    Category cate = categoryService.getCategoryByIdCategory(Integer.parseInt(selectedOption));
                    postDto.setCategory(cate);
                    System.out.println("them duoc category");

                    System.out.println(postDto.getImage());
                    postDto.setImage("");

            postService.save(postDto);
                    System.out.println("them duoc cai lonnnnnnnnn");


        } catch (Exception e) {
            // Xử lý ngoại lệ tại đây (ví dụ: ghi log, thông báo lỗi...)
            //e.printStackTrace();
            // Trả về một trang thông báo lỗi
           // return "errorPage";       System.out.println("khong them duoc bai viet");
            System.out.println("khong them duoc bai viet");
        }

        return "admin/home";
    }
//    public String saveNewPost( @ModelAttribute("postdto") PostDto postDto){
//
//
//
//        return "admin/newPost";
//    }

}



