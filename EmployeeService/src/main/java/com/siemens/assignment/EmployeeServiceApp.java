package com.siemens.assignment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siemens.assignment.entity.Address;
import com.siemens.assignment.entity.Employee;
import com.siemens.assignment.entity.Project;
import com.siemens.assignment.entity.Role;
import com.siemens.assignment.entity.Task;

@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient
public class EmployeeServiceApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApp.class, args);

	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EmployeeServiceApp.class);
	}
	
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
            
            System.out.println("employee string representation");
            Employee emp = new Employee();
            Address addr = new Address();
//            addr.setAddressId(1l);
            addr.setCity("Pune");
            addr.setCountry("India");
            addr.setHouseNo("B-404");
            addr.setStreetName("Park Street, Wakad");
            addr.setState("MAH");
            Project proj = new Project();
//            proj.setProjectId(1l);
            proj.setProjectCode("MSPHERE");
            proj.setProjectName("MindSphere");
            Role role = new Role();
//            role.setRoleId(1l);
            role.setRoleName("Software Developer Advanced");
            role.setDesc("Advanced");
            Set<Role> roles = new HashSet<Role>();
            roles.add(role);
            Set<Project> projects = new HashSet<Project>();
            projects.add(proj);
            emp.setEmployeeAddress(addr);
            emp.setCode("7645123");
//            emp.setEmployeeId(1l);
            emp.setEmployeeName("Amit Karir");
            emp.setProject(proj);
            emp.setRoles(roles);
            Task task = new Task();
            task.setPriority(1);
//            task.setTaskId(1l);
            task.setTaskName("Develop exercise 1");
            Set<Employee> employees = new HashSet<Employee>();
//            emp.setTask(task);
            employees.add(emp);
            Set<Task> tasks = new HashSet<Task>();
            tasks.add(task);
            //task.setEmployees(employees);
            proj.setTasks(tasks);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(emp));

        };
    }

}
