//package workshopea.webserver.courses;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//public class Course {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//
//	@Column(name = "course_name", unique = true)
//    private String courseName;
//    
//    @OneToMany(mappedBy = "course", orphanRemoval = true, targetEntity = Group.class, cascade = CascadeType.ALL)
//    private List<Group> group;
//    
//    private Date testA;
//    private Date testB;
//    private double credits;
//    private int difficulty;
//    private Boolean isMandatory;
//}
