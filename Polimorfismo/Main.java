import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.println("Informe o número de produtos: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, Used ou Imported? (C/U/I): ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Price: ");
			Double preco = sc.nextDouble();
			if (Character.toLowerCase(ch)  == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product prod1 = new ImportedProduct(nome, preco, customsFee);
				list.add(prod1);
			} else if (Character.toLowerCase(ch) == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = data.parse(sc.next());
				Product prod2 = new UsedProduct(nome, preco, manufactureDate);
				list.add(prod2);
			} else if (Character.toLowerCase(ch) == 'c') {
				Product prod3 = new Product(nome, preco);
				list.add(prod3);
			} else {
				System.out.println("Tipo inválido");
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		sc.close();
    }
}