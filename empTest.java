package com.verizon.edb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.edb.restapi.EmployeeApi;
import com.verizon.edb.service.EmployeeService;
import com.verizon.esd.TestUtil.TestUtil;
import com.verizon.edb.model.Employee;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = EmployeeApi.class)
public class empTest {
	
	private MockMvc mockMvc;

	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private EmployeeService empServiceMock;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockMvc = null;
	}

	@Test
	public void testGetAllEmployees() throws Exception {
		assertThat(this.empServiceMock).isNotNull();

		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee());

		when(empServiceMock.getAllEmployees()).thenReturn(empList);

		mockMvc.perform(get("/employees")).andExpect(status().isOk()).andDo(print());

	}
	@Test
	public void testGetEmployeeById() throws Exception {
		assertThat(this.empServiceMock).isNotNull();
		int empId = 13;
	

		Employee emp = new Employee();

		emp.setEmpId(13);
		emp.setFirstName("Hema");
		emp.setLastName("Besetti");

		emp.setBasic(8977);
		emp.setHra(45);
		emp.setDept("Sales");

		when(empServiceMock.getEmployeeById(empId)).thenReturn(emp);

		mockMvc.perform(get("/employees/13")).andExpect(status().isOk()).andDo(print());

	}
	
@Test
	public void testAddEmployee() throws Exception {		assertThat(this.empServiceMock).isNotNull();
		Employee emp = new Employee();

		emp.setEmpId(12);
		emp.setFirstName("Bhargavi");
		emp.setLastName("P");

		emp.setBasic(8977);
		emp.setHra(45);
		emp.setDept("Sales");

		Employee emp2 = new Employee();
	emp2.setEmpId(13);
		emp2.setFirstName("Hema");
		emp2.setLastName("Besetti");

		emp2.setBasic(8977);
		emp2.setHra(45);
		emp2.setDept("Sales");
	System.out.println(emp);

	when(empServiceMock.addEmployee(Mockito.any(Employee.class))).thenReturn(emp2);

		mockMvc.perform(post("/employees").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(emp))).andDo(print()).andExpect(status().isOk())
			.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));
}
	
	
	@Test
	public void testDeleteEmployee() throws Exception {
		assertThat(this.empServiceMock).isNotNull();

		int empId = 1;

		when(empServiceMock.deleteEmployee(empId)).thenReturn(true);

		mockMvc.perform(delete("/employees/1")).andExpect(status().isOk()).andDo(print());

	}
	
	
}
