package gallery.domain.dto.ticket;

import gallery.domain.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record TicketPostDTO(
        @NotBlank String event,
        @NotBlank String type,
        @NotNull LocalDate date,
        @NotNull LocalTime time,
        @NotNull User client
) {}
