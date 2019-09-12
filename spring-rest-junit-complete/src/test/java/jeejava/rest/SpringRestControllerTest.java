package roytuts.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import roytuts.model.Product;
import roytuts.sevice.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class SpringRestControllerTest {
	@Mock
	private ProductService service;

	private MockMvc mockMvc;

	@Spy
	@InjectMocks
	private SpringRestController controller = new SpringRestController();

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testGetProductById() throws Exception {
		Product product = new Product();
		product.setId(1);
		product.setName("Product name");
		product.setPrice(21540.00);
		Mockito.when(service.findProductById(Mockito.anyInt())).thenReturn(product);
		mockMvc.perform(MockMvcRequestBuilders.get("/product/1")).andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
	}

	@Test
	public void testSaveProduct() throws Exception {
		Product product = new Product();
		product.setId(1);
		product.setName("Product name");
		product.setPrice(21540.00);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(product);
		Mockito.when(service.isProductAvailable(Mockito.any(Product.class))).thenReturn(false);
		Mockito.doNothing().when(service).saveProduct(Mockito.any(Product.class));
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/product").content(jsonString)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(201)).andReturn();
		Assert.assertEquals(201, result.getResponse().getStatus());
	}

	@Test
	public void testUpdateProduct() throws Exception {
		Product product = new Product();
		product.setId(1);
		product.setName("Product name");
		product.setPrice(21540.00);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(product);
		Mockito.when(service.findProductById(Mockito.anyInt())).thenReturn(product);
		Mockito.doNothing().when(service).updateProduct(Mockito.any(Product.class));
		mockMvc.perform(
				MockMvcRequestBuilders.put("/product").content(jsonString).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void testDeleteProductByid() throws Exception {
		Product product = new Product();
		product.setId(1);
		product.setName("Product name");
		product.setPrice(21540.00);
		Mockito.when(service.findProductById(Mockito.anyInt())).thenReturn(product);
		Mockito.doNothing().when(service).deleteProductById(Mockito.anyInt());
		mockMvc.perform(MockMvcRequestBuilders.delete("/product/1")).andExpect(MockMvcResultMatchers.status().is(200));
	}
}