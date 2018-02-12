package pavel.bogrecov.example.presentation.mvp.view.adapter;

import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import pavel.bogrecov.example.R;
import pavel.bogrecov.example.data.api.UrlConfigApi;
import pavel.bogrecov.example.data.model.Profile;

import static pavel.bogrecov.example.data.api.UrlConfigApi.PHOTO_URL_IMAGE;

/**
 * Created by pavel on 21.10.2017.
 */

public class ViewHolderItem extends RecyclerView.ViewHolder {
    private ImageView imageUser;
    private TextView nameUser;
    private TextView description;
    private int requestedPhotoWidth;

    public ViewHolderItem(View itemView,int requestedPhotoWidth) {
        super(itemView);
        this.requestedPhotoWidth = requestedPhotoWidth;
        imageUser = (ImageView) itemView.findViewById(R.id.item_hero_image);
        nameUser = (TextView) itemView.findViewById(R.id.some_text);
        description = (TextView) itemView.findViewById(R.id.description);
    }


    public void bind(Profile model, ViewHolderItem holderItem) {
        int idModel = 0;
        if (model.getPhotoModel() != null) {
            idModel  = model.getPhotoModel().getId();
        }
        String imagePath = UrlConfigApi.PHOTO_URL_BASE + requestedPhotoWidth + PHOTO_URL_IMAGE + idModel;
          Glide.with(itemView.getContext()).load(imagePath).into(imageUser);
        nameUser.setText(!TextUtils.isEmpty(model.getPhotoModel().getAuthor()) ? model.getPhotoModel().getAuthor() : "");
        description.setText(model.getPhotoModel().getFilename());

        holderItem.itemView.setOnClickListener(v -> {
            Dialog dialog = new Dialog(itemView.getContext());
            dialog.setContentView(R.layout.detail_layout);
            dialog.setTitle("Name " + model.getPhotoModel().getFilename());
            dialog.setCancelable(true);
            TextView name = (TextView) dialog.findViewById(R.id.some_text);
            TextView job = (TextView) dialog.findViewById(R.id.description);
            ImageView icon = (ImageView) dialog.findViewById(R.id.item_hero_image);
            name.setText(!TextUtils.isEmpty(model.getExModel().getBody()) ? model.getExModel().getBody() : "");
            job.setText(model.getExModel().getTitle());
            Glide.with(itemView.getContext())
                    .load(UrlConfigApi.PHOTO_URL_BASE + requestedPhotoWidth + PHOTO_URL_IMAGE +
                            model.getPhotoModel().getId()).into(icon);
            dialog.show();
        });

    }

}
