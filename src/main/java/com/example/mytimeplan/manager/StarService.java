package com.example.mytimeplan.manager;

import com.example.mytimeplan.dao.StarRepo;
import com.example.mytimeplan.entity.Star;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StarService {

    List<Star> stars;

    public List<Star> findClosestStars(List<Star> stars, int size) throws Exception {
        // Checking if our list is not empty and null
        if (stars == null || stars.isEmpty()) {
            throw new IllegalArgumentException("The list of stars is null or empty");
        }

        Collections.sort(stars, Comparator.comparingDouble(Star::getDistance));

        int actualSize = Math.min(size, stars.size());

        List<Star> closestStars = new ArrayList<>(stars.subList(0, actualSize));

        return closestStars;
    }

    public Map<Long, Integer> getNumberOfStarsByDistances(List<Star> stars) throws Exception {

        if (stars == null || stars.isEmpty()) {
            throw new IllegalArgumentException("The list of stars is null or empty");
        }

        Map<Long, Integer> distanceMap = new HashMap<>();

        for (Star star : stars) {
            long distance = Math.round(star.getDistance());
            distanceMap.put(distance, distanceMap.getOrDefault(distance, 0) + 1);
        }
        Collections.sort(stars, Comparator.comparingDouble(Star::getDistance));

        return distanceMap;
    }

    public Collection<Star> getUniqueStars(Collection<Star> stars) throws Exception {
        if (stars == null || stars.isEmpty()) {
            throw new IllegalArgumentException("The list of stars is null or empty");
        }

        Set<Star> uniqueStars = new HashSet<>(stars);

        return uniqueStars;
    }
    private StarRepo starRepo;

    @Autowired
    public StarService(StarRepo starRepo) {
        this.starRepo = starRepo;
    }

    public Optional<Star> findById(Long id)
    {
        return starRepo.findById(id);
    }

    public Iterable<Star> findAll()
    {
        return starRepo.findAll();
    }

    public Star save(Star star)
    {
        return starRepo.save(star);
    }

    public void deletebyId(Long id) {
        starRepo.deleteById(id);
    }
}










