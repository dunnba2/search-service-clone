package com.revature.rms.search.dtos;

import com.revature.rms.search.entites.campus.Address;
import com.revature.rms.search.entites.campus.Building;
import com.revature.rms.search.entites.employee.Employee;
import com.revature.rms.search.entites.campus.ResourceMetadata;

import java.util.List;
import java.util.Objects;

public class CampusDto {
  private String id;
  private String name;
  private String abbrName;
  private Address shippingAddress;
  private Employee trainingManager;
  private Employee stagingManager;
  private Employee hrLead;
  private List<BuildingDTO> buildings;
  private List<EmployeeDto> corporateEmployees;
  private ResourceMetadataDto resourceMetadata;

  public CampusDto() {
    super();
  }

  public CampusDto(
      String id,
      String name,
      String abbrName,
      Address shippingAddress) {
    this.id = id;
    this.name = name;
    this.abbrName = abbrName;
    this.shippingAddress = shippingAddress;
  }

  public CampusDto(
      String id,
      String name,
      String abbrName,
      Address shippingAddress,
      Employee trainingManager,
      Employee stagingManager,
      Employee hrLead,
      List<BuildingDTO> buildings,
      List<EmployeeDto> corporateEmployees,
      ResourceMetadataDto resourceMetadata) {
    this.id = id;
    this.name = name;
    this.abbrName = abbrName;
    this.shippingAddress = shippingAddress;
    this.trainingManager = trainingManager;
    this.stagingManager = stagingManager;
    this.hrLead = hrLead;
    this.buildings = buildings;
    this.corporateEmployees = corporateEmployees;
    this.resourceMetadata = resourceMetadata;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAbbrName() {
    return abbrName;
  }

  public void setAbbrName(String abbrName) {
    this.abbrName = abbrName;
  }

  public Address getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(Address shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public Employee getTrainingManager() {
    return trainingManager;
  }

  public void setTrainingManager(Employee trainingManager) {
    this.trainingManager = trainingManager;
  }

  public Employee getStagingManager() {
    return stagingManager;
  }

  public void setStagingManager(Employee stagingManager) {
    this.stagingManager = stagingManager;
  }

  public Employee getHrLead() {
    return hrLead;
  }

  public void setHrLead(Employee hrLead) {
    this.hrLead = hrLead;
  }

  public List<BuildingDTO> getBuildings() {
    return buildings;
  }

  public void setBuildings(List<BuildingDTO> buildings) {
    this.buildings = buildings;
  }

  public List<EmployeeDto> getCorporateEmployees() {
    return corporateEmployees;
  }

  public void setCorporateEmployees(List<EmployeeDto> corporateEmployees) {
    this.corporateEmployees = corporateEmployees;
  }

  public ResourceMetadataDto getResourceMetadata() {
    return resourceMetadata;
  }

  public void setResourceMetadata(ResourceMetadataDto resourceMetadata) {
    this.resourceMetadata = resourceMetadata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CampusDto campusDto = (CampusDto) o;
    return id == campusDto.id
        && Objects.equals(name, campusDto.name)
        && Objects.equals(abbrName, campusDto.abbrName)
        && Objects.equals(shippingAddress, campusDto.shippingAddress)
        && Objects.equals(trainingManager, campusDto.trainingManager)
        && Objects.equals(stagingManager, campusDto.stagingManager)
        && Objects.equals(hrLead, campusDto.hrLead)
        && Objects.equals(buildings, campusDto.buildings)
        && Objects.equals(corporateEmployees, campusDto.corporateEmployees)
        && Objects.equals(resourceMetadata, campusDto.resourceMetadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id,
        name,
        abbrName,
        shippingAddress,
        trainingManager,
        stagingManager,
        hrLead,
        buildings,
        corporateEmployees,
        resourceMetadata);
  }

  @Override
  public String toString() {
    return "CampusDto{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", abbrName='"
        + abbrName
        + '\''
        + ", shippingAddress="
        + shippingAddress
        + ", trainingManager="
        + trainingManager
        + ", stagingManager="
        + stagingManager
        + ", hrLead="
        + hrLead
        + ", buildings="
        + buildings
        + ", corporateEmployees="
        + corporateEmployees
        + ", resourceMetadata="
        + resourceMetadata
        + '}';
  }
}
