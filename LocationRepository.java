package com.example.mo;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocationRepository {
    private final LocationDao locationDao;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public LocationRepository(Application application) {
        LocationDatabase db = LocationDatabase.getDatabase(application);
        locationDao = db.locationDao();
    }

    public void addLocation(Location location) {
        executorService.execute(() -> locationDao.insertLocation(location));
    }

    public void updateLocation(Location location) {
        executorService.execute(() -> locationDao.updateLocation(location));
    }

    public void deleteLocation(Location location) {
        executorService.execute(() -> locationDao.deleteLocation(location));
    }

    public Location findLocation(String address) {
        return locationDao.getLocationByAddress(address);
    }

    public List<Location> getAllLocations() {
        return locationDao.getAllLocations();
    }
}
