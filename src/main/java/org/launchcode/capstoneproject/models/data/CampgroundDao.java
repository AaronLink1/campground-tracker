package org.launchcode.capstoneproject.models.data;

import org.launchcode.capstoneproject.models.Campground;
import org.launchcode.capstoneproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface CampgroundDao extends JpaRepository<Campground, Integer> {
    Campground findById(int campgroundId);
    ArrayList<Campground> findAllByUser_Id(long userId);
    ArrayList<Campground> findAllByName(String name);
    ArrayList<Campground> findAllByPrice(int price);
    ArrayList<Campground> findAllByLocation(String location);
    ArrayList<Campground> findAllByHasElectric(Boolean electric);
    ArrayList<Campground> findAllByHasWater(Boolean water);
    ArrayList<Campground> findAllByHasDump(Boolean dump);
    ArrayList<Campground> findAllByHasFacilities(Boolean facilities);
}
