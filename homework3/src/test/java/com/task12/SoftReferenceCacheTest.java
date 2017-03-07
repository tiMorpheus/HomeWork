package com.task12;

import com.timorpheus.task12.SoftReferenceCache;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SoftReferenceCacheTest {

    List<String> locations;
    SoftReferenceCache softCache;

    @Before
    public void setUp() {
        softCache = new SoftReferenceCache();
        locations = new ArrayList<>();


        locations.add("D://java1.pdf");
        locations.add("D://java2.pdf");
        locations.add("D://java3.pdf");
        locations.add("D://java4.pdf");
        locations.add("D://java5.pdf");
        locations.add("D://java6.pdf");

    }

    @Test
    public void getSoftFile() throws IOException {
        softCache.getFile(locations.get(0));
        softCache.getFile(locations.get(1));
        softCache.getFile(locations.get(2));
        softCache.getFile(locations.get(3));
        softCache.getFile(locations.get(4));
        softCache.getFile(locations.get(5));

    }

}
