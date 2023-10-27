create table users(
    id TEXT NOT NULL,
    username varchar(50) NOT NULL,
    email varchar(50) NOT NULL UNIQUE,
    password varchar(50) NOT NULL,
    role varchar(15) NOT NULL CHECK (role IN ('ADMIN', 'USER')),

    PRIMARY KEY (id)
);