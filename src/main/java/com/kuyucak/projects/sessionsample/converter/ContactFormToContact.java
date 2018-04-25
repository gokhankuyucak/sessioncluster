package com.kuyucak.projects.sessionsample.converter;


import org.springframework.core.convert.converter.Converter;
import com.kuyucak.projects.sessionsample.command.ContactForm;
import com.kuyucak.projects.sessionsample.domain.Contact;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ContactFormToContact implements Converter<ContactForm, Contact>
{
    @Override
    public Contact convert(ContactForm contactForm){
        Contact contact=new Contact();
        if (contactForm.getId() != null  && !StringUtils.isEmpty(contactForm.getId())) {
            contact.setId(new Long(contactForm.getId()));
        }
        contact.setName(contactForm.getName());
        contact.setNumber(contactForm.getNumber());
        return contact;
    }
}
