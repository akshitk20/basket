package shoppingcart.basket.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {
    @Bean
    public ManagedChannel grpcChannel() {
        String serverAddress = "localhost";
        int serverPort = 9090;
        return ManagedChannelBuilder.forAddress(serverAddress, serverPort)
                .usePlaintext()
                .build();
    }
}
