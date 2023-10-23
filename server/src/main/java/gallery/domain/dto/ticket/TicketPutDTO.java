package gallery.domain.dto.ticket;

import gallery.domain.entities.User;
import jakarta.annotation.Nullable;

import java.time.LocalDate;
import java.time.LocalTime;

public record TicketPutDTO(Long id, @Nullable String event, @Nullable String type, @Nullable LocalDate date, @Nullable LocalTime time, @Nullable User client) {
}
