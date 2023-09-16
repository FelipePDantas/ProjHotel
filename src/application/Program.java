package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Informe o número do quarto :");
			int numero = sc.nextInt();
			System.out.print("Qual a Data de entrada :");
			Date entrada = sdf.parse(sc.next());
			System.out.print("qual a Data de Saída :");
			Date saida = sdf.parse(sc.next());
			
			Reservation  reserva = new Reservation(numero, entrada, saida);
			System.out.println("Reserva :\n" + reserva);
			
			System.out.println();
			System.out.println("Entre com as novas datas da reserva");
			System.out.print("Qual a Data de entrada :");
			entrada = sdf.parse(sc.next());
			System.out.print("qual a Data de Saída :");
			saida = sdf.parse(sc.next());
			
			reserva.atualizacaoDatas(entrada, saida);
			System.out.println("Reserva :\n" + reserva);
		}
		catch(ParseException e) {
			System.out.println("Data invalida");
		}
		catch(DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		sc.close();
		}
	}
		



