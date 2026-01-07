package br.com.alura.gerenciador_pedidos;

import br.com.alura.gerenciador_pedidos.principal.Principal;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorPedidosApplication implements CommandLineRunner {

    private final Principal principal;

    public static void main(String[] args) {
        SpringApplication.run(GerenciadorPedidosApplication.class, args);
    }

    public GerenciadorPedidosApplication(Principal principal) {
        this.principal = principal;
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {
        principal.cadastrarEntidades();
        principal.testarQueriesRepositories();
        principal.testarQueriesJPQLENativas();
    }
}
