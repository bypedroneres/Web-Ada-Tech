package gallery.repositories;

import gallery.domain.entities.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT t FROM Ticket t WHERE t.deleted = false")
    Page<Ticket> findAllDeletedFalse(Pageable pageable);

    Ticket getReferenceByIdAndDeletedFalse(Long id);
}
