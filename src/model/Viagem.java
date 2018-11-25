package model;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Viagem {
	
	private String dadosSaida;
	private String localSaida;
	private String localChegada;
	private String dadosChegada;
	private Duration duracao;
	private int dia, mes, ano, hora, minuto;
	private LocalDateTime saiu, chegou;
	private ZoneId saidaUser, chegadaUser;
	private ZonedDateTime saida, chegada;
	
	Scanner input = new Scanner(System.in);
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

	public Viagem(){
		System.out.println("Digite o dia, mes e ano de sua ida: ");
		dia = input.nextInt();
		mes = input.nextInt();
		ano = input.nextInt();
		
		System.out.println("Digite a hora e minuto de partida: ");
		hora = input.nextInt();
		minuto = input.nextInt();
		input.nextLine();
		
		saiu = LocalDateTime.of(ano, mes, dia, hora, minuto);
		dadosSaida = saiu.format(formato);
		
		System.out.println("Digite o local de partida (Ex: Australia/Melbourne): ");
		localSaida = input.nextLine();
		try {
			saidaUser = ZoneId.of(localSaida);
			saida = ZonedDateTime.of(saiu, saidaUser);
			System.out.println("Digite o dia, mes e ano de sua chegada: ");
			dia = input.nextInt();
			mes = input.nextInt();
			ano = input.nextInt();
			
			System.out.println("Digite a hora e minuto de chegada: ");
			hora = input.nextInt();
			minuto = input.nextInt();
			input.nextLine();
			
			chegou = LocalDateTime.of(ano, mes, dia, hora, minuto);
			dadosChegada = chegou.format(formato);
			
			System.out.println("Digite o local de pouso (Ex: Asia/Dubai): ");
			localChegada = input.next();
			chegadaUser = ZoneId.of(localChegada);
			chegada = ZonedDateTime.of(chegou, chegadaUser);
			duracao = Duration.between(saida, chegada);
		}catch(Exception e) {
			
		}
		
	}
	
	public String duracao() {
		String resultado;
		
		try {
			duracao = Duration.between(saida, chegada);
			resultado = "Duração Ida: " + duracao;
		}catch(Exception e){
			resultado = "Por favor verifique o Local de partida";
		}
		
		return resultado;
	}
}
