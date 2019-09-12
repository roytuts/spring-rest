package roytuts.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import roytuts.model.Product;
import roytuts.sevice.ProductService;

@RestController
public class SpringRestController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductByid(@PathVariable("id") int id) {
		Product product = productService.findProductById(id);
		if (product == null) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ResponseEntity<Void> saveProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
		if (product == null || product.getName() == null || "".equals(product.getName())) {
			throw new RuntimeException("Product Name and Price are required fields");
		}

		if (productService.isProductAvailable(product)) {
			System.out.println("A Product with name " + product.getName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		productService.saveProduct(product);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/product", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateProduct(@RequestBody Product product) {
		if (product == null || product.getName() == null || "".equals(product.getName()) || product.getId() <= 0) {
			throw new RuntimeException("Product Name, Id, Price are required fields");
		}

		Product currentProduct = productService.findProductById(product.getId());
		if (currentProduct == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		productService.updateProduct(product);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProductByid(@PathVariable("id") int id) {
		Product currentProduct = productService.findProductById(id);
		if (currentProduct == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		productService.deleteProductById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
