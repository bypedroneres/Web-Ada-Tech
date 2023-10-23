package gallery.service;

import gallery.domain.dto.ticket.TicketPutDTO;
import gallery.domain.dto.ticket.TicketResponseDTO;
import gallery.domain.entities.Ticket;
import gallery.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TicketService {

    @Autowired
    private TicketRepository repository;

    public void save(Ticket ticket) {
        repository.save(ticket);
    }

    public Page<TicketResponseDTO> findAll(Pageable paginacao) {
        return repository.findAllDeletedFalse(paginacao).map(TicketResponseDTO::new);
    }

    public TicketResponseDTO findById(Long id) {
        return new TicketResponseDTO(repository.getReferenceByIdAndDeletedFalse(id));
    }

    public TicketResponseDTO update(TicketPutDTO dados) {
        Ticket ticket = repository.getReferenceById(dados.id());
        ticket.update(dados);

        return new TicketResponseDTO(ticket);
    }

    public void remove(Long id){
        Ticket ticket = repository.getReferenceById(id);
        ticket.delete();
    }
}
