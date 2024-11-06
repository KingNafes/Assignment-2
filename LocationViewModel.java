package com.example.mo;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import java.util.List;

public class LocationViewModel extends AndroidViewModel {
    private final LocationRepository repository;

    public LocationViewModel(Application application) {
        super(application);
        repository = new LocationRepository(application);
    }

    public void addLocation(Location location) {
        repository.addLocation(location);
    }

    public void updateLocation(Location location) {
        repository.updateLocation(location);
    }

    public void deleteLocation(Location location) {
        repository.deleteLocation(location);
    }

    public Location findLocation(String address) {
        return repository.findLocation(address);
    }

    public List<Location> getAllLocations() {
        return repository.getAllLocations();
    }
}

