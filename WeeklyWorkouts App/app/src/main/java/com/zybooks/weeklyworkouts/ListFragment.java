package com.zybooks.weeklyworkouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        // Click listener for the RecyclerView
        View.OnClickListener onClickListener = itemView -> {

            // Create fragment arguments containing the selected rest ID
            int selectedRestId = (int) itemView.getTag();
            Bundle args = new Bundle();
            args.putInt(DetailFragment.ARG_REST_ID, selectedRestId);
            //itemView.setTag(selectedRestId);
            //itemView.getTag(selectedRestId);
            // Replace list with details
            Navigation.findNavController(itemView).navigate(R.id.show_item_detail, args);
        };

        // Send rests to RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.rest_list);
        List<Rest> rests = RestRepository.getInstance(requireContext()).getRests();
        recyclerView.setAdapter(new RestAdapter(rests, onClickListener));


        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(divider);

        return rootView;
    }


    private class RestAdapter extends RecyclerView.Adapter<RestHolder> {

        private final List<Rest> mRests;
        private final View.OnClickListener mOnClickListener;

        public RestAdapter(List<Rest> rests, View.OnClickListener onClickListener) {
            mRests = rests;
            mOnClickListener = onClickListener;
        }

        @NonNull
        @Override
        public RestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new RestHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(RestHolder holder, int position) {
            Rest rest = mRests.get(position);
            holder.bind(rest);
            holder.itemView.setTag(rest.getId());
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mRests.size();
        }
    }

    private static class RestHolder extends RecyclerView.ViewHolder {

        private final TextView mNameTextView;

        public RestHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_rest, parent, false));
            mNameTextView = itemView.findViewById(R.id.rest_name);
        }

        public void bind(Rest rest) {
            mNameTextView.setText(rest.getName());
        }
    }
}