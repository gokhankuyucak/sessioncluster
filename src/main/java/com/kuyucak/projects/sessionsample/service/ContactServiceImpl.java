package com.kuyucak.projects.sessionsample.service;

import java.util.ArrayList;
import java.util.List;

import com.kuyucak.projects.sessionsample.command.ContactForm;
import com.kuyucak.projects.sessionsample.converter.ContactFormToContact;
import com.kuyucak.projects.sessionsample.domain.Contact;
import com.kuyucak.projects.sessionsample.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService
{
    private ContactRepository contactRepository;
    private ContactFormToContact contactFormToContact;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository,ContactFormToContact contactFormToContact){
        this.contactRepository = contactRepository;
        this.contactFormToContact = contactFormToContact;
    }

    @Override
    public List<Contact> listAll()
    {
        List<Contact> contacts= new ArrayList<>();
        contactRepository.findAll().forEach(contacts::add);
        return contacts;
    }

    @Override
    public Contact getById(Long id)
    {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact saveOrUpdate(Contact contact)
    {
        contactRepository.save(contact);
        return contact;
    }

    @Override
    public void delete(Long id)
    {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact saveOrUpdateContactForm(ContactForm contactForm)
    {
        Contact contact=saveOrUpdate(contactFormToContact.convert(contactForm));
        return contact;
    }
}
