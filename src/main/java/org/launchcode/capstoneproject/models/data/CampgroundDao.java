package org.launchcode.capstoneproject.models.data;

import org.launchcode.capstoneproject.models.Campground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("campgroundRepository")
@Transactional
public interface CampgroundDao extends JpaRepository<Campground, Integer> {
    Campground findByCampground(String campground);
}
