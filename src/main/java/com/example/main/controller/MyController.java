package com.example.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.list.DataList;
import com.example.main.list.ListService;

@RestController
public class MyController {

	@Autowired
	ListService ls;

	@RequestMapping("/hello")
	public List<DataList> hi() {
		return ls.returnList();
	}

	@RequestMapping("/hello/{id}")
	public DataList getTopic(@PathVariable String id) {
		return ls.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/hello")
	public String addTopic(@RequestBody DataList dl) {
		ls.addTopic(dl);

		return "topic added";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/hello/{id}")
	public String updateTopic(@RequestBody DataList dl, @PathVariable String id) {
		ls.updateTopic(dl, id);

		return "topic updated";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/hello/{id}")
	public String deleteTopic(@PathVariable String id) {
		ls.deleteTopic(id);
		return "topic deleted";
	}
}
