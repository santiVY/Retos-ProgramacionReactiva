package com.santiago.pruebareactive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.math.MathFlux;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;


@SpringBootTest
class PruebareactiveApplicationTests {

	private static ArrayList<Pelicula> peliculas = new ArrayList<>();

	@BeforeEach
	void contextLoads() {
		peliculas.add(new Pelicula("The irishman", "Drama", 8.1, LocalTime.of(3, 29, 00)));
		peliculas.add(new Pelicula("Parasito", "Suspenso", 8.6, LocalTime.of(2, 12, 00)));
		peliculas.add(new Pelicula("JoJo Rabit", "Comedia", 8.0, LocalTime.of(1, 48, 00)));
		peliculas.add(new Pelicula("1917", "Drama", 8.7, LocalTime.of(1, 59, 00)));
		peliculas.add(new Pelicula("Once upon a time", "Drama", 7.8, LocalTime.of(2, 41, 00)));
		peliculas.add(new Pelicula("Joker", "Suspenso", 8.6, LocalTime.of(2, 02, 00)));
		peliculas.add(new Pelicula("Avengers End Game", "Suspenso", 8.6, LocalTime.of(2, 02, 00)));
		peliculas.add(new Pelicula("Pain and Glory", "Drama", 7.7, LocalTime.of(1, 53, 00)));
		peliculas.add(new Pelicula("Little Women", "Drama", 8.3, LocalTime.of(2, 15, 00)));
		peliculas.add(new Pelicula("Ford v Ferrari", "Drama", 8.3, LocalTime.of(2, 32, 00)));
	}

	@Test
	void obtenerNombreDeLaPeliculaConMayorCalificacion(){
		//Primera forma
		Flux<Double> calificaciones = Flux.fromIterable(peliculas)
				.map(p -> p.getCalificacion());

		MathFlux.max(calificaciones).subscribe(mayor -> {
			Flux.fromIterable(peliculas).filter(p -> p.getCalificacion() == mayor)
					.subscribe(per -> System.out.println(per.toString()));
		});

		//Segunda forma
		Flux.fromIterable(peliculas)
				.map(p -> p.getCalificacion())
				.sort()
				.last()
				.subscribe(m -> {
					Flux.fromIterable(peliculas).filter(p -> p.getCalificacion() == m)
							.subscribe(per -> System.out.println(per.toString()));
				});
	}

	@Test
	public void obtenerPeliculasMayoresDe2Horas(){
		Flux.fromIterable(peliculas)
				.filter(p -> p.getDuracion().getHour() >= 2)
				.subscribe(pel -> System.out.println(pel.toString()));
	}

	@Test
	public void obtenerLasPeliculasMayoresConCalificacionMayorAOcho(){
		Flux.fromIterable(peliculas)
				.filter(p -> p.getCalificacion() > 8)
				.subscribe(mayores -> System.out.println(mayores.toString()));
	}

	@Test
	public void obtenerLaPeliculaMasLarga(){
		Flux<LocalTime> duracion = Flux.fromIterable(peliculas)
				.map(d -> d.getDuracion());

		MathFlux.max(duracion).subscribe(mayor ->{
			Flux.fromIterable(peliculas)
					.filter(may -> may.getDuracion() == mayor)
					.subscribe(peliculaMayorDuracion -> System.out.println(peliculaMayorDuracion.toString()));
		});
	}
}
