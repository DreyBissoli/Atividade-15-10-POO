public class MainCloud {
    public static void main(String[] args) {
        CloudManager manager = new CloudManager();

        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);

        manager.registrarCliente(cliente);
        manager.provisionarServidor(cliente, servidor);

        Container c1 = new Container("C-01", "Aplicacao 1", 10.0);
        Container c2 = new Container("C-02", "Aplicacao 2", 8.0);

        // Teste da excecao Unchecked: descomente para ver a mensagem e interromper a execucao.
        // servidor.alocarContainer(c1);

        servidor.ligar();

        try {
            servidor.alocarContainer(c1);
            System.out.println("Container C-01 alocado com sucesso.");
        } catch (CapacidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        try {
            servidor.alocarContainer(c2);
        } catch (CapacidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        System.out.printf("Fatura ativa: R$ %.2f%n",
                manager.calcularFaturaAtiva(cliente));
    }
}
