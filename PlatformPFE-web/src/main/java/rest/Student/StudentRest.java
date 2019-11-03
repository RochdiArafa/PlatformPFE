package rest.Student;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.pfe.entity.GradProjectFile;
import tn.pfe.entity.Student;
import tn.pfe.entity.projectCategory;
import tn.pfe.service.Student.StudentServiceLocal;


@Path("student")
public class StudentRest {

	@EJB
	StudentServiceLocal studentService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudent() {
		return  studentService.getAllStudent();
	}
	
	@GET
	@Path("getAllStudentRecrutedoverContry")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudentRecrutedoverContry() {
		return  studentService.getAllStudentRecrutedoverContry();
	}
	
	@GET
	@Path("getAllStudentRecrutedbyContryandYear")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudentRecrutedByContryByYear(@QueryParam(value="contry")String contry , @QueryParam(value="year")int year) {
		return  studentService.getAllStudentRecrutedByContryByYear(contry , year);
	}
	
	@POST
	@Path("ajouterEncadreur")
	@Produces(MediaType.APPLICATION_JSON)
	public void ajouterEncadreur(@QueryParam(value="email")String email ) {
		studentService.ajouterEncadrent(email);
	}
	
	
	
}
