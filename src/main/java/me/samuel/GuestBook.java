package me.samuel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class GuestBook {
    private List<GuestBookEntry> entrys;

    private static GuestBook instance = null;

    static GuestBook getInstance() {
        if (instance == null) {
            instance = new GuestBook();
        }
        return instance;
    }

    private GuestBook() {
        entrys = new ArrayList<>();
    }

    List<GuestBookEntry> fetchEntries() {
        return entrys;
    }

    GuestBookEntry getEntryById(int id) {
        return entrys.parallelStream().filter(entry -> entry.getId() == id).collect(toSingleton());
    }

    private static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(Collectors.toList(),
                list -> {
                    assert list.size() == 1;
                    return list.get(0);
                }
        );
    }
}
