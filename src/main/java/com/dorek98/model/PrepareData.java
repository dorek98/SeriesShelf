package com.dorek98.model;

import com.dorek98.service.ActorService;
import com.dorek98.service.RoleService;
import com.dorek98.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PrepareData implements ApplicationRunner {
    @Autowired
    private ActorService actorService;
    @Autowired
    private SeriesService seriesService;
    @Autowired
    private RoleService roleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        Actor actor1 = new Actor("Adam","Kowalski",30);
//        actorService.save(actor1);
//        System.out.println("hello");
//        Actor actor2 = actorService.save(new Actor("Jan","Nowak",25));
//
//        Series series1 = seriesService.save(new Series("GoT",6,Platform.HBO,2010));
//        Series series2 = seriesService.save(new Series("Peaks",3,Platform.Netflix,2017));
//
//        roleService.save(new Role("King",series1,actor1));
//        roleService.save(new Role("Boss",series2,actor1));
//        roleService.save(new Role("Driver",series2,actor2));
    }
}


