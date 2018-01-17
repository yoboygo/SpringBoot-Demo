package org.demo.data.web;

import java.util.List;

import org.demo.data.dao.PersonCustomRepository;
import org.demo.data.dao.PersonRepository;
import org.demo.data.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonCustomRepository personCustomRepository;
	
	@RequestMapping("/save")
	public Person save(String name, String address, Integer age) {
		Person p = personRepository.save(new Person(null,name,age,address));
		return p;
	}
	
	@RequestMapping("/auto")
	public Page<Person> auto(Person person){
		Page<Person> pagePeople = personCustomRepository.findByAuto(person, new PageRequest(0, 10));
		return pagePeople;
	}
	
	@RequestMapping("/q/a")
	public List<Person> queryByAddress(String address){
		List<Person> people = personRepository.findByAddress(address);
		return people;
	}
	
	@RequestMapping("/q/na")
	public Person queryByNameAndAddress(String name, String address) {
		Person person = personRepository.findByNameAndAddress(name, address);
		return person;
	}
	
	@RequestMapping("/q/naq")
	public Person queryByNameAndAddressQuery(String name, String address) {
		Person person = personRepository.withNameAndAddressQuery(name, address);
		return person;
	}
	
	@RequestMapping("/q/nanq")
	public Person queryByNameAndAddressNamedQuery(String name, String address) {
		Person person = personRepository.withNameAndAddressNamedQuery(name, address);
		return person;
	}
	
	@RequestMapping("/sort")
	public List<Person> sort(){
		List<Person> people = personRepository.findAll(new Sort(Direction.ASC,"age"));
		return people;
	}

	@RequestMapping("/page")
	public Page<Person> page(){
		Page<Person> pagePeople = personRepository.findAll(new PageRequest(1, 2));
		return pagePeople;
	}
}
