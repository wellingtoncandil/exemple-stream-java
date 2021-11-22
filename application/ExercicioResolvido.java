/*
 * Fazer um programa para ler um conjunto de produtos a partir de um
arquivo em formato .csv (suponha que exista pelo menos um produto).
Em seguida mostrar o pre�o m�dio dos produtos. Depois, mostrar os
nomes, em ordem decrescente, dos produtos que possuem pre�o
inferior ao pre�o m�dio.
 */
package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class ExercicioResolvido {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the full path: ");
		String path = sc.nextLine();
		
		List<Product> list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while (line != null) {
				String[] vet = line.split(",");
				String name = vet[0];
				Double price = Double.parseDouble(vet[1]);
				Product p = new Product(name, price);
				list.add(p);
				line = br.readLine();
			}
			
			double avg = list.stream()
					.map(p -> p.getPrice())//cria uma stram apenas com os pre�os dos produtos
					.reduce(0.0, (x,y) -> x + y) / list.size();//faz a soma dos pre�os dos produtos e divide pela quantidade da lista, obtendo a m�dia
			
			System.out.println("Average price: "+ String.format("%.2f", avg));
			
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());//comparator utilizado para comparar os nomes
			//e ordenalos na ordem crescente ou decrescente
			
			List<String> names = list.stream()
					.filter(p -> p.getPrice() < avg) //filtra todos os produtos que o pre�o esteja abaixo da m�dia
					.map(p -> p.getName())
					.sorted(comp.reversed())
					.collect(Collectors.toList());
			
			names.forEach(System.out::println);

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Product product : list) {
			System.out.println(product);
		}
		
		sc.close();

	}

}
