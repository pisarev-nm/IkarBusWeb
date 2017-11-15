package com.Nikolay.IkarBusWeb.repositories;

import com.Nikolay.IkarBusWeb.model.BusStopsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusStopsRepository extends CrudRepository <BusStopsEntity, Integer> {
}
