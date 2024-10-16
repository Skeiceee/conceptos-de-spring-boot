package com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.entities.Address;
import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.entities.Client;
import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.entities.ClientDetails;
import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.entities.Course;
import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.entities.Invoice;
import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.entities.Student;
import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.repositories.ClientDetailsRepository;
import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.repositories.ClientRepository;
import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.repositories.CourseRepository;
import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.repositories.InvoiceRepository;
import com.victor.curso.springboot.jpa.relaciones.sprinboot_jpa_relaciones.repositories.StudentRepository;

@SpringBootApplication
public class SprinbootJpaRelacionesApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private ClientDetailsRepository clientDetailsRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SprinbootJpaRelacionesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		manyToManyFind();
		manyToManyFindRemove();
	}

	@Transactional
	public void manyToManyFindRemove(){
		List<Student> studentsDb = (List<Student>) studentRepository.findAllById(Set.of(1L, 2L));

		Optional<Student> optionalStudentDb = studentsDb.stream().filter(student -> student.getId() == 2L ).findFirst();
		optionalStudentDb.ifPresent(studentDb -> {

			System.out.println("Antes de guardar: " + studentDb);

			Optional<Course> optionalCourseDb = courseRepository.findById(1L);
			optionalCourseDb.ifPresent(courseDb -> {
				System.out.println("Estudiantes del curso: " + courseDb.getStudents());
				studentDb.getCourses().remove(courseDb);

				studentRepository.save(studentDb);
				System.out.println("Despues de guardar: " + studentDb);
			});

		});
	}

	@Transactional
	public void manyToManyFind(){

		Set<Course> courses1 = new HashSet<>();
		Course course1 = courseRepository.findById(1L).orElseThrow();
		Course course2 = courseRepository.findById(2L).orElseThrow();

		courses1.add(course1);
		courses1.add(course2);

		Set<Course> courses2 = new HashSet<>();
		courses2.add(course2);

		List<Student> students = (List<Student>) studentRepository.findAllById(Set.of(1L, 2L));
		students.forEach(student -> {

			if(student.getId() == 2){
				student.setCourses(courses1);
				System.out.println(courses1);
			}
			
			if (student.getId() == 1) {
				student.setCourses(courses2);
				System.out.println(courses2);
			}

			System.out.println(student);
			
		});

		studentRepository.saveAll(students);
	}

	@Transactional
	public void manyToMany(){

		Student student1 = new Student("Victor", "Nuñez"); 
		Student student2 = new Student("Magito", "Explosivo"); 

		Course course1 = new Course("Curso de Laravel", "Este curso enseña como crear una web en Laravel", "Victor Nuñez");
		Course course2 = new Course("Curso de .Net", "Este curso enseña como crear una web en .Net", "Victor Nuñez");
		
		Set<Course> courses1 = new HashSet<>();
		courses1.add(course1);
		courses1.add(course2);

		student1.setCourses(courses1);
		student2.setCourses(Set.of(course2));

		// studentRepository.saveAll(List.of(student1, student2));
		List<Student> studentsSaved = (List<Student>) studentRepository.saveAll(Set.of(student1, student2));
		studentsSaved.forEach(student -> {
			System.out.println(student);
		});
	}

	@Transactional
	public void oneToOne(){

		Client client = new Client("Erba", "Pura");
		ClientDetails clientDetails = new ClientDetails(true, 2000);

		client.setClientDetails(clientDetails);
		clientDetails.setClient(client);
		clientRepository.save(client);
		
		Client clientDb = clientRepository.findById(4L).orElseThrow();

		// ClientDetails clientDetails2 = new ClientDetails(false, 2500);
		// ClientDetails getClientDetails = clientDb.getClientDetails();
		// getClientDetails.setClient(null);
		// clientDb.setClientDetails(null);
		// clientRepository.save(clientDb);

		ClientDetails clientDetailsDb = clientDb.getClientDetails();
		clientDetailsDb.setPremium(false);
		clientDetailsDb.setPoints(3500);
		clientRepository.save(clientDb);

		System.out.println(clientDb);

	}

	@Transactional
	public void removeOneToManyBidireccional() {
		Optional<Client> optionalClient = clientRepository.findOneAll(2L);

		Invoice invoice1 = new Invoice("Factura de computador", 1800000L);
		Invoice invoice2 = new Invoice("Sillas de oficina", 600000L);

		optionalClient.ifPresent(client -> {

			Set<Invoice> invoices = new HashSet<>();
			invoices.add(invoice1);
			invoices.add(invoice2);
			invoices.forEach(invoice -> {
				invoice.setClient(client);
			});
			
			client.setInvoices(invoices);

			Optional<Client> optionalClientDb = Optional.of(clientRepository.save(client));
			
			optionalClientDb.ifPresent(clientDb -> {

				Optional<Invoice> optionalInvoice = invoiceRepository.findById(2L);

				optionalInvoice.ifPresent(invoice -> {
					clientDb.getInvoices().remove(invoice);
					invoice.setClient(null);

					Client clientSavedDb = clientRepository.save(clientDb);
					System.out.println(clientSavedDb.getInvoices());
				});

			});

		});
		
	}

	@Transactional
	public void oneToManyBidireccional() {
		Optional<Client> optionalClient = clientRepository.findById(2L);

		Address address1 = new Address("El verjel", 1234);
		Address address2 = new Address("Vasco de Gama", 2123);
		Address address3 = new Address("El aaaaa", 1234);

		Invoice invoice1 = new Invoice("Factura de computador", 1800000L);
		Invoice invoice2 = new Invoice("Sillas de oficina", 600000L);

		optionalClient.ifPresent(client -> {
			Set<Invoice> invoices = new HashSet<>();
			invoices.add(invoice1);
			invoices.add(invoice2);
			invoices.forEach(invoice -> {
				invoice.setClient(client);
			});

			Set<Address> addresses = new HashSet<>();
			addresses.add(address1);
			addresses.add(address2);
			addresses.add(address3);
			
			client.setInvoices(invoices);
			client.setAddresses(addresses);
			
			clientRepository.save(client);
			System.out.println(client);
		});
	}

	@Transactional
	public void removeAddress() {
		Optional<Client> optionalClient = clientRepository.findById(2L);

		Address address1 = new Address("El1 verjel", 1234);
		Address address2 = new Address("Vasco1 de Gama", 9875);

		optionalClient.ifPresent(client -> {
			Set<Address> addresses = new HashSet<>();
			addresses.add(address1);
			addresses.add(address2);
			client.setAddresses(addresses);
			clientRepository.save(client);
	
			System.out.println(client);
		});

		optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			
			client.getAddresses().remove(new Address(2L));
			System.out.println(client);
			clientRepository.save(client);
			System.out.println(client);

		});
		
	}

	@Transactional
	public void oneToManyFindById() {
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			Address address1 = new Address("El1 verjel", 1234);
			Address address2 = new Address("Vasco1 de Gama", 9875);
			
			Set<Address> addresses = new HashSet<>();
			addresses.add(address1);
			addresses.add(address2);
			client.setAddresses(addresses);
			clientRepository.save(client);
	
			System.out.println(client);
		});
		
	}

	@Transactional
	public void oneToMany(){
		Client client = new Client("Juan", "Soto");

		Address address1 = new Address("Anticlea2", 16);
		Address address2 = new Address("Pocuro2", 1050);
		
		Set<Address> addresses = new HashSet<>();
		addresses.add(address1);
		addresses.add(address2);
		client.setAddresses(addresses);

		clientRepository.save(client);
	}

	@Transactional
	public void manyToOne(){
		Client client = new Client("Jhon", "Doe");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Compras de oficina", 2000L);
		invoice.setClient(client);
		Invoice invoiceSaved = invoiceRepository.save(invoice);

		System.out.println(invoiceSaved);
	}

	@Transactional
	public void manyToOneSearch(){
		Optional<Client> optionalClient = clientRepository.findById(3L);

		if(optionalClient.isPresent()){
			Client client = optionalClient.get();
			System.out.println(client);

			Invoice invoice = new Invoice("Compras de el mes", 200000L);
			invoice.setClient(client);

			Invoice invoiceSaved = invoiceRepository.save(invoice);
			System.out.println(invoiceSaved);
		}

	}

}
