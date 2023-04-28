package com.achraf.videogames.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.achraf.videogames.entities.Genre;
import com.achraf.videogames.entities.Videogame;
@RepositoryRestResource(path = "rest")
public interface VideogameRepository extends JpaRepository<Videogame, Long> {
	List<Videogame> findByNomVideogame(String nom);
	 List<Videogame> findByNomVideogameContains(String nom); 
	 @Query("select v from Videogame v where v.nomVideogame like %:nom and v.prixVideogame > :prix")
	 List<Videogame> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 @Query("select v from Videogame v where v.genre = ?1")
	 List<Videogame> findByGenre (Genre genre);
	 List<Videogame> findByGenreIdGen(Long id);
	 List<Videogame> findByOrderByNomVideogameAsc();
	 @Query("select v from Videogame v order by v.nomVideogame ASC, v.prixVideogame DESC")
	 List<Videogame> trierVideogamesNomsPrix ();




}
