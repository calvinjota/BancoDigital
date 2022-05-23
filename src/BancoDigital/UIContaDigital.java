package BancoDigital;

import java.util.ArrayList;
import java.util.Scanner;

public class UIContaDigital {
    UIContaDigital() {
        Scanner scan = new Scanner(System.in);
        Contas contas = new Contas();
        System.out.println("Olá, qual a sua conta: " + "11, " + "22, " + "33");
        int contaC = scan.nextInt();
        System.out.println("Digite sua senha: ");
        int senha = scan.nextInt();
            while (senha != contaC){
                System.out.println("Senha errada!");
                senha = scan.nextInt();
            }
        contas.listaDeContas
                .stream()
                .filter(conta -> conta.contaCorrente == contaC)
                .forEach(conta -> System.out.println("Olá " + conta.nome + "\n Conta Corrente: " + conta.contaCorrente +
                        " Agencia: " + conta.agencia));
        System.out.println("Bem vindo ao seu banco digital.");
        while (true) {
            System.out.println(
                    "----------------------" +
                            "\n(1) Saldo da CC" +
                            "\n(2) Saldo cartão" +
                            "\n(3) Extrato cartão" +
                            "\n(4) Emprestimos" +
                            "\n(5) Finalizar" +
                            "\n----------------------"
            );
            double escolhaDaOpcao = scan.nextDouble();
            if (escolhaDaOpcao == 1) {
                contas.listaDeContas
                        .stream()
                        .filter(conta -> conta.contaCorrente == contaC)
                        .forEach(conta -> System.out.println("Seu saldo é: " + conta.saldo));
            } else if (escolhaDaOpcao == 2) {
                contas.listaDeContas
                        .stream()
                        .filter(conta -> conta.contaCorrente == contaC)
                        .forEach(conta -> System.out.println("Você tem disponivel em seu cartão o valor de: R$" +
                                conta.saldoCartao));
            } else if (escolhaDaOpcao == 3) {
                contas.listaDeContas
                        .stream()
                        .filter(conta -> conta.contaCorrente == contaC)
                        .forEach(conta -> System.out.println(conta.extratoCartaoC));
            } else if (escolhaDaOpcao == 4) {
                contas.listaDeContas
                        .stream()
                        .filter(conta -> conta.contaCorrente == contaC)
                        .forEach(conta -> System.out.println("Você tem disponivel em seu cartão o valor de: R$" +
                                conta.saldoCartao));
            } else if (escolhaDaOpcao == 5) {
                System.out.println("Sessão encerrada!");
                break;
            }
        }
    }
}
