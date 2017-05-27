package com.hts.util.fixtures;

public class HelloWorld {

	private String name;

	public HelloWorld(String name) {
		this.name = name;
	}

	public String message() {
		return "Hello " + name;
	}

}
