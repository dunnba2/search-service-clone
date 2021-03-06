package com.revature.rms.search.entites.campus;

import com.revature.rms.search.dtos.RoomDto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Room {
    private int id;
    private String roomNumber;
    private int maxOccupancy;
    private boolean isActive;
    private RoomStatus currentStatus;
    private int batchId;
    private List<Integer> workOrders;
    private ResourceMetadata resourceMetadata;

    public Room() {
        super();
    }

    public Room(int id, String roomNumber, int maxOccupancy, boolean isActive, RoomStatus currentStatus, int batchId, List<Integer> workOrders, ResourceMetadata resourceMetadata) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.isActive = isActive;
        this.currentStatus = currentStatus;
        this.batchId = batchId;
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

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public List<Integer> getWorkOrders() {
        return workOrders;
    }

    public void setWorkOrders(List<Integer> workOrders) {
        this.workOrders = workOrders;
    }

    public ResourceMetadata getResourceMetadata() {
        return resourceMetadata;
    }

    public void setResourceMetadata(ResourceMetadata resourceMetadata) {
        this.resourceMetadata = resourceMetadata;
    }

    public RoomDto extractRoom() {
        return new RoomDto(this.id, this.roomNumber, this.maxOccupancy, this.isActive, this.currentStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id &&
                maxOccupancy == room.maxOccupancy &&
                isActive == room.isActive &&
                batchId == room.batchId &&
                Objects.equals(roomNumber, room.roomNumber) &&
                Objects.equals(currentStatus, room.currentStatus) &&
                Objects.equals(workOrders, room.workOrders) &&
                Objects.equals(resourceMetadata, room.resourceMetadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, maxOccupancy, isActive, currentStatus, batchId, resourceMetadata, workOrders);

    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", maxOccupancy=" + maxOccupancy +
                ", isActive=" + isActive +
                ", currentStatus=" + currentStatus +
                ", batchId=" + batchId +
                ", workOrders=" + workOrders +
                ", resourceMetadata=" + resourceMetadata +
                '}';
    }
}
