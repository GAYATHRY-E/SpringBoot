package com.example.demo;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class FormController {
	
	@Autowired
	StudentRepo repo;
	@RequestMapping("/")
	public String details()
	{
	return "student";
	}
	@RequestMapping("/details")
	public String details(Students students)
	{
    repo.save(students);
	return "student";
	}
	
	@RequestMapping("/getdetails")
	public String getdetails()
	{
    return "ViewStudents";
	}	
	
@PostMapping("/getdetails")
public ModelAndView getdetails(@RequestParam int sid) 
{
	ModelAndView mv=new ModelAndView("Retrieve");
	Students students=repo.findById(sid).orElse(null);
    mv.addObject(students);
    return mv;
} 
@RequestMapping("/students")
@ResponseBody
public List<Students> getStudents()
{
	return repo.findAll();
}

@RequestMapping("/students/{sid}")
@ResponseBody
public Optional<Students> getStudents2(@PathVariable("sid") int sid)
{
	return repo.findById(sid);
}

@PostMapping("/students")
public Students getStudents3(@RequestBody Students students)
{
	repo.save(students);
	return students;
}

@DeleteMapping("/students/{sid}")
public Students getStudents4(@PathVariable("sid") int sid)
{   
	Students std=repo.getOne(sid);
	repo.delete(std);
	return std;
}

@PutMapping(path="/students", consumes= {"application/json"})
public Students getStudents5(@RequestBody Students students)
{   
	
	repo.save(students);
	return students;
}

}
