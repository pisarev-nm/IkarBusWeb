package com.Nikolay.IkarBusWeb.model;

import javax.persistence.*;

@Entity
@Table(name = "routes", schema = "ikarbus", catalog = "")
public class RoutesEntity {
    private int id;
    private int cost;
    private BusStopsEntity busStopsByDestination;
    private BusStopsEntity busStopsByArrival;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cost", nullable = false)
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutesEntity that = (RoutesEntity) o;

        if (id != that.id) return false;
        if (cost != that.cost) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cost;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "destination", referencedColumnName = "id", nullable = false)
    public BusStopsEntity getBusStopsByDestination() {
        return busStopsByDestination;
    }

    public void setBusStopsByDestination(BusStopsEntity busStopsByDestination) {
        this.busStopsByDestination = busStopsByDestination;
    }

    @ManyToOne
    @JoinColumn(name = "arrival", referencedColumnName = "id", nullable = false)
    public BusStopsEntity getBusStopsByArrival() {
        return busStopsByArrival;
    }

    public void setBusStopsByArrival(BusStopsEntity busStopsByArrival) {
        this.busStopsByArrival = busStopsByArrival;
    }
}
