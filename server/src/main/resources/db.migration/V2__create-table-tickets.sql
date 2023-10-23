create table tickets(
    id BIGSERIAL NOT NULL,
    event varchar(50) NOT NULL,
    type varchar(50) NOT NULL,
    date DATE NOT NULL,
    time TIME NOT NULL,
    reservation TIMESTAMP NOT NULL,
    client_id BIGINT NOT NULL REFERENCES users(id),
    deleted BOOLEAN NOT NULL DEFAULT false,

    PRIMARY KEY (id)
);