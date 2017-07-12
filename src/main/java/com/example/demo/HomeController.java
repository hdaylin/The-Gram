package com.example.demo;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.Models.Comments;
import com.example.demo.Models.Post;
import com.example.demo.Models.User;
import com.example.demo.Repositories.CommentRepository;
import com.example.demo.Repositories.PostRepository;
import com.example.demo.Repositories.RoleRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.configs.CloudinaryConfig;
import com.example.demo.services.UserService;
import com.example.demo.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by daylinhenry on 7/10/17.
 */

@Controller
public class HomeController {

@Autowired
CloudinaryConfig cloudc;

@Autowired
UserRepository userRepository;

@Autowired
PostRepository postRepository;

@Autowired
CommentRepository commentRepository;

@Autowired
RoleRepository roleRepository;


    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

/*    @GetMapping("post")
    public String newPost(@Valid Model model, BindingResult bindingResult, Post post){
        model.addAttribute("post", new Post());
        return "post";
     }*/

    @RequestMapping("/postlink/{id}")
    public String linktoPost(@PathVariable("id") Integer id, Model model){
        Post p = postRepository.findAllById(id);
        List<Post> plist = new ArrayList<Post>();
        plist.add(p);
        model.addAttribute("posts",plist);
        return "feed";
    }

    @GetMapping("/upload")
    public String uploadForm(Model model){
        model.addAttribute("post", new Post());
        return "upload";
    }

    @PostMapping("/upload")
    public String singleImageUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model, @ModelAttribute Post post){
        if (file.isEmpty()){
            model.addAttribute("message","Please select a file to upload");
            return "upload";
        }
        try {
            Map uploadResult =  cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
            model.addAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
            model.addAttribute("imageurl", uploadResult.get("url"));
        } catch (IOException e){
            e.printStackTrace();
            model.addAttribute("message", "Sorry I can't upload that!");
        }
        return "upload";
    }



}
