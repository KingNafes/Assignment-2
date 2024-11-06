package com.example.mo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LocationDao {
    @Insert
    void insertLocation(Location location);

    @Update
    void updateLocation(Location location);

    @Delete
    void deleteLocation(Location location);

    @Query("SELECT * FROM location WHERE address = :address LIMIT 1")
    Location getLocationByAddress(String address);

    @Query("SELECT * FROM location")
    List<Location> getAllLocations();
}
