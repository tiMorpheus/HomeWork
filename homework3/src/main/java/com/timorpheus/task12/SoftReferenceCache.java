package com.timorpheus.task12;


import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class SoftReferenceCache {

    private Map<String, SoftReference> cache = new HashMap<>();



    public Object getFile(String location) throws IOException {

        if (cache.containsKey(location)) {
            return cache.get(location);
        } else {
            cache.put(location, new SoftReference(Files.readAllBytes(Paths.get(location))));
        }
        return cache.get(location);
    }

}
