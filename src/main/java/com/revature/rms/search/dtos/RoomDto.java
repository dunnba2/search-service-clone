package com.revature.rms.search.dtos;

import com.revature.rms.search.entites.campus.RoomStatus;
import com.revature.rms.search.entites.workorder.WorkOrder;

import java.util.List;
import java.util.Objects;

public class RoomDto {

  private int id;
  private String roomNumber;
  private int maxOccupancy;
  private boolean isActive;
  private RoomStatus currentStatus;
  private BatchDto batch;
  private List<WorkOrder> workOrders;
  private ResourceMetadataDto resourceMetadata;

  public RoomDto() {
    super();
  }

  public RoomDto(
      int id, String roomNumber, int maxOccupancy, boolean isActive, RoomStatus currentStatus) {
    this.id = id;
    this.roomNumber = roomNumber;
    this.maxOccupancy = maxOccupancy;
    this.isActive = isActive;
    this.currentStatus = currentStatus;
  }

  public RoomDto(
      int id,
      String roomNumber,
      int maxOccupancy,
      boolean isActive,
      RoomStatus currentStatus,
      BatchDto batch,
      List<WorkOrder> workOrders,
      ResourceMetadataDto resourceMetadata) {
    this.id = id;
    this.roomNumber = roomNumber;
    this.maxOccupancy = maxOccupancy;
    this.isActive = isActive;
    this.currentStatus = currentStatus;
    this.batch = batch;
    this.workOrders = workOrders;
    this.resourceMetadata = resourceMetadata;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public int getMaxOccupancy() {
    return maxOccupancy;
  }

  public void setMaxOccupancy(int maxOccupancy) {
    this.maxOccupancy = maxOccupancy;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public RoomStatus getCurrentStatus() {
    return currentStatus;
  }

  public void setCurrentStatus(RoomStatus currentStatus) {
    this.currentStatus = currentStatus;
  }

  public BatchDto getBatch() {
    return batch;
  }

  public void setBatch(BatchDto batch) {
    this.batch = batch;
  }

  public List<WorkOrder> getWorkOrders() {
    return workOrders;
  }

  public void setWorkOrders(List<WorkOrder> workOrders) {
    this.workOrders = workOrders;
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
    RoomDto roomDto = (RoomDto) o;
    return id == roomDto.id
        && maxOccupancy == roomDto.maxOccupancy
        && isActive == roomDto.isActive
        && Objects.equals(roomNumber, roomDto.roomNumber)
        && Objects.equals(currentStatus, roomDto.currentStatus)
        && Objects.equals(batch, roomDto.batch)
        && Objects.equals(workOrders, roomDto.workOrders)
        && Objects.equals(resourceMetadata, roomDto.resourceMetadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id, roomNumber, maxOccupancy, isActive, currentStatus, batch, workOrders, resourceMetadata);
  }

  @Override
  public String toString() {
    return "WorkOrderDto{"
        + "id="
        + id
        + ", roomNumber='"
        + roomNumber
        + '\''
        + ", maxOccupancy="
        + maxOccupancy
        + ", isActive="
        + isActive
        + ", currentStatus="
        + currentStatus
        + ", batch="
        + batch
        + ", workOrders="
        + workOrders
        + ", resourceMetadata="
        + resourceMetadata
        + '}';
  }
}
