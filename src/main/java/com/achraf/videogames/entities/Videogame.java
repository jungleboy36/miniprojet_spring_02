package com.achraf.videogames.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
@Entity
public class Videogame {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idVideogame;
@NotNull
@Size (min = 4,max = 15)
private String nomVideogame;

@NotNull
@Min(value = 10)
@Max(value = 10000)
private Double prixVideogame;

@NotNull
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date releaseDate;
@ManyToOne
private Genre genre;
public Videogame() {
super();
}
public Videogame(String nomVideogame, Double prixVideogame, Date releaseDate) {
super();
this.nomVideogame = nomVideogame;
this.prixVideogame = prixVideogame;
this.releaseDate = releaseDate;
}
public Long getIdVideogame() {
return idVideogame;
}
public void setIdVideogame(Long idVideogame) {
this.idVideogame = idVideogame;
}
public String getNomVideogame() {
return nomVideogame;
}
public void setNomVideogame(String nomVideogame) {
this.nomVideogame = nomVideogame;
}
public Double getPrixVideogame() {
return prixVideogame;
}
public void setPrixVideogame(Double prixVideogame) {
this.prixVideogame = prixVideogame;
}
public Date getReleaseDate() {
return releaseDate;
}
public void setReleaseDate(Date releaseDate) {
this.releaseDate = releaseDate;
}
@Override
public String toString() {
return "Videogame [idVideogame=" + idVideogame + ", nomVideogame=" + 
nomVideogame + ", prixVideogame=" + prixVideogame
+ ", releaseDate=" + releaseDate + "]";
}
}