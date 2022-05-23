package BancoDigital;

import java.text.DecimalFormat;
import java.util.Scanner;

public class UIContaDigital {
    private final Contas contas = new Contas();
    private  ContaDigital contaSelecionada;
    UIContaDigital() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Olá, qual a sua conta: " + "11, " + "22, " + "33");
        int contaC = scan.nextInt();
        System.out.println("Digite sua senha: ");
        int senha = scan.nextInt();
        while (senha != contaC) {
            System.out.println("Senha errada! Sua senha tenho o mesmo número que sua CC.");
            senha = scan.nextInt();
        }
        contas.listaDeContas
                .stream()
                .filter(conta -> conta.contaCorrente == contaC)
                .forEach(conta -> {
                    System.out.println("Olá " + conta.nome + "\n Conta Corrente: " + conta.contaCorrente +
                            " Agencia: " + conta.agencia);
                    contaSelecionada = conta;
                });
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
                System.out.println("Seu saldo é: " +
                        new DecimalFormat("#,##0.00").format(contaSelecionada.saldo));
            } else if (escolhaDaOpcao == 2) {
                contas.listaDeContas
                        .stream()
                        .filter(conta -> conta.contaCorrente == contaC)
                        .forEach(conta -> System.out.println("Você tem disponivel em seu cartão o valor de: R$" +
                                new DecimalFormat("#,##0.00").format(conta.saldoCartao)));
            } else if (escolhaDaOpcao == 3) {
                contas.listaDeContas
                        .stream()
                        .filter(conta -> conta.contaCorrente == contaC)
                        .forEach(conta -> System.out.println(conta.extratoCartaoC));
            } else if (escolhaDaOpcao == 4) {
                contas.listaDeContas
                        .stream()
                        .filter(conta -> conta.contaCorrente == contaC)
                        .forEach(conta -> System.out.println("Você tem um limite de: R$" +
                                new DecimalFormat("#,##0.00").format(conta.saldoEmprestimo)));
                AbaEmprestimo();
            } else if (escolhaDaOpcao == 5) {
                System.out.println("Sessão encerrada!");
                break;
            }
        }
    }

    private void AbaEmprestimo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("(1) Saque emprestimo \n(2) Voltar");
        double opcaoDigitada = scan.nextDouble();
        if (opcaoDigitada == 1) {
            System.out.println("Digite o valor que você que sacar: ");
            double valorDoSaque = scan.nextDouble();
            if (valorDoSaque > contaSelecionada.saldoEmprestimo){
                System.out.println("Limite excedido!");
            } else {
                System.out.println("Emprestimo efetuado com sucesso no valor de: R$" +
                        new DecimalFormat("#,##0.00").format(valorDoSaque));
                contaSelecionada.saldoEmprestimo -= valorDoSaque;
                contaSelecionada.saldo += valorDoSaque;
            }
            System.out.println("Seu saldo atual de emprestimo é de: R$" +
                    new DecimalFormat("#,##0.00").format(contaSelecionada.saldoEmprestimo));
        } else if (opcaoDigitada == 2) {
            System.out.println("Selecione uma das opções: ");
        } else if (opcaoDigitada < 1 || opcaoDigitada > 2) {
            System.out.println("Opção informada invalida! Informe uma das opcoes abaixo:");
        }
    }
}
