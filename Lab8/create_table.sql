CREATE TABLE albums (
 id NUMBER PRIMARY KEY,
 release_year NUMBER,
 title VARCHAR2(300),
 artist VARCHAR2(300)
);

CREATE TABLE artists (
 id NUMBER PRIMARY KEY,
 name VARCHAR2(300)
);

CREATE TABLE genres (
 id NUMBER PRIMARY KEY,
 name VARCHAR2(300)
);

CREATE TABLE album_genres (
 album_id NUMBER,
 genre_id NUMBER,
 FOREIGN KEY (album_id) REFERENCES albums(id),
 FOREIGN KEY (genre_id) REFERENCES genres(id)
);
