package com.api.ecommerce;

import com.api.ecommerce.models.Category;
import com.api.ecommerce.models.Product;
import com.api.ecommerce.models.Review;
import com.api.ecommerce.models.User;
import com.api.ecommerce.repository.CategoryRepository;
import com.api.ecommerce.repository.ProductRepository;
import com.api.ecommerce.repository.ReviewRepository;
import com.api.ecommerce.repository.UserRepository;
import com.api.ecommerce.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
@AllArgsConstructor
public class ECommerceApplication implements CommandLineRunner {
	ProductRepository productRepository;
	UserRepository userRepository;
	CategoryRepository categoryRepository;
	ReviewRepository reviewRepository;
	PasswordEncoder passwordEncoder;
	InMemoryUserDetailsManager inMemoryUserDetailsManager;
	UserServiceImpl userService;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		populateDatabase();
	}
	public void populateDatabase() {

		//add users to db
		List<User> userList = new ArrayList<>();
		userList.add(new User("coolUser1", "John", "Doe", passwordEncoder.encode("password1"), "123 Main St, Cityville, USA"));
		userList.add(new User("awesomeUser2", "Jane", "Doe", passwordEncoder.encode("password2"), "456 Oak St, Townsville, USA"));
		userList.add(new User("superUser3", "Alice", "Smith", passwordEncoder.encode("password3"), "789 Pine St, Villageton, USA"));
		userList.add(new User("megaUser4", "Bob", "Johnson", passwordEncoder.encode("password4"), "101 Maple St, Hamletville, USA"));
		userList.add(new User("stellarUser5", "Eva", "Williams", passwordEncoder.encode("password5"), "202 Elm St, Riverside, USA"));
		userList.add(new User("powerUser6", "Charlie", "Brown", passwordEncoder.encode("password6"), "303 Cedar St, Summitville, USA"));
		userList.add(new User("alphaUser7", "Grace", "Miller", passwordEncoder.encode("password7"), "404 Birch St, Lakeside, USA"));
		userList.add(new User("novaUser8", "Daniel", "Clark", passwordEncoder.encode("password8"), "505 Walnut St, Mountainview, USA"));
		userList.add(new User("zenithUser9", "Sophia", "Turner", passwordEncoder.encode("password9"), "606 Cherry St, Seaside, USA"));
		userList.add(new User("epicUser10", "Liam", "Johnson", passwordEncoder.encode("password10"), "707 Spruce St, Hilltop, USA"));

		userRepository.saveAll(new HashSet<>(userList));

		List<Product> products = new ArrayList<>();
		List<Category> categories = new ArrayList<>();

		// Creating 11 Category instances
		categories.add(new Category("Electronics".toUpperCase(), "Electronic gadgets"));
		categories.add(new Category("Clothing".toUpperCase(), "Fashionable clothing"));
		categories.add(new Category("Furniture".toUpperCase(), "Home and office furniture"));
		categories.add(new Category("Footwear".toUpperCase(), "Shoes and sneakers"));
		categories.add(new Category("Appliances".toUpperCase(), "Home appliances"));
		categories.add(new Category("Accessories".toUpperCase(), "Fashion accessories"));
		categories.add(new Category("Sports".toUpperCase(), "Sports equipment"));
		categories.add(new Category("Kitchenware".toUpperCase(), "Cookware and kitchen gadgets"));
		categories.add(new Category("Eyewear".toUpperCase(), "Sunglasses and eyeglasses"));
		categories.add(new Category("Gaming".toUpperCase(), "Gaming peripherals"));
		categories.add(new Category("Toys".toUpperCase(), "Children's toys"));
		categoryRepository.saveAll(categories);
		inMemoryUserDetailsManager.createUser(
				org.springframework.security.core.userdetails.User.builder()
						.username("admin")
						.password(passwordEncoder.encode("admin-pass"))
						.roles("ADMIN")
						.build());
		inMemoryUserDetailsManager.createUser(
				org.springframework.security.core.userdetails.User.builder()
						.username("user")
						.password(passwordEncoder.encode("user-pass"))
						.roles("USER")
						.build());


		// Creating 11 Product instances with 10 reviews each
		products.add(new Product("Smartphone", "High-performance smartphone", "smartphone.jpg", new BigDecimal(999.99)));
		products.add(new Product("T-shirt", "Comfortable cotton T-shirt", "tshirt.jpg", new BigDecimal(29.99)));
		products.add(new Product("Desk Chair", "Ergonomic office chair", "deskchair.jpg", new BigDecimal(500.50)));
		products.add(new Product("Running Shoes", "Lightweight running shoes", "runningshoes.jpg", new BigDecimal(249.99)));
		products.add(new Product("Headphones", "Wireless over-ear headphones", "headphones.jpg", new BigDecimal(289.50)));
		products.add(new Product("Backpack", "Spacious backpack for travel", "backpack.jpg", new BigDecimal(399.99)));
		products.add(new Product("Coffee Maker", "Programmable coffee maker", "coffeemaker.jpg", new BigDecimal(799.99)));
		products.add(new Product("Sunglasses", "Stylish polarized sunglasses", "sunglasses.jpg", new BigDecimal(200)));
		products.add(new Product("Gaming Mouse", "High-precision gaming mouse", "gamingmouse.jpg", new BigDecimal(129)));
		products.add(new Product("Barbie Doll", "Classic Barbie Doll for kids", "barbiedoll.jpg", new BigDecimal(25.95)));

		for (int i =0; i < products.size(); i ++){
			userService.addUserToMemory(userList.get(i));
			Set<Review> reviews = createSampleReviews(categories.get(i), products.get(i));
			products.get(i).setCategory(categories.get(i));
			products.get(i).setReviews(reviews);
		}
		productRepository.saveAll(products);
	}

	private  Set<Review> createSampleReviews(Category category, Product p) {
		List<User> userList = (List<User>)userRepository.findAll();
		Set<Review> reviews = new HashSet<>();
		int defaultRating = 3;
		for (int i = 1; i <= 10; i++) {
			String title = "Detailed Review " + i;
			String text = generateReviewText(category, p, defaultRating);
			int rating = (int) (Math.random() * 5) + 1; // Random rating between 1 and 5
			if (category.getTitle().equals("Toys")) {
				// If the category is "Toys," use the default rating
				rating = defaultRating;
			}
			Review r = new Review(title, text, rating);
			r.setProduct(p);
			r.setUser(userList.get(i - 1));
			reviews.add(r);
		}
		return reviews;
	}

	private  String generateReviewText(Category category,Product p,  int defaultRating) {
		String[] positiveAdjectives = {"excellent", "amazing", "superb", "impressive", "outstanding", "exceptional", "fantastic"};
		String[] negativeAdjectives = {"poor", "disappointing", "inferior", "unsatisfactory", "subpar", "lackluster", "mediocre"};

		String aspect = getAspect();
		String adjective = (defaultRating >= 3) ? positiveAdjectives[(int) (Math.random() * positiveAdjectives.length)] :
				negativeAdjectives[(int) (Math.random() * negativeAdjectives.length)];

		String text = "This is a review for " + p.getName() + ". I purchased this product because " +
				"of its reputation for being " + adjective + ". I am ";
		if (defaultRating >= 3) {
			text += "very satisfied with my purchase. ";
		} else {
			text += "disappointed with my purchase. ";
		}
		text += "The " + aspect + " is " + adjective + ", and I find it ";
		if (defaultRating >= 3) {
			text += "excellent in every way. ";
		} else {
			text += "lacking in several aspects. ";
		}
		text += "I would ";
		if (defaultRating >= 3) {
			text += "highly recommend this product to others. ";
		} else {
			text += "not recommend this product. ";
		}

		return text;
	}

	private static String getAspect() {
		String[] aspects = {"performance", "design", "durability", "features", "value", "quality", "usability"};
		return aspects[(int) (Math.random() * aspects.length)];
	}

}
