package com.springboot.jpa.springboot_jpa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.springboot_jpa.dto.UserDTO;
import com.springboot.jpa.springboot_jpa.entities.User;
import com.springboot.jpa.springboot_jpa.repositories.UserRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// list();
		// findOne();
		// create();
		update();
		// delete();
		// getStringName();
		// getListFullName();
		// findAllUser();
		// findAllMixUser();
		// findAllClassUser();
		// findAllClassUserDTO();
		// findAllClassDistinctUser();
		// fullnameConcat();
		// fullnameUpperConcat();
		// fullnameLowerConcat();
		// findByIdBetween(1L, 2L);
		// findByIdBetweenAndNameLike(1L, 2L, "%ic%");
		// findByIdBetweenOrderByNameAndLastname(1L, 5L);
		// countUsers();
		// minUsers();
		// maxUsers();
		// lengthUsers();
		// minLengthUsers();
		// maxLengthUsers();
		// getShorterName();
		// getLongerName();
		// whereIn();
	}

	@Transactional(readOnly = true)
	public void whereIn(){
		List<Object[]> users = userRepository.whereIn(Arrays.asList(1L, 4L));

		users.stream().forEach(user -> {
			StringBuilder stringBuilder = new StringBuilder();
			for(Object item : user){
				if(item instanceof User userObject){
					System.out.println(userObject);
				}else{
					stringBuilder.append(item);
					stringBuilder.append(" ");
				}
			}
			System.out.println(stringBuilder);
		});
	}

	@Transactional(readOnly = true)
	public void getLongerName(){
		List<Object[]> users = userRepository.getLongerName();

		users.stream().forEach(user -> {
			StringBuilder stringBuilder = new StringBuilder();
			for(Object item : user){
				if(item instanceof User userObject){
					System.out.println(userObject);
				}else{
					stringBuilder.append(item);
					stringBuilder.append(" ");
				}
			}
			System.out.println(stringBuilder);
		});
	}

	@Transactional(readOnly = true)
	public void getShorterName(){
		List<Object[]> users = userRepository.getShorterName();

		users.stream().forEach(user -> {
			StringBuilder stringBuilder = new StringBuilder();
			for(Object item : user){
				if(item instanceof User userObject){
					System.out.println(userObject);
				}else{
					stringBuilder.append(item);
					stringBuilder.append(" ");
				}
			}
			System.out.println(stringBuilder);
		});
	}

	@Transactional(readOnly = true)
	public void minLengthUsers(){
		List<Object[]> users = userRepository.minLengthUsers();

		users.stream().forEach(user -> {
			StringBuilder stringBuilder = new StringBuilder();
			for(Object item : user){
				stringBuilder.append(item);
				stringBuilder.append(" ");
			}
			System.out.println(stringBuilder);
		});
	}

	@Transactional(readOnly = true)
	public void maxLengthUsers(){
		List<Object[]> users = userRepository.maxLengthUsers();

		users.stream().forEach(user -> {
			StringBuilder stringBuilder = new StringBuilder();
			for(Object item : user){
				stringBuilder.append(item);
				stringBuilder.append(" ");
			}
			System.out.println(stringBuilder);
		});
	}

	@Transactional(readOnly = true)
	public void lengthUsers(){
		List<Object[]> users = userRepository.lengthUsers();

		users.stream().forEach(user -> {
			StringBuilder stringBuilder = new StringBuilder();
			for(Object item : user){
				if(item instanceof User userObject){
					System.out.println(userObject);
				}else{
					stringBuilder.append(item);
					stringBuilder.append(" ");
				}
			}
			System.out.println(stringBuilder);
		});
	}

	@Transactional(readOnly = true)
	public void minUsers(){
		// List<User> users = userRepository.findByIdBetweenOrderByNameDesc(min, max);
		Long minUsers = userRepository.minUsers();
		System.out.println(Long.toString(minUsers));
	}

	@Transactional(readOnly = true)
	public void maxUsers(){
		// List<User> users = userRepository.findByIdBetweenOrderByNameDesc(min, max);
		Long maxUsers = userRepository.maxUsers();
		System.out.println(Long.toString(maxUsers));
	}

	@Transactional(readOnly = true)
	public void countUsers(){
		// List<User> users = userRepository.findByIdBetweenOrderByNameDesc(min, max);
		Long countUsers = userRepository.countUsers();
		System.out.println(Long.toString(countUsers));
	}

	@Transactional(readOnly = true)
	public void findByIdBetweenOrderByNameAndLastname(Long min, Long max){
		// List<User> users = userRepository.findByIdBetweenOrderByNameDesc(min, max);
		List<User> users = userRepository.findByIdBetweenOrderByLastnameAscNameDesc(min, max);

		users.stream().forEach(user -> {
			System.out.println(user);
		});
	}

	@Transactional(readOnly = true)
	public void findByIdBetweenAndNameLike(Long min, Long max, String name){
		List<User> users = userRepository.findByIdBetweenAndNameLike(min, max, name);

		users.stream().forEach(user -> {
			System.out.println(user);
		});
	}
	
	@Transactional(readOnly = true)
	public void findByIdBetween(Long min, Long max){
		List<User> users = userRepository.findByIdBetween(min, max);

		users.stream().forEach(user -> {
			System.out.println(user);
		});
	}

	@Transactional(readOnly = true)
	public void betweenExample(Integer min, Integer max){
		List<User> users = userRepository.betweenExample(min, max);

		users.stream().forEach(user -> {
			System.out.println(user);
		});
	}

	@Transactional(readOnly = true)
	public void fullnameLowerConcat(){
		List<String> users = userRepository.fullnameLowerConcat();

		users.stream().forEach(user -> {
			System.out.println(user);
		});
	}

	@Transactional(readOnly = true)
	public void fullnameUpperConcat(){
		List<String> users = userRepository.fullnameUpperConcat();

		users.stream().forEach(user -> {
			System.out.println(user);
		});
	}

	@Transactional(readOnly = true)
	public void fullnameConcat(){
		List<String> users = userRepository.fullnameConcat();

		users.stream().forEach(user -> {
			System.out.println(user);
		});
	}

	@Transactional(readOnly = true)
	public void findAllClassDistinctUser(){
		List<String> users = userRepository.findAllClassDistinctUser();

		users.stream().forEach(user -> {
			System.out.println(user);
		});
	}

	@Transactional(readOnly = true)
	public void findAllClassUserDTO(){
		List<UserDTO> users = userRepository.findAllClassUserDTO();

		users.stream().forEach(user -> {
			System.out.println(user.getName() + " " + user.getLastname());
		});
	}

	@Transactional(readOnly = true)
	public void findAllClassUser(){
		List<User> users = userRepository.findAllClassUser();

		users.stream().forEach(user -> {
			System.out.println(user.getName() + " " + user.getLastname() + " | " + user.getAge());
		});
	}

	@Transactional(readOnly = true)
	public void findAllMixUser(){
		List<Object[]> users = userRepository.findAllMixUser();

		users.stream().forEach(user -> {
			StringBuilder stringBuilder = new StringBuilder();
			for(Object item : user){
				if(item instanceof User userObject){
					System.out.println(userObject);
				}else{
					stringBuilder.append(item);
					stringBuilder.append(" ");
				}
			}
			System.out.println(stringBuilder);
		});
	}

	@Transactional(readOnly = true)
	public void findAllUser(){
		// List<Object[]> usersFullname = userRepository.getListFullName();
		List<Object[]> usersFullname = userRepository.findAllUser();

		usersFullname.stream().forEach(userFullname -> {
			StringBuilder stringBuilder = new StringBuilder();
			for (Object item : userFullname) {
				stringBuilder.append(item);
				stringBuilder.append(" ");
			}                     
			System.out.println(stringBuilder);
		});

	}

	@Transactional(readOnly = true)
	public void getListFullName(){
		// List<Object[]> usersFullname = userRepository.getListFullName();
		List<String> usersFullname = userRepository.getListFullName();

		usersFullname.stream().forEach(userFullname -> {
			System.out.println(userFullname);
		});

	}

	@Transactional(readOnly = true)
	public void getStringName(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("============================");
		System.out.println("Ingrese el id del usuario : ");
		System.out.println("============================");
		Long id = scanner.nextLong();

		// String name = userRepository.getNameById(id);
		String name = userRepository.getFullNameById(id);
		System.out.println(name);
	}

	@Transactional
	public void delete(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id del usuario a eliminar: ");
		Long id = scanner.nextLong();

		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			userRepository.delete(user); // Por el entity
			userRepository.deleteById(user.getId()); // Por id
		}else{
			System.out.println("No elimino nada.");
		}

		scanner.close();
	}

	@Transactional
	public void update(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id del usuario: ");
		Long id = scanner.nextLong();

		Optional<User> optionalUser = userRepository.findById(id);

		optionalUser.ifPresentOrElse(user -> {
			System.out.println("Ingrese su nueva edad: ");
			Integer age = scanner.nextInt();
			user.setAge(age);
			userRepository.save(user);
			System.out.println(user.getName() + " "  + user.getLastname() + " | nueva edad: " + user.getAge());
		},
		() -> System.out.println("El usuario no existe."));

		// if (optionalUser.isPresent()) {

		// 	User user = optionalUser.get();

		// 	System.out.println("Ingrese su nueva edad: ");
		// 	Integer age = scanner.nextInt();
		// 	user.setAge(age);

		// 	userRepository.save(user);

		// 	System.out.println(user.getName() + " "  + user.getLastname() + " | nueva edad: " + user.getAge());
		// }else{
		// 	System.out.println("El usuario no existe.");
		// }

		scanner.close();

	}

	@Transactional
	public void create(){

		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		String lastname = scanner.next();
		String s_age = scanner.next();
		scanner.close();

		Integer age = Integer.parseInt(s_age); 

		// User user = new User(null, name, lastname, age);
		// User newUser = userRepository.save(user);

		// userRepository.findById(newUser.getId()).ifPresent(System.out::println);
	}

	@Transactional(readOnly = true)
	public void findOne(){

		// User user = userRepository.findById(2L).orElseThrow();
		User user = null;

		// Optional<User> optionalUser = userRepository.findById(2L);
		// Optional<User> optionalUser = userRepository.findOne(2L);

		// Optional<User> optionalUser = userRepository.findOneLikeName("Vic");
		// if(optionalUser.isPresent()){
		// 	user = optionalUser.get();
		// 	System.out.println(user.getName());
		// }

		List<Optional<User>> optionalUser = userRepository.findAllLikeName("vie");

		optionalUser.stream().forEach( u -> {
			if(u.isPresent()){
				System.out.println(u.get().getName());
			}
		});

	}

	@Transactional(readOnly = true)
	public void list(){
		List<User> users = (List<User>) userRepository.findByNameAndLastname("Victor", "Nuñez");

		users.stream().forEach( user -> {

			StringBuilder stringBuilder = new StringBuilder();

			stringBuilder.append(user);

			System.out.println(stringBuilder);

		});


		List<Object[]> users2 = userRepository.getUserData();

		users2.stream().forEach( user -> {

			StringBuilder stringBuilder = new StringBuilder();

			stringBuilder.append(user[0]);
			stringBuilder.append(" ");
			stringBuilder.append(user[1]);

			System.out.println(stringBuilder);

		});
	}
}
