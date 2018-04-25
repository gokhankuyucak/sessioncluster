package com.kuyucak.projects.sessionsample.controller;

import com.kuyucak.projects.sessionsample.command.ContactForm;
import com.kuyucak.projects.sessionsample.converter.ContactToContactForm;
import com.kuyucak.projects.sessionsample.domain.Contact;
import com.kuyucak.projects.sessionsample.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ContactController
{
    private ContactService contactService;
    private ContactToContactForm contactToContactForm;

    @Autowired
    public void setContactToContactForm(ContactToContactForm contactToContactForm){
        this.contactToContactForm=contactToContactForm;
    }

    @Autowired
    public void setContactService(ContactService contactService)
    {
        this.contactService=contactService;
    }

    @RequestMapping({"/contact/list", "/contact"})
    public String listContacts(Model model){
        model.addAttribute("contacts", contactService.listAll());
        return "contact/list";
    }

    @RequestMapping("/contact/show/{id}")
    public String getContact(@PathVariable String id, Model model){
        model.addAttribute("contact", contactService.getById(Long.valueOf(id)));
        return "contact/show";
    }

    @RequestMapping("contact/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Contact contact = contactService.getById(Long.valueOf(id));
        ContactForm contactForm = contactToContactForm.convert(contact);

        model.addAttribute("contactForm", contactForm);
        return "contact/contactform";
    }

    @RequestMapping("/contact/new")
    public String newContact(Model model){
        model.addAttribute("contactForm", new ContactForm());
        return "contact/contactform";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String saveOrUpdateContact(@Valid ContactForm contactForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "contact/contactform";
        }
        Contact savedContact = contactService.saveOrUpdateContactForm(contactForm);

        return "redirect:/contact/show/" + savedContact.getId();
    }

    @RequestMapping("/contact/delete/{id}")
    public String delete(@PathVariable String id){
        contactService.delete(Long.valueOf(id));
        return "redirect:/contact/list";
    }

}
