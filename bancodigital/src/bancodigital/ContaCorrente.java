
package bancodigital;

/**
 *
 * @author Carlos
 */
public class ContaCorrente extends Conta{

    public ContaCorrente() {
        super("Corrente");
    }

    @Override
    public void impressaoExtrato() {
        System.out.println("\nExtrato da Conta Corrente");
        super.extrato();
    }
    
    
}
