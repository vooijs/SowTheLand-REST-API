package nl.novi.sowtheland.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.novi.sowtheland.Dto.BlogDto;
import nl.novi.sowtheland.Service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Data
@AllArgsConstructor
@RestController
@RequestMapping("/blogs")


public class BlogController {
    private final BlogService blogService;

    @PostMapping
    public ResponseEntity<Object> createBlog (@RequestBody BlogDto blogDto){
        Long newBlogId =blogService.createblog(blogDto).getBody();
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newBlogId).toUriString());
        return ResponseEntity.created(uri).body(blogDto);
    }
    @GetMapping
    public List<BlogDto> getAllBlogs(){
        return blogService.getAllBlogs();
    }
    @GetMapping("/search")
    public ResponseEntity<BlogDto> findBlogById (@RequestParam Long blogId){
        return ResponseEntity.ok(blogService.findBlogById(blogId));
    }

}
