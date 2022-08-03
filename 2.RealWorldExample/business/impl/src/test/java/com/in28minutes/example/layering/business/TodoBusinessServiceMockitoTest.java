package com.in28minutes.example.layering.business;

import com.in28minutes.example.layering.SpringTestContext;
import com.in28minutes.example.layering.business.impl.TodoBusinessServiceImpl;
import com.in28minutes.example.layering.data.api.TodoDataService;
import com.in28minutes.example.layering.model.api.client.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringTestContext.class)
public class TodoBusinessServiceMockitoTest {

	@Mock
	private TodoDataService todoDs;

	@InjectMocks
	private TodoBusinessServiceImpl todoBs;

	@BeforeEach
	public void initializeMockito() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRetrieveTodosRelatedToSpring() {

		List<Todo> todos = Arrays.asList(new Todo(
				"Mockito - Complete Spring Tutorial", new Date(), false),
				new Todo("Mockito - Complete Spring MVC Tutorial", new Date(),
						false), new Todo("Mockito - Complete All Tutorials",
								new Date(), false));

		when(todoDs.retrieveTodos(anyString())).thenReturn(todos);

		List<Todo> filteredTodos = todoBs
				.retrieveTodosRelatedToSpring("dummyUser");

		assertEquals(2, filteredTodos.size());
	}
}