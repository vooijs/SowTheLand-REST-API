package nl.novi.sowtheland.Service;

import nl.novi.sowtheland.Dto.BlogDto;
import nl.novi.sowtheland.Model.Blog;
import nl.novi.sowtheland.Repository.BlogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepos;

    public BlogService(BlogRepository blogRepos) {
        this.blogRepos = blogRepos;
    }
    public ResponseEntity<Long> createBlog (BlogDto blogDto){
        Blog blog = new Blog();

        blog.setBlogId(blogDto.blogId);
        blog.setBlogTopic(blogDto.blogTopic);
        blog.setBlogTitle(blogDto.blogTitle);
        blog.setBlogArticle(blogDto.blogArticle);
        blog.setBlogImg(blogDto.blogImg);
        blog.setBlogImgAlt(blogDto.blogImgAlt);
        blogRepos.save(blog);

        return new ResponseEntity<>(blog.getBlogId(), HttpStatus.CREATED);
    }
    public List<BlogDto> getAllBlogs () {
        Iterable<Blog> blogs = blogRepos.findAll();
        List<BlogDto> allBlogs = new ArrayList<>();
        for(Blog blog : blogs) {
            BlogDto blogDto = new BlogDto();

            blogDto.blogId = blog.getBlogId();
            blogDto.blogTopic = blog.getBlogTopic();
            blogDto.blogTitle = blog.getBlogTitle();
            blogDto.blogArticle = blog.getBlogArticle();
            blogDto.blogImg = blog.getBlogImg();
            blogDto.blogImgAlt = blog.getBlogImgAlt();

            allBlogs.add(blogDto);
        }
        return allBlogs;
    }

    public Long updateBlog (BlogDto blogDto,Long blogId) {
        Blog blog = blogRepos.findById(blogId).get();

        blog.setBlogTopic(blogDto.blogTopic);
        blog.setBlogTitle(blogDto.blogTitle);
        blog.setBlogArticle(blogDto.blogArticle);
        blog.setBlogImg(blogDto.blogImg);
        blog.setBlogImgAlt(blogDto.blogImgAlt);

        blogRepos.save(blog);
        return blog.getBlogId();
    }
    public ResponseEntity<?> deleteBlog (long blogId) {
        blogRepos.deleteById(blogId);
        return ResponseEntity.ok("Blog was deleted");
    }
}

