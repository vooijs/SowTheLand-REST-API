package nl.novi.sowtheland.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table ( name= "Blogs" )
@Data
public class Blog {
    @Id
    @GeneratedValue
    private Long blogId;
    private String blogTopic;
    private String blogTitle;
    private String blogArticle;
    private Long blogImg;
    private String blogImgAlt;
}
