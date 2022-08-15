package cloud.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashboarHystrixMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashboarHystrixMain9001.class,args);
    }
}
