package com.jv5.jv5backend.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class Test {

	@GetMapping("/test/{id}")
	public ArrayList<String> test(@RequestParam String string){
		
		ArrayList<String> tString = new ArrayList<String>();
		tString.add("tesT");
		tString.add("Test1");
		tString.add("tes2");
		return tString;
	}
}
