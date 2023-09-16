package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;


public class Reservation {
	
	private Integer numeroDoQuarto;
	
	private Date dataEntrada;
	
	private Date dataSaida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer numeroDoQuarto, Date dataEntrada, Date dataSaida) throws DomainException {
		if (!dataEntrada.after(dataSaida)) {
			throw new DomainException("Erro na reserva: A data de entrada tem que ser maior que a saida ");
		}
		this.numeroDoQuarto = numeroDoQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	
	public long duracao() {
		long diferenca = dataSaida.getTime() - dataEntrada.getTime();
		return TimeUnit.DAYS.convert(diferenca,TimeUnit.MILLISECONDS);
	}
	
	public void atualizacaoDatas(Date entrada,Date saida) throws DomainException {
		Date agora = new Date();
		if(entrada.before(agora) || saida.before(agora)) {
			throw new DomainException("Reserva tem que conter datas futuras da atual");
		}
		if (!entrada.after(saida)) {
			throw new DomainException("Erro na reserva: A data de entrada tem que ser maior que a saida ");
		}
		this.dataEntrada = entrada;
		this.dataSaida = saida;
	}
	@Override
	public String toString() {
		return  " Número do quarto: " + numeroDoQuarto +
				"\n Data de entrada: " + sdf.format(dataEntrada) +
				"\n Data de Saida: " + sdf.format(dataSaida) + " \n " +
				duracao() + " noites";	
	}


	
}
