package introsde.document.ws;

import java.util.List;

import javax.jws.WebService;
import introsde.document.model.Person;

//Service Implementation

@WebService(endpointInterface = "introsde.document.ws.People",
	serviceName="PeopleService")
public class PeopleImpl implements People {
   
	
	public Person readPerson(int id) {
        System.out.println("---> Reading Person by id = "+id);
        Person p = Person.getPersonById(id);
        if (p!=null) {
            System.out.println("---> Found Person by id = "+id+" => "+p.getUserName());
        } else {
            System.out.println("---> Didn't find any Person with  id = "+id);
        }
        return p;
    }

    @Override
    public List<Person> getPeople() {
        return Person.getAll();
    }

    @Override
    public int addPerson(Person person) {
        Person.savePerson(person);
        return person.getIdPerson();
    }

   
    public int updatePerson2(Person person) {
        Person.updatePerson(person);
        return person.getIdPerson();
    }

    @Override
    public int updatePerson(Person person){
    	System.out.println("--> REQUEST: updatePerson(p)");
    	
    	Person existing = Person.getPersonById(person.getIdPerson());
    	int personId = 0;
        
        if (existing == null) {
        	//the person is not found
        	System.out.println("---> id: "+ person.getIdPerson() + " not found!");
        	//personId = new Long(-1);
        	
        } else {
        	person.setIdPerson(existing.getIdPerson());
            //checks if the client sent a name in order to update the person
            //if there is no name, remain the previous name, the same happens with Lastname and Birthdate
            if (person.getUserName() == null){
            	person.setUsername(existing.getUserName());
            }
            if (person.getPassword() == null){
            	person.setPassword(existing.getPassword());
            }
            if (person.getBirthdate() == null){
            	person.setBirthdate(existing.getBirthdate());
            }
            
            Person.updatePerson(person);
            personId = person.getIdPerson(); 
        }
        return personId;
    }


    public int deletePerson(int id) {
        Person p = Person.getPersonById(id);
        if (p!=null) {
            Person.removePerson(p);
            return 0;
        } else {
            return -1;
        }
    }
    
    public int login(String username) {
        int p = Person.getIdByUsername(username);
        if (p!=0) {
           return p;
        } else {
            return -1;
        }
    }
    
    public int createPerson(Person person) {
    	
        //checks if person includes currentMeasure, in other words a 'measure'
    	if(person.getUserName().equals(null)){
    		System.out.println("Create a new person");
    		Person.savePerson(person);
    		return person.getIdPerson();
    		
    	}else{
    	
    		//removes the currentMeasure in the person and puts them in another variable
    		System.out.println("IdPerson "+person.getIdPerson()+" already existed");
    
    		return person.getIdPerson();	
    	}
}


	}
