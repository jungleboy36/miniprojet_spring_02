package com.achraf.videogames.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.achraf.videogames.entities.Videogame;
import com.achraf.videogames.service.VideogameService;

import jakarta.validation.Valid;
@Controller
public class VideogameController {
@Autowired
VideogameService videogameService;
@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
modelMap.addAttribute("videogame", new Videogame());
modelMap.addAttribute("mode","new");
return "formVideogame";
}
@RequestMapping("/saveVideogame")
public String saveVideogame(@Valid Videogame videogame,
 BindingResult bindingResult)
{
if (bindingResult.hasErrors()) return "formVideogame";
 
videogameService.saveVideogame(videogame);
return "formVideogame";
}
@RequestMapping("/ListeVideogames")
public String listeVideogames(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
Page<Videogame> vids = videogameService.getAllVideogamesParPage(page, size);
modelMap.addAttribute("videogames", vids);
 modelMap.addAttribute("pages", new int[vids.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeVideogames";
}

@RequestMapping("/supprimerVideogame")
public String supprimerVideogame(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
videogameService.deleteVideogameById(id);
Page<Videogame> vids = videogameService.getAllVideogamesParPage(page, 
size);
modelMap.addAttribute("videogames", vids);
modelMap.addAttribute("pages", new int[vids.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeVideogames";
}

@RequestMapping("/modifierVideogame")
public String editerVideogame(@RequestParam("id") Long id,ModelMap modelMap)
{
Videogame p= videogameService.getVideogame(id);
modelMap.addAttribute("videogame", p);
modelMap.addAttribute("mode","edit");
return "editerVideogame";
}
@RequestMapping("/updateVideogame")
public String updateVideogame(@ModelAttribute("videogame") Videogame videogame,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 videogame.setReleaseDate(dateCreation);
	 
	 videogameService.updateVideogame(videogame);
	 List<Videogame> vids = videogameService.getAllVideogames();
	 modelMap.addAttribute("videogames", vids);
	return "listeVideogames";
	}

}

