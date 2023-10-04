package nl.novi.sowtheland.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.novi.sowtheland.Dto.BlogDto;
import nl.novi.sowtheland.Dto.CropDto;
import nl.novi.sowtheland.Model.Blog;
import nl.novi.sowtheland.Model.Crop;
import nl.novi.sowtheland.Repository.BlogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Service

public class BlogService {
    private final BlogRepository blogRepository;
    public ResponseEntity<Long> createblog (BlogDto blogDto){
        Blog blog = new Blog();

        blog.setBlogTitle(blogDto.blogTitle);
        blog.setBlogArticle(blogDto.blogArticle);
        blog.setBlogImg(blogDto.blogImg);
        blog.setBlogImgAlt(blogDto.blogImgAlt);

        blogRepository.save(blog);

        return new ResponseEntity<>(blog.getBlogId(), HttpStatus.CREATED);
    }
    public List<BlogDto> getAllBlogs () {
        Iterable<Blog> blogs = blogRepository.findAll();
        List<BlogDto> allBlogs = new ArrayList<>();

        for (Blog blog : blogs) {
            BlogDto blogDto = new BlogDto();

            blogDto.blogId = blog.getBlogId();
            blogDto.blogTitle = blog.getBlogTitle();
            blogDto.blogArticle = blog.getBlogArticle();
            blogDto.blogImgAlt = blog.getBlogImgAlt();


            allBlogs.add(blogDto);
        }
        return allBlogs;
    }
    public BlogDto findBlogById (Long blogId) {

        Blog blog = blogRepository.findById(blogId).orElseThrow();

        BlogDto foundBlog = new BlogDto();
        foundBlog.blogId = blog.getBlogId();
        foundBlog.blogTitle = blog.getBlogTitle();
        foundBlog.blogArticle = blog.getBlogArticle();
        foundBlog.blogImg = blog.getBlogImg();
        foundBlog.blogImgAlt = blog.getBlogImgAlt();

        blogRepository.save(blog);
        return foundBlog;


    }
}
