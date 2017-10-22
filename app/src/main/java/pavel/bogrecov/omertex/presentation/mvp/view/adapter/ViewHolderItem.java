package pavel.bogrecov.omertex.presentation.mvp.view.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pavel.bogrecov.omertex.R;
import pavel.bogrecov.omertex.data.api.URLAPI;
import pavel.bogrecov.omertex.data.model.Profile;

import static pavel.bogrecov.omertex.data.api.URLAPI.PHOTO_URL_IMAGE;

/**
 * Created by pavel on 21.10.2017.
 */

public class ViewHolderItem extends RecyclerView.ViewHolder {
    private ImageView imageUser;
    private TextView nameUser;
    private TextView description;
    private View view;
    private Context activity;

    public ViewHolderItem(View itemView) {
        super(itemView);
        activity = itemView.getContext();
        this.view = itemView;
        imageUser = (ImageView) itemView.findViewById(R.id.item_hero_image);
        nameUser = (TextView) itemView.findViewById(R.id.some_text);
        description = (TextView) itemView.findViewById(R.id.description);
    }

    public ImageView getImageUser() {
        return imageUser;
    }

    public TextView getNameUser() {
        return nameUser;
    }

    public void setImageUser(ImageView imageUser) {
        this.imageUser = imageUser;
    }

    public void setNameUser(TextView nameUser) {
        this.nameUser = nameUser;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void bind(Profile model, int requestedPhotoWidth, ViewHolderItem holderItem) {
        Glide.with(view.getContext())
                .load(URLAPI.PHOTO_URL_BASE + requestedPhotoWidth + PHOTO_URL_IMAGE +
                        model.getPhotoModel().getId()).into(imageUser);
        nameUser.setText(model.getPhotoModel().getAuthor());
        description.setText(model.getPhotoModel().getFilename());

        holderItem.getView().setOnClickListener(v -> {
            Dialog dialog = new Dialog(activity);
            dialog.setContentView(R.layout.detail_layout);
            dialog.setTitle("Name " + model.getPhotoModel().getFilename());
            dialog.setCancelable(true);
            TextView name = (TextView) dialog.findViewById(R.id.some_text);
            TextView job = (TextView) dialog.findViewById(R.id.description);
            ImageView icon = (ImageView) dialog.findViewById(R.id.item_hero_image);
            name.setText(model.getExModel().getBody());
            job.setText(model.getExModel().getTitle());
            Glide.with(view.getContext())
                    .load(URLAPI.PHOTO_URL_BASE + requestedPhotoWidth + PHOTO_URL_IMAGE +
                            model.getPhotoModel().getId()).into(icon);
            dialog.show();
        });

    }

}
