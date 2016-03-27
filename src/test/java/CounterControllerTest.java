import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;

import com.example.counter.data.Product;
import com.example.counter.rest.SimpleCounterController;
import com.example.counter.services.ProductService;

public class CounterControllerTest {

	@Mock
	private ProductService productService;

	@InjectMocks
	private SimpleCounterController simpleController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		// Process mock annotations
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(simpleController).build();
	}

	@Test
	public void lookup() throws Exception {
		this.mockMvc.perform(get("/counter/product/lookup/").param("query", "prod"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void blankLookup() throws Exception {
		final List<Product> products = simpleController.productLookup("");
		Assert.state(products.isEmpty());
	}

	@Configuration
	public static class TestConfiguration {

		@Bean
		public SimpleCounterController simpleCounterController() {
			return new SimpleCounterController();
		}

	}

}
