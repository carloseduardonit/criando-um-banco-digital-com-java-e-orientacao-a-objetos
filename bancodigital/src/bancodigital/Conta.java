package bancodigital;

import cliente.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Carlos Eduardo
 */
public abstract class Conta {

    static Scanner terminal = new Scanner(System.in);
    private static PessoaFisica pessoaFisica;
    private static PessoaJuridica pessoaJuridica;
    private String numeroConta;
    private String agencia;
    private String nomeCliente;
    private String senha;
    private double saldo = 0;
    private String tipo;

    // Construtor

    /**
     * Construtor
     */
    public Conta(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo para inilizalizar a Conta
     */
    public final Conta TESTE() {
        this.nomeCliente = "Carlos";
        this.agencia = "1234";
        this.saldo = 1000;
        this.numeroConta = "123456";
        return this;
    }

    // Metodo para Conta
    /*
     * Metodo para Conta
     */
    public Conta withConta() {
        withNomeCliente().withnNumeroConta().withAgencia().withSaldo();
        return this;
    }

    /**
     * Abstração do método para impressão do extrato
     */
    public abstract void impressaoExtrato();

    // Metodo utilitarios
    /**
     * Metodo para verificar se o valor é valido
     * 
     * @param str
     * @return
     */
    private boolean isValorValid(String str) {
        return str.isBlank()
                && str.isEmpty();
    }

    /**
     * Metodo para verificar se o valor é valido
     * 
     * @param str
     * @param msg
     * @return
     */
    public boolean isValorValid(String str, String msg) {
        if (isValorValid(str)) {
            System.out.println(msg);
        }
        return isValorValid(str);
    }

    /**
     * Metodo para verificar se o valor é valido
     * 
     * @param valor
     * @param msg
     * @return
     */
    public boolean isValorValid(double valor, String msg) {
        if (valor < 0) {
            System.out.println(msg);
        }
        return valor < 0;
    }

    String deDoubleParaString(double valor) {
        return String.format(Locale.GERMANY, "R$ %.2f", valor);
    }

    // Metodo para Nome de Cliente
    public Conta withNomeCliente() {
        do {
            System.out.println("Por favor, digite o seu Nome:");
            this.nomeCliente = terminal.nextLine();
        } while (isNomeClienteValid());
        return this;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public boolean isNomeClienteValid() {
        return isValorValid(nomeCliente, "Nome do Cliente inválido");
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    // Metodo para Numero de Conta
    public Conta withnNumeroConta() {
        do {
            System.out.println("Por favor, digite o numero da Conta:");
            this.numeroConta = terminal.nextLine();
        } while (isNumeroContaValid());
        return this;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public boolean isNumeroContaValid() {
        return isValorValid(numeroConta, "Numero da Conta inválido");
    }

    // Metodo para Agencia
    public Conta withAgencia() {
        do {
            System.out.println("Por favor, digite o numero da Agência:");
            this.agencia = terminal.nextLine();
        } while (isAgenciaValid());
        return this;
    }

    public String getAgencia() {
        return agencia;
    }

    public boolean isAgenciaValid() {
        return isValorValid(agencia, "Agência inválida");
    }

    // Metodo para Saldo
    public Conta withSaldo() {
        try {
            do {
                System.out.println("Por favor, digite o seu Saldo inicial:");
                this.saldo = terminal.nextDouble();
            } while (isSaldoValid());
            return this;

        } catch (InputMismatchException ime) {
            System.out.println("Saldo inválido");
            terminal.nextLine();
            return withSaldo();

        }
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isSaldoValid() {
        return isValorValid(saldo, "Saldo inválido");
    }

    // Metodo para tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Metodo para Deposito
    public void deposito(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito de " + deDoubleParaString(valor) + " realizado com sucesso");
            Saldo();
        } else {
            System.out.println("Valor de deposito inválido\n");
        }
    }

    // Metodo para Saque
    public void saque(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + deDoubleParaString(valor)
                    + " realizado com sucesso");
            Saldo();
        } else {
            System.out.println("Valor de saque inválido\n");
        }
    }

    // Metodo para Transferencia
    public void transferencia(double valor, Conta contaDestino) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            contaDestino.deposito(valor);
            System.out.println("Transferencia de " + deDoubleParaString(valor)
                    + " realizada com sucesso");
            Saldo();
        } else {
            System.out.println("Valor de transferencia inválido\n");
        }
    }

    // Metodo para Extrato
    public void extrato() {
        System.out.println("Nome do Cliente: " + nomeCliente);
        System.out.println("Numero da Conta: " + numeroConta);
        System.out.println("Agencia: " + agencia);
    }

    // Metodo para Saldo
    public void Saldo() {
        System.out.println("Saldo: " + deDoubleParaString(saldo) + "\n");
    }

    public void Saldo(Conta conta) {
        System.out.println("Saldo: " + deDoubleParaString(conta.getSaldo()) + "\n");
    }

    public Conta withLimite() {
        return this;
    }

}
