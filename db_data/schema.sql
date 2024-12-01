\c fresk

CREATE TABLE associations (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    subtitle VARCHAR(255),
    description TEXT,
    logo TEXT,
    banner TEXT,
    active_members INT
);

CREATE TABLE people (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    telegram_handle VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    association_id INT NOT NULL,
    FOREIGN KEY (association_id) REFERENCES associations (id) ON DELETE CASCADE
);

CREATE TABLE committee_position (
    id SERIAL PRIMARY KEY,
    association_id INT NOT NULL,
    person_id INT NOT NULL,
    role VARCHAR(255) NOT NULL,
    description TEXT,
    FOREIGN KEY (association_id) REFERENCES associations (id) ON DELETE CASCADE,
    FOREIGN KEY (person_id) REFERENCES people (id) ON DELETE CASCADE,
    UNIQUE (association_id, person_id)
);


CREATE TABLE events (
    id SERIAL PRIMARY KEY,
    date_time TIMESTAMP NOT NULL,
    location VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    image TEXT,
    duration INTERVAL,
    association_id INT NOT NULL,
    FOREIGN KEY (association_id) REFERENCES associations (id) ON DELETE CASCADE
);

INSERT INTO associations (name, subtitle, description, logo, banner, active_members) 
VALUES (
    'Tech Enthusiasts Club',
    'Innovation and Technology',
    'A group dedicated to exploring and promoting cutting-edge technologies.',
    'https://example.com/logo.png',
    'https://example.com/banner.jpg',
    150
);
INSERT INTO associations (name, subtitle, description, logo, banner, active_members)
VALUES (
    'Art and Culture Society',
    'Celebrating Creativity and Heritage',
    'A community focused on exploring art, culture, and heritage through events and workshops.',
    'https://example.com/art_logo.png',
    'https://example.com/art_banner.jpg',
    120
);
INSERT INTO associations (name, subtitle, description, logo, banner, active_members)
VALUES (
    'Environmental Action Network',
    'Protecting Our Planet',
    'A group of environmentally-conscious individuals',
    'https://example.com/environment_logo.png',
    'https://example.com/environment_banner.jpg',
    90
);
INSERT INTO associations (name, subtitle, description, logo, banner, active_members)
VALUES (
    'Sports and Wellness Club',
    'Fitness and Fun',
    'Promoting health and wellness through sports activities, yoga, and fitness challenges.',
    'https://example.com/sports_logo.png',
    'https://example.com/sports_banner.jpg',
    200
);
