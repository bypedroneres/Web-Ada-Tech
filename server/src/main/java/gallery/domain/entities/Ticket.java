package gallery.domain.entities;

import gallery.domain.dto.ticket.TicketPostDTO;
import gallery.domain.dto.ticket.TicketPutDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name = "tickets")
@Table(name = "tickets")
@Data
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String event;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate date;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private LocalTime time;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime reservation = LocalDateTime.now();

    @ManyToOne
    private User client;

    @Column(nullable = false)
    private Boolean deleted = false;

    public Ticket(String event, String type, LocalDate date, LocalTime time, User client) {
        this.event = event;
        this.type = type;
        this.date = date;
        this.time = time;
        this.client = client;
    }

    public Ticket(TicketPostDTO ticket){
        this.event = ticket.event();
        this.type = ticket.type();
        this.date = ticket.date();
        this.time = ticket.time();
        this.client = ticket.client();
    }

    public void update(TicketPutDTO ticket) {
        if (ticket.event() != null) {
            this.event = ticket.event();
        }
        if (ticket.type() != null) {
            this.type = ticket.type();
        }
        if (ticket.date() != null) {
            this.date = ticket.date();
        }
        if (ticket.time() != null){
            this.time = ticket.time();
        }
        if (ticket.client() != null) {
            this.client = ticket.client();
        }
    }

    public void delete() {
        deleted = true;
    }
}
