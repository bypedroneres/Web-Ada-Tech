package gallery.domain.dto.ticket;

import gallery.domain.entities.Ticket;
import gallery.domain.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record TicketResponseDTO(
        @NotNull Long id,
        @NotBlank String event,
        @NotBlank String type,
        @NotNull LocalDate date,
        @NotNull LocalTime time,
        @NotNull LocalDateTime reservation,
        @NotNull User client
) {
    public TicketResponseDTO(Ticket ticket){
        this(ticket.getId(), ticket.getEvent(), ticket.getType(), ticket.getDate(), ticket.getTime(), ticket.getReservation(), ticket.getClient());
    }
}
