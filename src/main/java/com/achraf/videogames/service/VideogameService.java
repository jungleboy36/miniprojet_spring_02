	package com.achraf.videogames.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.achraf.videogames.entities.Genre;
import com.achraf.videogames.entities.Videogame;
public interface VideogameService {
Videogame saveVideogame(Videogame p);
Videogame updateVideogame(Videogame p);
void deleteVideogame(Videogame p);
 void deleteVideogameById(Long id);
Videogame getVideogame(Long id);
List<Videogame> getAllVideogames();
Page<Videogame> getAllVideogamesParPage(int page, int size);
List<Videogame> findByNomVideogame(String nom);
List<Videogame> findByNomVideogameContains(String nom);
List<Videogame> findByNomPrix (String nom, Double prix);
List<Videogame> findByGenre (Genre genre);
List<Videogame> findByGenreIdGen(Long id);
List<Videogame> findByOrderByNomVideogameAsc();
List<Videogame> trierVideogamesNomsPrix();

}