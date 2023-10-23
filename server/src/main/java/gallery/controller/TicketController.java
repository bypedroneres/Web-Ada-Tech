package gallery.controller;

import gallery.domain.dto.ticket.*;
import gallery.domain.entities.Ticket;
import gallery.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("tickets")
public class TicketController {
    @Autowired
    private TicketService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TicketResponseDTO> save(@RequestBody TicketPostDTO dados, UriComponentsBuilder uriBuilder){
        Ticket ticket = new Ticket(dados);
        service.save(ticket);

        URI uri = uriBuilder.path("/tickets/{id}").buildAndExpand(ticket.getId()).toUri();

        return ResponseEntity.created(uri).body(new TicketResponseDTO(ticket));
    }

    @GetMapping
    public ResponseEntity<Page<TicketResponseDTO>> findAll(@PageableDefault(size = 10, sort = {"event"}) Pageable paginacao){
        return ResponseEntity.ok(service.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> findById(@PathVariable Long id){
        TicketResponseDTO ticket = service.findById(id);
        return ResponseEntity.ok(ticket);
    }

    @PutMapping
    public ResponseEntity<TicketResponseDTO> update(@RequestBody TicketPutDTO dados){
        return ResponseEntity.ok(service.update(dados));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long id
    ) {
        service.remove(id);
    }
}
