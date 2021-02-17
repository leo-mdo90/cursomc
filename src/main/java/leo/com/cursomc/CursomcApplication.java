package leo.com.cursomc;

import leo.com.cursomc.domain.Category;
import leo.com.cursomc.domain.City;
import leo.com.cursomc.domain.Product;
import leo.com.cursomc.domain.State;
import leo.com.cursomc.repositories.CategoryRepository;
import leo.com.cursomc.repositories.CityRepository;
import leo.com.cursomc.repositories.ProductRepository;
import leo.com.cursomc.repositories.StateRepository;
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
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private StateRepository stateRepository;

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

		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São Paulo");

		City c1 = new City(null, "Uberlandia", est1);
		City c2 = new City(null, "São Paulo", est2);
		City c3 = new City(null, "Campinas", est2);

		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2,c3));

		stateRepository.saveAll(Arrays.asList(est1,est2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));
	}
}
