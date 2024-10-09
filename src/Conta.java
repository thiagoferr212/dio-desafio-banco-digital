public abstract class Conta implements IConta{
    
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private int agencia;
    private int numero;
    private double saldo; 
    private Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }
    
    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }
    
    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirSaldo(){
        System.out.printf("Cliente: %s %n", cliente.getNome());
        System.out.printf("Agencia: %d %n", agencia);
        System.out.printf("Numero: %d %n", numero);
        System.out.printf("Saldo: %.2f %n", saldo);
    }
}
