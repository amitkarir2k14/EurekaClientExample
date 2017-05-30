package com.siemens.assignment.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.siemens.assignment.entity.Employee;
import com.siemens.assignment.entity.Project;
import com.siemens.assignment.entity.Role;
import com.siemens.assignment.entity.manager.EmployeeEntityManager;
import com.siemens.assignment.entity.manager.ProjectEntityManager;
import com.siemens.assignment.entity.manager.RoleEntityManager;
import com.siemens.assignment.service.helper.ServiceResponseHelper;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeService extends SpringBootServletInitializer {

	@Autowired
	EmployeeEntityManager employeeEntityManager;
	@Autowired
	ProjectEntityManager projectEntityManager;
	@Autowired
	RoleEntityManager roleEntityManager;
	@Autowired
	ServiceResponseHelper<Error> errorHelper;
	@Autowired
	ServiceResponseHelper<Employee> empResponseHelper;
	@Autowired
	ServiceResponseHelper<Project> projResponseHelper;
	@Autowired
	ServiceResponseHelper<Role> roleResponseHelper;
	private static Class<EmployeeService> applicationClass = EmployeeService.class;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	@RequestMapping(consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee, UriComponentsBuilder urib) {
		if (null != employeeEntityManager.findByEmployeeCode(employee.getCode()))
			return errorHelper.getResponseEntity(new Error(HttpStatus.BAD_REQUEST.value(), "Duplicate  user"),
					HttpStatus.FOUND);
		if (employee.getCode() == null || employee.getCode().length() < 8)
			return errorHelper.getResponseEntity(
					new Error(HttpStatus.BAD_REQUEST.value(), "employee code should be atleast 8 characters."),
					HttpStatus.BAD_REQUEST);
		Employee postSave = employeeEntityManager.save(employee);
		HttpHeaders httpHeaders = new HttpHeaders();
		URI entityUri = urib.path(String.valueOf(postSave.getEmployeeId())).build().toUri();
		httpHeaders.setLocation(entityUri);
		return empResponseHelper.getResponseEntity(postSave, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{code}/project", consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<?> createProject(@RequestBody Project project, UriComponentsBuilder urib) {
		if (null != projectEntityManager.findByProjectCode(project.getProjectCode()))
			return errorHelper.getResponseEntity(new Error(HttpStatus.BAD_REQUEST.value(), "Duplicate  user"),
					HttpStatus.FOUND);
		if (project.getProjectCode() == null || project.getProjectCode().length() < 6)
			return errorHelper.getResponseEntity(
					new Error(HttpStatus.BAD_REQUEST.value(), "project code should be atleast 6 characters."),
					HttpStatus.BAD_REQUEST);
		Project postSave = projectEntityManager.save(project);
		HttpHeaders httpHeaders = new HttpHeaders();
		URI entityUri = urib.path(String.valueOf(postSave.getProjectId())).build().toUri();
		httpHeaders.setLocation(entityUri);
		return projResponseHelper.getResponseEntity(postSave, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{code}/role", consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<?> createRole(@RequestBody Role role, UriComponentsBuilder urib) {
		if (null != roleEntityManager.findByRoleName(role.getRoleName()))
			return errorHelper.getResponseEntity(new Error(HttpStatus.BAD_REQUEST.value(), "Duplicate  role"),
					HttpStatus.FOUND);
		Role postSave = roleEntityManager.save(role);
		HttpHeaders httpHeaders = new HttpHeaders();
		URI entityUri = urib.path(String.valueOf(postSave.getRoleId())).build().toUri();
		httpHeaders.setLocation(entityUri);
		return roleResponseHelper.getResponseEntity(postSave, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{code}", consumes = "application/json", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmployee(@PathVariable Employee employee, UriComponentsBuilder urib) {
		if (null != employeeEntityManager.findByEmployeeCode(employee.getCode()))
			return errorHelper.getResponseEntity(new Error(HttpStatus.BAD_REQUEST.value(), "Duplicate  user"),
					HttpStatus.FOUND);
		if (employee.getCode() == null || employee.getCode().length() < 8)
			return errorHelper.getResponseEntity(
					new Error(HttpStatus.BAD_REQUEST.value(), "employee code should be atleast 8 characters."),
					HttpStatus.BAD_REQUEST);
		Employee postSave = employeeEntityManager.save(employee);
		HttpHeaders httpHeaders = new HttpHeaders();
		URI entityUri = urib.path(String.valueOf(postSave.getEmployeeId())).build().toUri();
		httpHeaders.setLocation(entityUri);
		return empResponseHelper.getResponseEntity(postSave, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{code}", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployee(@PathVariable String code, UriComponentsBuilder urib) {
		Employee emp = employeeEntityManager.findByEmployeeCode(code);
		if (null == emp)
			return new ResponseEntity<Error>(new Error(HttpStatus.NOT_FOUND.value(), "employee not found."),
					HttpStatus.NOT_FOUND);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@RequestMapping(produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<?> getAllEmployees() {
		List<Employee> emp = employeeEntityManager.findAll();
		if (null == emp || emp.isEmpty())
			return new ResponseEntity<Error>(new Error(HttpStatus.NOT_FOUND.value(), "no employees registered yet"),
					HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
	}

}
