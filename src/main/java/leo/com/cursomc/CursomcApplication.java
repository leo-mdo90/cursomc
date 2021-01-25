package leo.com.cursomc;

import leo.com.cursomc.domain.Category;
import leo.com.cursomc.domain.Product;
import leo.com.cursomc.repositories.CategoryRepository;
import leo.com.cursomc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

import static java.sql.Types.NULL;
import static java.util.Arrays.asList;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Informatica");
		Category cat2 = new Category(null, "Escritório");

		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 50.00);

		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(asList(cat1, cat2));
		productRepository.saveAll(asList(p1,p2,p3));
	}
}
