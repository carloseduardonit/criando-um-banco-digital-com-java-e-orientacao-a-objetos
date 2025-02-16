package bancodigital;

/**
 *
 * @author Carlos
 */
public class ContaCorrente extends Conta {
    private double limite;

    /**
     * Construtor
     */
    public ContaCorrente() {
        super("Corrente");
    }

    /**
     * Metodo para Conta Corrente
     */
    @Override
    public Conta withLimite() {
        do {
            System.out.println("Digite o Limite da Conta Corrente:");
            this.limite = terminal.nextDouble();
        } while (super.isValorValid(this.limite, "Valor Invalido"));

        return this;
    }

    /**
     * Metodo para Obter o Limite da Conta Corrente
     */
    public double getLimite() {
        return this.limite;
    }

    /**
     * Metodo para Definir o Limite da Conta Corrente
     */
    public void setLimite(double limite) {
        this.limite = limite;
    }

    /**
     * Metodo para impressao do extrato da conta corrente
     */
    @Override
    public void impressaoExtrato() {
        System.out.println("\nExtrato da Conta Corrente");
        super.extrato();
        if (this.limite > 0) {
            System.out.println("Limite: " + super.deDoubleParaString(this.limite));
        }
        Saldo();
    }

}
