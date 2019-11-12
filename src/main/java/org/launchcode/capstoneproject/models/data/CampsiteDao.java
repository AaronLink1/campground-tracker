package org.launchcode.capstoneproject.models.data;

import org.launchcode.capstoneproject.models.Campsite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CampsiteDao extends CrudRepository<Campsite, Integer> {
}
