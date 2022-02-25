package com.zybooks.weeklyworkouts;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.List;

public class RestRepository {


        private static RestRepository instance;
        private List<Rest> kRestAlts;

        public static RestRepository getInstance(Context context) {
            if (instance == null) {
                instance = new RestRepository(context);
            }
            return instance;
        }

        private RestRepository(Context context) {
            kRestAlts = new ArrayList<>();
            Resources res = context.getResources();
            String[] bands = res.getStringArray(R.array.bands);
            String[] descriptions = res.getStringArray(R.array.descriptions);
            for (int i = 0; i < bands.length; i++) {
                kRestAlts.add(new Rest(i + 1, bands[i], descriptions[i]));
            }
        }

        public List<Rest> getRests() {
            return kRestAlts;
        }

        public Rest getRest(int restId) {
            for (Rest rest : kRestAlts) {
                if (rest.getId() == restId) {
                    return rest;
                }
            }
            return null;
        }
    }
