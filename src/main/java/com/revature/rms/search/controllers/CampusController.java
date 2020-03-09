package com.revature.rms.search.controllers;

import com.revature.rms.search.dtos.BuildingDTO;
import com.revature.rms.search.dtos.CampusDto;
import com.revature.rms.search.dtos.RoomDto;
import com.revature.rms.search.entites.campus.Building;
import com.revature.rms.search.entites.campus.Campus;
import com.revature.rms.search.entites.campus.Room;
import com.revature.rms.search.services.MassiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/campus")
public class CampusController {

    private MassiveService massService;

    @Autowired
    public CampusController(MassiveService service) {
        this.massService = service;
    }

    // Get all campuses
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public Iterable<Campus> getAll() {
//        return campusService.getAllCampus();
//    }

    // Grab the campus by Id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CampusDto getCampusById(@PathVariable("id") String id) {
        return massService.getCampusDtoById(id);
    }

    // Get all buildings from campus
//    @GetMapping(value = "/campus/building", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Building> getAllBuildings() {
//        return massService.findAll();
//    }

    //Get building by Id, not sure which one to use
    @GetMapping(value = "/building/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BuildingDTO getBuildingById(@PathVariable("id") String id) {
        return massService.getBuildingDtoById(id);
    }

    //building manager get building by id
//    @GetMapping(value = "/bmgnr/building/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Building> getBuildingById(){
//        return massService.getBuildingById();
//    }

    //grab rooms for building
//    @GetMapping(value = "/building/room", produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Building> getAllRooms(){
//        return massService.getAllRooms();
//    }

    //grab rooms by building?
    @GetMapping(value = "/room/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RoomDto getRoomById(@PathVariable("id") String id){return massService.getRoomDtoById(id); }

    //grab rooms by Id from building from campus
    @GetMapping(value = "/rooms/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoomDto> getRoomsById(@PathVariable("id") String id){
        return massService.getBuildingDtoById(id).getRooms();
    }

}
