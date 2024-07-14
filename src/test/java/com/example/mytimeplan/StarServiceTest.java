package com.example.mytimeplan;

import com.example.mytimeplan.entity.Star;
import com.example.mytimeplan.manager.StarService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StarServiceTest {

    private StarService starService;

    public StarServiceTest(StarService starService) {
        this.starService = starService;
    }

    @Test
    public void AddStar() {

        Star star = new Star("A", 10);
        Star star1 = new Star("B", 20);
        Star star2 = new Star("C", 4);

        starService.save(star);

        List<Star> stars = new ArrayList<>();
        starService.findAll().forEach(stars::add);
        assertEquals(stars.size(), 3);
        assertEquals(stars.get(0).getName(), "A");
        assertEquals(stars.get(0).getDistance(), "10");
        assertEquals(stars.get(1).getName(), "B");
        assertEquals(stars.get(1).getDistance(), "20");
        assertEquals(stars.get(2).getName(), "C");
        assertEquals(stars.get(2).getDistance(), "4");
    }
    @Test
    public void DeleteStar() {

        Star star4 = new Star("D",12);

        starService.deletebyId(star4.getDistance());

        List<Star> stars2 = new ArrayList<>();
        starService.findAll().forEach(stars2::remove);
        assertEquals(stars2.size(), 0);
        assertEquals(stars2.get(0).getName(), null);
        assertEquals(stars2.get(0).getDistance(), "null");
    }
}

