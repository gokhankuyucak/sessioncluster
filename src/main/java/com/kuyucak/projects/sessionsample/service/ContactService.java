package com.kuyucak.projects.sessionsample.service;


import java.util.List;

import com.kuyucak.projects.sessionsample.command.ContactForm;
import com.kuyucak.projects.sessionsample.domain.Contact;

public interface ContactService
{
    List<Contact> listAll();

    Contact getById(Long id);

    Contact saveOrUpdate(Contact contact);

    void delete(Long id);

    Contact saveOrUpdateContactForm(ContactForm contactForm);
}
