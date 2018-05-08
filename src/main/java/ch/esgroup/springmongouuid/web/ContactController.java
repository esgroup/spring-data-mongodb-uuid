package ch.esgroup.springmongouuid.web;

import ch.esgroup.springmongouuid.model.Contact;
import ch.esgroup.springmongouuid.repository.ContactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contacts")
public class ContactController {

  private final ContactRepository contactRepository;

  public ContactController(ContactRepository contactRepository) {
    this.contactRepository = contactRepository;
  }

  @PostMapping("/init")
  public void init() {
    var owner1 = UUID.fromString("77a699fe-faca-46a5-97c0-1b86a0f5cd0f");
    var owner2 = UUID.fromString("e286ae86-9a06-4039-8654-35a6f7651f32");

    var owner1Contacts = List.of(new Contact(owner1, "A1", "A2", "a@gmail.com"),
                                 new Contact(owner1, "B1", "B2", "b@gmail.com"),
                                 new Contact(owner1, "C1", "C2", "c@gmail.com"));

    var owner2Contacts = List.of(new Contact(owner2, "D1", "D2", "d@gmail.com"),
                                 new Contact(owner2, "E1", "E2", "e@gmail.com"),
                                 new Contact(owner2, "F1", "F2", "f@gmail.com"));

    contactRepository.saveAll(owner1Contacts);
    contactRepository.saveAll(owner2Contacts);
  }

  @GetMapping
  public List<Contact> findAll() {
    return contactRepository.findAll();
  }

  @GetMapping("/{owner}")
  public List<Contact> findByOwner(@PathVariable("owner") UUID owner) {
    return contactRepository.findByOwner(owner);
  }

}
