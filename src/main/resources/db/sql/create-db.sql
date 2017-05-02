CREATE TABLE User(
id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY,
login VARCHAR(255) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL,
viewCategories BOOLEAN NOT NULL,
viewComments BOOLEAN NOT NULL,
viewSuggestions BOOLEAN NOT NULL
);

CREATE TABLE category(
id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY,
name VARCHAR(255) NOT NULL UNIQUE
);


CREATE TABLE citizen(
id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY,
password VARCHAR(255) NOT NULL,
userName VARCHAR(255) NOT NULL UNIQUE,
dni VARCHAR(255) NOT NULL UNIQUE,
name VARCHAR(255),
surname VARCHAR(255),
bornDate DATE,
email VARCHAR(255),
postAddress VARCHAR(255),
nationality VARCHAR(255)

);

CREATE TABLE suggestion(
id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY,
code VARCHAR(255) NOT NULL UNIQUE,
title VARCHAR(255) NOT NULL,
description VARCHAR(255),
minVotes INTEGER,
citizen_id BIGINT NOT NULL,
category_id BIGINT NOT NULL
);

CREATE TABLE comment(
id BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY,
code VARCHAR(255) NOT NULL UNIQUE,
description VARCHAR(255) NOT NULL,
citizen_id BIGINT NOT NULL,
suggestion_id BIGINT NOT NULL
);

CREATE TABLE voteSuggestion(
citizen_id BIGINT,
suggestion_id BIGINT,
vote VARCHAR(255) NOT NULL
);

CREATE TABLE voteComment(
citizen_id BIGINT,
comment_id BIGINT,
vote VARCHAR(255) NOT NULL
);