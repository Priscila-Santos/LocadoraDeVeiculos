package Utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final Scanner sc = new Scanner(System.in);

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static int lerInteiro(String mensagem) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensagem);
                valor = sc.nextInt();
                sc.nextLine();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                sc.nextLine();
            }
        }
        return valor;
    }

    public static BigDecimal lerBigDecimal(String mensagem) {
        BigDecimal valor = null;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensagem);
                valor = sc.nextBigDecimal();
                sc.nextLine();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor decimal.");
                sc.nextLine();
            }
        }
        return valor;
    }

    public static void exibirSucesso(String mensagem) {
        System.out.println("Sucesso: " + mensagem);
    }

    public static void exibirErro(String mensagem) {
        System.out.println("Erro: " + mensagem);
    }

    public static void exibirInvalido(String mensagem) {
        System.out.println("Inválido: " + mensagem);
    }

    public static LocalDateTime lerLocalDateTime(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String input = sc.nextLine().trim();
                LocalDate date = LocalDate.parse(input, formatter);
                return date.atStartOfDay();
            } catch (DateTimeParseException e) {
                exibirInvalido("Formato de data inválido. Por favor, use o formato dd/MM/yyyy.");
            }
        }
    }
}
