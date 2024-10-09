package com.rcp.rfg;

import org.springframework.boot.SpringApplication;

public class TestRfgRecipeApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(RfgRecipeApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
