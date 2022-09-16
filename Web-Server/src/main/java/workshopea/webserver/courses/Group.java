//package workshopea.webserver.courses;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//@Table(name = "groupsc")
//public class Group {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="course_id")
//	@JsonIgnore
//	private Course course;
//	
//	@OneToMany(mappedBy="group", orphanRemoval = true, targetEntity = Lesson.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
//	List<Lesson> lessons;
//}
