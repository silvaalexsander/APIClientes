package io.github.silvaalexsander;

import io.github.silvaalexsander.domain.entity.Cliente;
import io.github.silvaalexsander.domain.entity.Pedido;
import io.github.silvaalexsander.domain.repository.Clientes;
import io.github.silvaalexsander.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {


//    @Bean
//    public CommandLineRunner init(
//            @Autowired Clientes clientes,
//            @Autowired Pedidos pedidos) {
//        return args -> {
//            System.out.println("Salvando");
//            Cliente cliente = new Cliente("Alexsander");
//            clientes.save(cliente);
//
//            Pedido p = new Pedido();
//            p.setCliente(cliente);
//            p.setDataPedido(LocalDate.now());
//            p.setTotal(BigDecimal.valueOf(100));
//            pedidos.save(p);
//
//            encontrando clientes e pedidos
//            Cliente c = clientes.findClienteFetchPedidos(cliente.getId());
//            System.out.println(c);
//            System.out.println(c.getPedidos());
//
//            //encontrando pedidos atraves do cliente
//            pedidos.findByCliente(cliente).forEach(System.out::println);
//        };
//}

//    @Bean
//    public CommandLineRunner commandLineRunner(@Autowired Clientes clientes){
//        return args -> {
//          Cliente c = new Cliente(null, "Fulano");
//          clientes.save(c);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
