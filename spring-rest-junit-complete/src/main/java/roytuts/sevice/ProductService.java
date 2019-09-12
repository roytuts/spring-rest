package roytuts.sevice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import roytuts.model.Product;

@Service
public class ProductService {
	private static AtomicInteger counter = new AtomicInteger();

	private static List<Product> products;

	static {
		products = populateProducts();
	}

	public Product findProductById(int id) {
		for (Product product : products) {
			if (id == product.getId()) {
				return product;
			}
		}
		return null;
	}

	public void saveProduct(Product product) {
		product.setId(counter.incrementAndGet());
		products.add(product);
	}

	public void updateProduct(Product product) {
		int index = products.indexOf(product);
		products.set(index, product);
	}

	public void deleteProductById(int id) {
		Iterator<Product> it = products.iterator();
		while (it.hasNext()) {
			Product product = it.next();
			if (id == product.getId()) {
				it.remove();
			}
		}
	}

	public boolean isProductAvailable(Product product) {
		return findProductById(product.getId()) != null;
	}

	private static List<Product> populateProducts() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(counter.incrementAndGet(), "Mobile", 25498.00));
		products.add(new Product(counter.incrementAndGet(), "Desktop", 32658.00));
		products.add(new Product(counter.incrementAndGet(), "Laptop", 52147.00));
		products.add(new Product(counter.incrementAndGet(), "Tab", 18254.00));
		return products;
	}

}
