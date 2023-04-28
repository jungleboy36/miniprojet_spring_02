package com.achraf.videogames.VideogamesApplicationTests;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.achraf.videogames.entities.Videogame;
import com.achraf.videogames.entities.Genre;

import com.achraf.videogames.repo.VideogameRepository;
import com.achraf.videogames.service.VideogameService;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
@SpringBootTest
class VideogamesApplicationTests {
@Autowired
private VideogameRepository videogameRepository;
@Autowired
private VideogameService videogameService;
@Test
public void testCreateVideogame() {
Videogame vid = new Videogame("PC Dell",2200.500,new Date());
videogameRepository.save(vid);
}

@Test
public void testFindVideogame()
{
Videogame v = videogameRepository.findById(1L).get(); 
System.out.println(v);
}
@Test
public void testUpdateVideogame()
{
Videogame v = videogameRepository.findById(1L).get();
v.setPrixVideogame(1000.0);
videogameRepository.save(v);
}
@Test
public void testDeleteVideogame()
{
videogameRepository.deleteById(1L);;
}
 
@Test
public void testListerTousVideogames()
{
List<Videogame> vids = videogameRepository.findAll();
for (Videogame v : vids)
{
System.out.println(v);
}
}
@Test
public void testFindByNomVideogameContains()
{
Page<Videogame> vids = videogameService.getAllVideogamesParPage(0,2);
System.out.println(vids.getSize());
System.out.println(vids.getTotalElements());
System.out.println(vids.getTotalPages());
vids.getContent().forEach(v -> {System.out.println(v.toString());
 });
/*ou bien
for (Videogame v : vids)
{
System.out.println(v);
} */
}
@Test
public void testFindByNomProduit()
{
List<Videogame> vids = videogameRepository.findByNomVideogame("phasmophobia");
for (Videogame v : vids)
{
System.out.println(v);
}
}
@Test
public void testFindByNomProduitContains ()
{
List<Videogame> vids=videogameRepository.findByNomVideogameContains("phasmo");
for (Videogame v : vids)
{
System.out.println(v);
} }

@Test
public void testfindByNomPrix()
{
List<Videogame> vids = videogameRepository.findByNomPrix("phasmophobia", 5d);
for (Videogame v : vids)
{
System.out.println(v);
}
}

@Test
public void testfindByGenre()
{
Genre gen = new Genre();
gen.setIdGen(1L);
List<Videogame> vids = videogameRepository.findByGenre(gen);
for (Videogame v : vids)
{
System.out.println(v);
}
}

@Test
public void findByCategorieIdCat()
{
List<Videogame>  vids= videogameRepository.findByGenreIdGen(1L);
for (Videogame v :vids)
{
System.out.println(v);
}
 }

@Test
public void testfindByOrderByNomVideogameAsc()
{
List<Videogame> vids = videogameRepository.findByOrderByNomVideogameAsc();
for (Videogame v :vids)
{
System.out.println(v);
}
}

@Test
public void testTrieVideogamesNomsPrix()
{
List<Videogame> vids = videogameRepository.trierVideogamesNomsPrix();
for (Videogame v : vids)
{
System.out.println(v);
}
}

}

