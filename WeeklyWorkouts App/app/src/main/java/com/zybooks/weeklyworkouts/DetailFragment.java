package com.zybooks.weeklyworkouts;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import java.io.Console;

public class DetailFragment extends Fragment {

    public static final String ARG_REST_ID = "rest_id";


    private Rest mRest;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int restId = 1; //Issue is here. Need to fix

        //System.out.println(mRest.getId());

        // Get the selected rest activity
        mRest = RestRepository.getInstance(requireContext()).getRest(getId());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        if (mRest != null) {
            TextView nameTextView = rootView.findViewById(R.id.rest_name);
            nameTextView.setText(mRest.getName());

            TextView descriptionTextView = rootView.findViewById(R.id.rest_description);
            descriptionTextView.setText(mRest.getDescription());
        }

        return rootView;
    }
}