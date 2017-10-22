package pavel.bogrecov.omertex.presentation.mvp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pavel.bogrecov.omertex.R;
import pavel.bogrecov.omertex.data.model.Profile;

/**
 * Created by pavel on 21.10.2017.
 */

public class AdapterRecyler extends RecyclerView.Adapter<ViewHolderItem> {
    private List<Profile> model;
    private  int requestedPhotoWidth;
    public AdapterRecyler() {

        model = new ArrayList<>();
    }

    @Override
    public ViewHolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        requestedPhotoWidth = parent.getContext().getResources().getDisplayMetrics().widthPixels;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new ViewHolderItem(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        Profile profile = model.get(position);
        holder.bind(profile,requestedPhotoWidth,holder);

    }

    public void addItem(List<Profile> model) {
        this.model = model;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
