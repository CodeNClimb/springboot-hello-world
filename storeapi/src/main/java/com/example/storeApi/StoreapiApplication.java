package com.example.storeApi;

import com.example.storeApi.models.Product;
import com.example.storeApi.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
@EnableWebSecurity

public class StoreapiApplication implements CommandLineRunner {
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(StoreapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String[] names = {"Blue Bike", "Green Laptop", "Silver Watch", "Yellow Umbrella", "Black Sunglasses", "White Shoes", "Orange Backpack", "Purple Headphones", "Gray Camera", "Brown Wallet"};
		String[] descriptions = {
				"A sleek and fast bike for urban commuting.",
				"Powerful laptop with high-performance features.",
				"Elegant silver watch with a classic design.",
				"Bright yellow umbrella to keep you dry in the rain.",
				"Stylish black sunglasses for a trendy look.",
				"Comfortable white shoes for everyday wear.",
				"Vibrant orange backpack for your essentials.",
				"High-quality purple headphones for immersive audio.",
				"Compact gray camera for capturing memorable moments.",
				"Classic brown wallet with multiple compartments."
		};
		String[] imageLinks = {
				"https://example.com/image1.jpg",
				"https://example.com/image2.jpg",
				"https://example.com/image3.jpg",
				"https://example.com/image4.jpg",
				"https://example.com/image5.jpg",
				"https://example.com/image6.jpg",
				"https://example.com/image7.jpg",
				"https://example.com/image8.jpg",
				"https://example.com/image9.jpg",
				"https://example.com/image10.jpg"
		};



		List<Product> products = new ArrayList<>();
		for (int i = 0; i < names.length; i ++) {
			products.add(new Product(names[i], descriptions[i], imageLinks[i]));
		}
		productRepository.saveAll(products);

	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
