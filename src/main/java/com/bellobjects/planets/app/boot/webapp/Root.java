package com.bellobjects.planets.app.boot.webapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bellobjects.planets.dao.PlanetDao;
import com.bellobjects.planets.model.Planet;

@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.bellobjects.planets")
public class Root {

	@Autowired
	private PlanetDao planetDao;
	
    @RequestMapping("/")
    String home() {
    	StringBuilder planetList = new StringBuilder();
    	for (Planet planet : planetDao.getPlanets()) {
    		planetList.append(' ').append(planet.name);
    	}
        return "Hello Worlds:" + planetList;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Root.class, args);
    }

}

