package ui;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controle.Teste;
import excessoes.DadosAbertosException;

public class Menu {
	Teste teste = new Teste();

	public Menu() {
	}

	public void executa() {
		Scanner sc = new Scanner(System.in);
		char opcao = ' ';
		System.out.println("Sistema de consulta de acidentes de trânsito em Porto Alegre. ");

		Scanner entrada = new Scanner(System.in);
		while (opcao != '0') {
			try {
				System.out.println("Opcoes: ");
				System.out.println("   [0] Sair do programa.");
				System.out.println("   [1] Carregar dados.");
				System.out.println("   [2] Apresentar dados.");
				System.out.println("   [3] Consultar um dado.");
				System.out.println("   [4] Carregar dados da consulta");
				System.out.print("Digite a opcao desejada: ");
				opcao = entrada.next().charAt(0);
				switch (opcao) {
				case '1':
					teste.leArquivo(Paths.get("cat_acidentes.csv"));
					;
					break;
				case '2':
					teste.leObjeto(Paths.get("Acidentes.txt"));
					break;
				case '3':
					System.out.println("Digite os campos desejados");
					String[] str = sc.nextLine().split(" ");
					// str.add(sc.nextLine().;
					for (String s : str) {
						teste.buscar(Integer.parseInt(s));
					}
					break;
				case '4':
					teste.guardaArquivo(Paths.get("Acidentes.txt"));
					break;
				case '0':
					break;
				default:
					System.out.println("Opcao invalida! Redigite.");
				}

			} catch (InputMismatchException e) {
				System.out.println("Erro: Insira apenas números inteiros. ");
			} catch (DadosAbertosException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
