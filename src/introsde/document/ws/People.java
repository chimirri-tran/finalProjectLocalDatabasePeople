package src.introsde.document.ws;

import src.introsde.document.model.Person;
//import introsde.document.model.Goal;

import java.util.List;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL) // optional
public interface People {

	// Method #1
	@WebMethod(operationName = "readPersonList")
	@WebResult(name = "people")
	public List<Person> getPeople();

	// Method #2
	@WebMethod(operationName = "readPerson")
	@WebResult(name = "person")
	public Person readPerson(@WebParam(name = "idPerson") int id);

	// Method #3
	@WebMethod(operationName = "updatePerson")
	@WebResult(name = "personId")
	public int updatePerson(@WebParam(name = "person") Person person);

	// Method #4
	@WebMethod(operationName = "createPerson")
	@WebResult(name = "personId")
	public int addPerson(@WebParam(name = "person") Person person);

	// Method #5
	@WebMethod(operationName = "deletePerson")
	// @WebResult(name = "personId")
	@WebResult(name = "message")
	public int deletePerson(@WebParam(name = "personId") int id);

	// Method #6

	@WebMethod(operationName = "login")
	@WebResult(name = "message")
	public int login(@WebParam(name = "username") String username);

/*	// Method #7
	@WebMethod(operationName = "createGoal")
	@WebResult(name = "message")
	public int addGoal(@WebParam(name = "goal") Goal goal);

	// Method #8
	@WebMethod(operationName = "readGoalList")
	@WebResult(name = "goals")
	public List<Goal> getGoals();

	// Method #9
	@WebMethod(operationName = "readGoal")
	@WebResult(name = "goal")
	public Goal readGoal(@WebParam(name = "idGoal") int id);
	
	// Method #10
	@WebMethod(operationName = "updateGoal")
	@WebResult(name = "goalId")
	public int updateGoal(@WebParam(name = "goal") Goal goal);*/

	/*
	 * // Method #6
	 * 
	 * @WebMethod(operationName = "readPersonHistory")
	 * 
	 * @WebResult(name = "healthProfile-history") public HealthHistoryWrapper
	 * getPersonHistory(@WebParam(name = "personId") int id,
	 * 
	 * @WebParam(name = "measureType") String measureType);
	 * 
	 * // Method #7
	 * 
	 * @WebMethod(operationName = "readMeasureTypes")
	 * 
	 * @WebResult(name = "measureType") public MeasureTypesWrapper
	 * getMeasureTypes();
	 * 
	 * // Method #8
	 * 
	 * @WebMethod(operationName = "readPersonMeasure")
	 * 
	 * @WebResult(name = "measure") public String
	 * getPersonMeasure(@WebParam(name = "personId") int idPerson,
	 * 
	 * @WebParam(name = "measureType") String measureType, @WebParam(name =
	 * "mid") Long idMeasure);
	 * 
	 * // Method #9
	 * 
	 * @WebMethod(operationName = "savePersonMeasure")
	 * 
	 * @WebResult(name = "measure") public Long savePersonMeasure(@WebParam(name
	 * = "personId") Long idPerson,
	 * 
	 * @WebParam(name = "measure") Measure measure);
	 * 
	 * // Method #10
	 * 
	 * @WebMethod(operationName = "updatePersonMeasure")
	 * 
	 * @WebResult(name = "measure") public Measure
	 * updatePersonMeasure(@WebParam(name = "personId") Long idPerson,
	 * 
	 * @WebParam(name = "measure") Measure measure, @WebParam(name = "mid") Long
	 * idMeasure);
	 * 
	 * @WebMethod(operationName = "updatePersonHealthProfile")
	 * 
	 * @WebResult(name = "measure") public HealthMeasureHistory
	 * updateHealthMeasureHistory(@WebParam(name = "measure")
	 * HealthMeasureHistory p);
	 * 
	 * @WebMethod(operationName = "getPeopleList")
	 * 
	 * @WebResult(name = "people") public List<Person> getPeople2();
	 */
}