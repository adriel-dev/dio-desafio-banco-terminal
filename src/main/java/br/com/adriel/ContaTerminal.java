package br.com.adriel;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    
    public static void main(String[] args) {
        int numero;
        String agencia;
        String nomeCliente;
        BigDecimal saldo;

        Scanner sc = new Scanner(System.in);

        System.out.print("Por favor, insira o número da Conta: ");
        numero = sc.nextInt();
        sc.nextLine();

        System.out.print("Agora insira o número da Agência: ");
        agencia = sc.nextLine();

        System.out.print("Informe o seu nome: ");
        nomeCliente = sc.nextLine();

        System.out.print("Informe o Saldo inicial da conta: ");
        try {
            saldo = BigDecimal.valueOf(sc.nextDouble());
            String msg = "Olá "+nomeCliente+", obrigado por criar uma conta em nosso banco, sua agência é "+agencia+", conta "+numero+" e seu saldo "+formatarSaldo(saldo)+" já está disponível para saque.";
            System.out.println(msg);
        } catch(InputMismatchException e) {
            System.err.println("Valor inserido está incorreto!");
            System.out.println("Dica: Utilize apenas ',' para informar os centavos.");
        }

        sc.close();
    }

    private static String formatarSaldo(BigDecimal saldo) {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(saldo);
    }

}