import model.Banco;
import model.ContaCorrente;
import model.SaldoInsuficienteException;

public class App {
    public static void main(String[] args) throws Exception {
        ContaCorrente cc = new ContaCorrente();
        ContaCorrente c2 = new ContaCorrente();
        Banco itau = new Banco("Itaú", 1010);

        cc.setTitular("Rafa");
        cc.setNumero(3344);
        cc.setAgencia("134-AKL");

        try {
            cc.deposita(1500);
            cc.saca(500);
            itau.adiciona(cc);
        } catch (IllegalArgumentException | SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            itau.mostrarContas();
            System.out.println(itau.contem(cc));
            System.out.println(itau.contem(c2));
        }
    }
}