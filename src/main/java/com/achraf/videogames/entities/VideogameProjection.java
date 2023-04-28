package com.achraf.videogames.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomVid", types = {Videogame.class })
public interface VideogameProjection {
	public String getNomVideogame();

}
