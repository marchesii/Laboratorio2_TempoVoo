package view;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import model.Viagem;

public class TempoVoo {
	
	public static void main(String[] args){
		ZoneId saoPaulo = ZoneId.of("America/Sao_Paulo");
		ZoneId dubai = ZoneId.of("Asia/Dubai");
		ZoneId australia = ZoneId.of("Australia/Melbourne");
		
		
		LocalDateTime emSP = LocalDateTime.of(2018, Month.MAY, 26, 1, 25);
		LocalDateTime emDB = LocalDateTime.of(2018, Month.MAY, 26, 22, 55);
		
		ZonedDateTime saidaSP = ZonedDateTime.of(emSP, saoPaulo);
		ZonedDateTime chegadaDB = ZonedDateTime.of(emDB, dubai);
		
		Duration duracao = Duration.between(saidaSP, chegadaDB);
		System.out.println("Duração Emirante: " + duracao);
		
		emSP = LocalDateTime.of(2018, Month.MAY, 26, 3, 15);
		emDB = LocalDateTime.of(2018, Month.MAY, 28, 0, 20);
		
		saidaSP = ZonedDateTime.of(emSP, saoPaulo);
		chegadaDB = ZonedDateTime.of(emDB, dubai);
		
		duracao = Duration.between(saidaSP, chegadaDB);
		System.out.println("Duração Emirante: " + duracao);
		
		LocalDateTime emAust = LocalDateTime.of(2019, Month.MARCH, 25, 21, 00);
		LocalDateTime emBrasil = LocalDateTime.of(2019, Month.MARCH, 26, 22, 05);
		
		ZonedDateTime saidaAust = ZonedDateTime.of(emAust, australia);
		ZonedDateTime chegadaBrasil = ZonedDateTime.of(emBrasil, saoPaulo);
		
		duracao = Duration.between(saidaAust, chegadaBrasil);
		System.out.println("Duração Ida: " + duracao);
		
		Viagem viagem = null;
		viagem = new Viagem();
		System.out.println(viagem.duracao());
		
	}
}
