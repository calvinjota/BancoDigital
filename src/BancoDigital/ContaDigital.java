package BancoDigital;

import java.util.List;

public class ContaDigital {
    String nome;
    int contaCorrente;
    int agencia;
    double saldo;
    double saldoCartao;

    double saldoEmprestimo;

    List<String> extratoCartaoC;

    ContaDigital() {

    }

    public ContaDigital(String nome, int contaCorrente, int agencia, double saldo, double saldoCartao, double saldoEmprestimo, List<String> extratoCartaoC) {
        this.nome = nome;
        this.contaCorrente = contaCorrente;
        this.agencia = agencia;
        this.saldo = saldo;
        this.saldoCartao = saldoCartao;
        this.saldoEmprestimo = saldoEmprestimo;
        this.extratoCartaoC = extratoCartaoC;
    }

    public String getNome() {
        return nome;
    }
    public int getContaCorrente() {
        return contaCorrente;
    }
    public int getAgencia() {
        return agencia;
    }
    public double getSaldo() {
        return saldo;
    }
    public double getSaldoCartao() {
        return saldoCartao;
    }
    public double getSaldoEmprestimo() {
        return saldoEmprestimo;
    }

    public List<String> getExtratoCartaoC() {
        return extratoCartaoC;
    }
}
