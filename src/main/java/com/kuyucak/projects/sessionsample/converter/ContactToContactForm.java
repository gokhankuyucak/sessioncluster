package com.kuyucak.projects.sessionsample.converter;

import org.springframework.core.convert.converter.Converter;
import com.kuyucak.projects.sessionsample.command.ContactForm;
import com.kuyucak.projects.sessionsample.domain.Contact;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ContactToContactForm implements  Converter<Contact, ContactForm>
{
    @Override
    public ContactForm convert(Contact contact){
        ContactForm contactForm=new ContactForm(contact.getId(),contact.getName(),contact.getNumber());
        return contactForm;
    }
}
