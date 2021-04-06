package com.dorek98;

import com.dorek98.model.*;
import com.dorek98.repository.ActorRepository;
import com.dorek98.repository.RoleRepository;
import com.dorek98.repository.SeriesRepository;
import com.dorek98.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class PreparedData implements ApplicationRunner {
    private final ActorRepository actorRepository;
    private final SeriesRepository seriesRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args)  {

        List<Actor> actors = new ArrayList<>();
        actors.add(new Actor("Adam", "Kowalski", 20));
        actors.add(new Actor("Kate", "Beck", 26));
        actors.add(new Actor("Jan", "Mak", 15));
        actors.add(new Actor("Mike", "Pedro", 42));
        actors.add(new Actor("Anna", "Piasek", 23));
        actors.add(new Actor("Ron", "Bruno", 17));

        List<Series> series = new ArrayList<>();
        series.add(new Series("GoT",6, Platform.HBO,2010));
        series.add(new Series("Peaks",3,Platform.Netflix,2017));
        series.add(new Series("Dark",2,Platform.Netflix,2019));

        List<Role> roles = new ArrayList<>();
        roles.add(new Role("King",series.get(0),actors.get(3)));
        roles.add(new Role("Queen",series.get(0),actors.get(1)));
        roles.add(new Role("Knight",series.get(0),actors.get(5)));
        roles.add(new Role("Boss",series.get(1),actors.get(0)));
        roles.add(new Role("Driver",series.get(1),actors.get(3)));
        roles.add(new Role("Detective",series.get(1),actors.get(2)));
        roles.add(new Role("Daughter",series.get(2),actors.get(4)));
        roles.add(new Role("Father",series.get(2),actors.get(3)));
        roles.add(new Role("Killer",series.get(2),actors.get(2)));

        actorRepository.saveAll(actors);
        seriesRepository.saveAll(series);
        roleRepository.saveAll(roles);
        userRepository.save(new User("Student", passwordEncoder.encode("Student123"), "USER"));
    }
}


