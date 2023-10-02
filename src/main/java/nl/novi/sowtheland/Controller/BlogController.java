package nl.novi.sowtheland.Controller;
import nl.novi.sowtheland.Dto.BlogDto;
import nl.novi.sowtheland.Service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }
    @PostMapping
    public ResponseEntity <Object> createBlog (@RequestBody BlogDto blogDto) {
      Long newBlogId = blogService.createBlog(blogDto).getBody();
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newBlogId).toUriString());
        return ResponseEntity.created(uri).body(blogDto);
    }

    @GetMapping
    public List<BlogDto> getAllBlogs() {
        return blogService.getAllBlogs();
    }
    @PutMapping("/update/{blogId}")
    public ResponseEntity<BlogDto> updateBlog (@PathVariable Long blogId, @RequestBody BlogDto blogDto) {
        blogService.updateBlog(blogDto, blogId);
        return ResponseEntity.ok(blogDto);
    }
    @DeleteMapping("/delete/{blogId}")
    public ResponseEntity<?> deleteBlog (@PathVariable Long blogId) {
        blogService.deleteBlog(blogId);
        return ResponseEntity.ok("Blog was deleted");
    }
}
