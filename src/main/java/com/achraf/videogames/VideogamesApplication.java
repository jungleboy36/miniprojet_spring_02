package com.achraf.videogames;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.achraf.videogames.entities.Videogame;
import com.achraf.videogames.service.VideogameService;
@SpringBootApplication
public class VideogamesApplication implements CommandLineRunner{
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Autowired
	VideogameService videogameService;
	public static void main(String[] args) {
	SpringApplication.run(VideogamesApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	/*videogameService.saveVideogame(new Videogame("Valorant",0d, new Date()));
	videogameService.saveVideogame(new Videogame("Phasmophobia", 10d, new Date()));
	videogameService.saveVideogame(new Videogame("Dead by Daylight", 8d, new Date()));*/
		repositoryRestConfiguration.exposeIdsFor(Videogame.class);

	}
	

}
