package gym_track.gymtrackingspring;

import gym_track.gymtrackingspring.repository.IGrupoMuscularRepository;
import gym_track.gymtrackingspring.repository.IRegistroRepository;
import gym_track.gymtrackingspring.service.IEjercicioService;
import gym_track.gymtrackingspring.service.IGrupoMuscularService;
import gym_track.gymtrackingspring.service.IRegistroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GymTrackingSpringApplication implements CommandLineRunner {

    @Autowired
    private IEjercicioService ejercicioService;
    private IGrupoMuscularService grupoMuscularService;
    private IRegistroService registroService;
    public static final Logger logger = LoggerFactory.getLogger(GymTrackingSpringApplication.class);

    String nextLine = System.lineSeparator();

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(GymTrackingSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{

    }



}
