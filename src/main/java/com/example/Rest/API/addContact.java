package com.example.Rest.API;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class addContact {
List<Contacts> contact = new ArrayList<>();

    @PostMapping("/addContact")
    public String addcontact(@RequestBody Contacts user){


if (user.getName()==null || user.getEmail()==null || user.getPhone()== null){
    return " Failed to add contact! ";

}else {
    for (Contacts emailContact : contact) {
        if (emailContact.getEmail().equals(user.getEmail()))
        {
            return " Contact already exist with this email";
        }

    }
    contact.add(user);
    return " Contact added successfully! ";
}

    }
    @GetMapping("/getContactDetails")
    public  String contactDetails(@RequestParam String name){
        for(Contacts singlContact: contact ){
            if (singlContact.getName().equals(name)){
                return singlContact.toString();
            }
        }
return "Contact not found.";
    }

}
