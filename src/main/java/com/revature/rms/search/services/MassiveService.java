package com.revature.rms.search.services;

import com.revature.rms.search.clients.CampusClient;
import com.revature.rms.search.clients.EmployeeClient;
import com.revature.rms.search.dtos.*;
import com.revature.rms.search.entites.campus.Building;
import com.revature.rms.search.entites.campus.Campus;
import com.revature.rms.search.entites.campus.ResourceMetadata;
import com.revature.rms.search.entites.campus.Room;
import com.revature.rms.search.entites.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MassiveService {

    private EmployeeClient empClient;
    private CampusClient campClient;

    @Autowired
    public MassiveService(EmployeeClient employeeClient, CampusClient campusClient) {
        super();
        this.empClient = employeeClient;
        this.campClient = campusClient;
    }

    // Make sure that the employee client method is changed once their controller is finished
    public CampusDto getCampusDtoById(String id) {
        Campus campus = campClient.getCampusById(id);
        CampusDto campusDto = getCampusObjects(campus);
        campusDto.setBuildings(getListOfBuildingsData(campus.getBuildings()));
        campusDto.setCorporateEmployees(getEachEmployeeMeta(empClient.getEmployeeListByIds(campus.getCorporateEmployees())));
        return campusDto;
    }

    public BuildingDTO getBuildingDtoById(String id) {
        Building building = campClient.getBuildingById(id);
        return getBuildingData(building);
    }

    public RoomDto getRoomDtoById(String id) {
        Room room = campClient.getRoomById(id);
        RoomDto roomDto = room.extractRoom();
        roomDto.setResourceMetadata(campusMetaData(room.getResourceMetadata()));
        return roomDto;
    }

    public List<EmployeeDto> getAllEmployees() {
        return getEachEmployeeMeta(empClient.getAllEmployee());
    }

    public EmployeeDto getEmployeeDtoById(int id) {
        Employee employee = empClient.getEmployeeById(id);
        EmployeeDto employeeDto = employee.extractEmployee();
        employeeDto.setResourceMetadata(getEmployeeMetadata(employee.getResourceMetadata()));
        return employeeDto;
    }

    public BuildingDTO getBuildingData(Building building) {
        BuildingDTO dto = building.extractBuilding();
        dto.setTrainingLead(getEmployeeById(building.getTrainingLead()));
        dto.setRooms(getEachRoomMeta(building.getRooms()));
        dto.setResourceMetadata(campusMetaData(building.getResourceMetadata()));
        return dto;
    }

    public List<BuildingDTO> getListOfBuildingsData(List<Building> buildings) {
        List<BuildingDTO> buildingDtos = new ArrayList<>();
        for(int i = 0; i < buildings.size(); i++) {
            Building building = buildings.get(i);
            BuildingDTO b = building.extractBuilding();
            b.setTrainingLead(getEmployeeById(building.getTrainingLead()));
            b.setRooms(getEachRoomMeta(building.getRooms()));
            b.setResourceMetadata(campusMetaData(building.getResourceMetadata()));
            buildingDtos.add(b);
        }
        return buildingDtos;
    }

    public CampusDto getCampusObjects(Campus campus) {
        CampusDto dto = campus.extractCampus();
        dto.setTrainingManager(getEmployeeById(campus.getTrainingManagerId()));
        dto.setStagingManager(getEmployeeById(campus.getStagingManagerId()));
        dto.setHrLead(getEmployeeById(campus.getHrLead()));
        dto.setResourceMetadata(campusMetaData(campus.getResourceMetadata()));
        return dto;
    }


    public Employee getEmployeeById(int id) {
        Employee emp = empClient.getEmployeeById(id);
        return emp;
    }

    public ResourceMetadataDto getEmployeeMetadata(com.revature.rms.search.entites.employee.ResourceMetadata data) {
        ResourceMetadataDto dto = data.extractEmployeeMeta();
        dto.setResourceCreator(getEmployeeById(data.getResourceCreator()));
        dto.setLastModifier(getEmployeeById(data.getLastModifier()));
        dto.setResourceOwner(getEmployeeById(data.getResourceOwner()));

        return dto;
    }

    public ResourceMetadataDto campusMetaData(ResourceMetadata data) {
        ResourceMetadataDto dto = data.extractCampusMeta();
        dto.setResourceCreator(getEmployeeById(data.getResourceCreator()));
        dto.setLastModifier(getEmployeeById(data.getLastModifier()));
        dto.setResourceCreator(getEmployeeById(data.getResourceOwner()));

        return dto;
    }

    public List<RoomDto> getEachRoomMeta(List<Room> rooms) {
        List<RoomDto> roomDtos = new ArrayList<>();
        rooms.forEach(r -> roomDtos.add(r.extractRoom()));
        for(int i = 0; i < rooms.size(); i++){
            Room room = rooms.get(i);
            roomDtos.get(i).setResourceMetadata(campusMetaData(room.getResourceMetadata()));
        }
        return roomDtos;
    }

    public List<EmployeeDto> getEachEmployeeMeta(List<Employee> employees) {
        List<EmployeeDto> empDtos = new ArrayList<>();
        employees.forEach(e -> empDtos.add(e.extractEmployee()));
        for(int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            empDtos.get(i).setResourceMetadata(getEmployeeMetadata(emp.getResourceMetadata()));
        }
        return empDtos;
    }
}
