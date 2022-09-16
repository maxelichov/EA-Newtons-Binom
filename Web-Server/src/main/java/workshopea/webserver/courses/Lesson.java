//package workshopea.webserver.courses;
//
//import java.time.LocalTime;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import logic.Days;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//public class Lesson {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	
//	private Days day;
//    private LocalTime startTime;
//    private LocalTime endTime;
//    
//    @ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="group_id")
//    @JsonIgnore
//	private Group group;
//}
