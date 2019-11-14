package me.samuel;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class GuestBookController {

    private GuestBook guestBook = GuestBook.getInstance();

    @RequestMapping("/")
    public String index(){
        StringBuilder output = new StringBuilder();
        output.append("Du bist im GästebuchController! <br>");
        guestBook.fetchEntries().forEach(entry -> output.append(entry).append("<br>"));

        return output.toString();
    }

    @GetMapping("/entry/{id}")
    public GuestBookEntry show(@PathVariable String id){
        int guestBookID = Integer.parseInt(id);
        return guestBook.getEntryById(guestBookID);
    }

    @PostMapping(path = "/insert", consumes = "application/json")
    public ResponseEntity<Void> insert(@RequestBody String input){
        JSONObject jsonInput = new JSONObject(input);
        int id = guestBook.fetchEntries().size()+1;
        GuestBookEntry entry = new GuestBookEntry(id,jsonInput.getString("eMail"), jsonInput.getString("name"), jsonInput.getString("text"));
        guestBook.fetchEntries().add(entry);
        URI location = URI.create("/entry/"+id);
        return ResponseEntity.created(location).build();
    }
}
