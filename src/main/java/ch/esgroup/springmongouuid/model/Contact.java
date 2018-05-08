package ch.esgroup.springmongouuid.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@TypeAlias("Contact")
public class Contact {

  @Id
  private String id;

  private UUID owner;

  private String firstName;
  private String lastName;
  private String email;

  public Contact(UUID owner, String firstName, String lastName, String email) {
    this.owner = owner;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public UUID getOwner() {
    return owner;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

}
