package cla;

import java.util.Scanner;


public class Logistica {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		// criando variaveis!

		double pesoCarga, distanciaEntrega, freteBase, total;

		String tipoDeCargaPrioridade, modalTransporte;

		int regiaoDestino;

		String rastreamento, perdaTotal;

		// pegar valores e validação

		System.out.println("bem vindo, insira o peso da Carga");
		pesoCarga = ler.nextDouble();
		

		System.out.println("Insira a distancia da entrega");
		distanciaEntrega = ler.nextDouble();
		
		
		System.out.printf("Insira o tipo de prioridade da carga\nA: Alta prioridade\nN: Normal\nB: Baixa prioridade\n");
		tipoDeCargaPrioridade = ler.next();
		
		
		if (!tipoDeCargaPrioridade.equalsIgnoreCase("a") && !tipoDeCargaPrioridade.equalsIgnoreCase("n")  && !tipoDeCargaPrioridade.equalsIgnoreCase("b") ) {
			System.err.println("Tipo de prioridade informada INVALIDA!");
			return;
		}; // validação
		
		System.out.printf("Insira o Modal de transporte\nR: Rodoviário\nA: Aéreo\nF: Ferroviario\n");
		modalTransporte = ler.next();
		

		if (!modalTransporte.equalsIgnoreCase("r") && !modalTransporte.equalsIgnoreCase("a") && !modalTransporte.equalsIgnoreCase("f")) {
			System.err.println("Tipo de Modal errado!");
			return;
		}; // validação

		// validação

		System.out.printf("Insira a regiao de destino\n1: Capital\n2: Interior\n3: Zona Rural\n");
		regiaoDestino = ler.nextInt();

		if (regiaoDestino != 1 && regiaoDestino != 2 && regiaoDestino != 3) {
			System.err.println("Tipo de regiao invalida!");
			return;
		}; // validação
		
		System.out.println("Voce deseja rastreamento em tempo real?  S/N?");
		rastreamento = ler.next();
		
		if ((!rastreamento.equalsIgnoreCase("s") && !rastreamento.equalsIgnoreCase("n"))) {
			System.err.println("Opção para rastreamento INVALIDO!");
			return;
		}; // validação

		System.out.println("Voce deseja seguro para perca total?  S/N?");
		perdaTotal = ler.next();
		
		if (!perdaTotal.equalsIgnoreCase("s") && !perdaTotal.equalsIgnoreCase("n") ) {
			System.err.println("Opção para perca total INVALIDA!");
			return;
		};// validação
		
		freteBase = (pesoCarga * 0.45) + (distanciaEntrega * 0.55); //calculo frete base
		
		// acrescimo carga
		double valorPrioridade;
		if (tipoDeCargaPrioridade.equalsIgnoreCase("a")) {
			valorPrioridade= freteBase * 0.25;
		}else if (tipoDeCargaPrioridade.equalsIgnoreCase("n")) {
			valorPrioridade = freteBase * 0.10;
		}else {
			valorPrioridade = 0;
		};
		
		// acrescimo modal!
		
		double valorModal;
		if (modalTransporte.equalsIgnoreCase("r")) {
			valorModal= freteBase * 0.05;
		}else if (tipoDeCargaPrioridade.equalsIgnoreCase("a")) {
			valorModal = freteBase * 0.30;
		}else {
			valorModal = freteBase * 0.15;
		};
		
		double valorRegiao;
		if (regiaoDestino == 1) {
			valorRegiao= freteBase * 0;
		}else if (regiaoDestino == 2 ) {
			valorRegiao = freteBase * 0.05;
		}else {
			valorRegiao = freteBase * 0.10;
		};
		
		double  valor_rastreamento;
		if (rastreamento.equalsIgnoreCase("s")) {
			valor_rastreamento = 50.00;
			}else {
				valor_rastreamento = 0;
				
			};
		
		total = freteBase + valorModal + valorRegiao + valor_rastreamento + valorPrioridade;
		
		double valorSeguro;
			if (rastreamento.equalsIgnoreCase("s")) {
				valorSeguro = total * 0.08;
				}else {
					valorSeguro = 0;
		};
		total = total + valorSeguro;	
		//total = freteBase + valorModal + valorRegiao + valor_rastreamento + valorPrioridade;
		System.out.printf("frete base:%.2f\nvalor modal: %.2f\nvalor regiao : %.2f\nvalor rastreamento: %.2f\nvalor prioridade: %.2f\nvalor seguro: %.2f\n TOTAL: %.2f\n", freteBase,valorModal,valorRegiao, valor_rastreamento, valorPrioridade, valorSeguro, total);   
		
		
			if (total > 2000 && total < 2500 && tipoDeCargaPrioridade.equalsIgnoreCase("b")) {
				System.out.println("o total é");
				System.err.println("Não recomendado: custo elevado para prioridade baixa." );
				
			}else if (total > 2500) {
				System.err.println("Não recomendado: alto custo logístico.");
			}else {
				System.out.println("\u001B[32m] Recomendado: custo logístico compatível com o perfil da carga.");
			};
	}
}


	

