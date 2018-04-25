package com.kuyucak.projects.sessionsample.repository;

import com.kuyucak.projects.sessionsample.domain.Contact;
import org.springframework.data.repository.CrudRepository;

//https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html

public interface ContactRepository extends CrudRepository<Contact, Long>
{

}
