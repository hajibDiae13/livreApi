package com.example.RestApi.entities;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@Entity @Table(name = "Library")
@Data @AllArgsConstructor @NoArgsConstructor
public class Livre {
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id @GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 50, nullable = false) @JsonProperty(access = JsonProperty.Access.READ_WRITE)
	private String title;
	
	@Column(nullable = false,updatable = false) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String publishingHouse;
	
	@Column(nullable = false) @JsonProperty(access = JsonProperty.Access.READ_WRITE)
	private Boolean available;
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@Temporal(TemporalType.TIMESTAMP) @Column(nullable = false) /*@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")*/ @CreationTimestamp
	private Date releaseDate;
	
	@Column(nullable = false) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String author;
	
	@Column(nullable = false) @JsonProperty(access = JsonProperty.Access.READ_WRITE)
	private Integer numberOfPages;
	
	@Column(nullable = false,unique = true,updatable = false) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private long isbn;
	
	@Temporal(TemporalType.TIMESTAMP) @CreationTimestamp @Column(nullable = false)  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Date lastChecked;
}
