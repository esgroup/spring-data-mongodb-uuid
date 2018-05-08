package ch.esgroup.springmongouuid.repository;

import ch.esgroup.springmongouuid.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ContactRepository extends MongoRepository<Contact, String> {

  List<Contact> findByOwner(UUID owner);

}
