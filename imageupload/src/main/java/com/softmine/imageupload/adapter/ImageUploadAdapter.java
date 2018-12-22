package com.softmine.imageupload.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.softmine.imageupload.ImageHandler;
import com.softmine.imageupload.model.ImageUpload;
import com.tokopedia.imageupload.R;

import java.io.File;
import java.util.ArrayList;


public class ImageUploadAdapter extends RecyclerView.Adapter<ImageUploadAdapter.ViewHolder> {

    private ProductImageListener listener;
    private ArrayList<ImageUpload> data;
    public Context context;

    public ImageUploadAdapter() {
        this.data = new ArrayList<>();
    }

    public static ImageUploadAdapter createAdapter() {
        return new ImageUploadAdapter();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        this.context = viewGroup.getContext();
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listview_image_upload_delete, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return data == null ? 1 : data.size() + 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private ImageView deleteButton;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_upload);
            deleteButton = itemView.findViewById(R.id.delete_but);

        }

        void bindData(final int position) {

            if (!(position == data.size())) {
                image.setOnClickListener(null);
                deleteButton.setVisibility(View.VISIBLE);
                try {
                    if (data.get(position).getFileLoc() != null) {
                        ImageHandler.loadImageFromFile(context, image, new File(data.get(position).getFileLoc()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        data.remove(position);
                        notifyDataSetChanged();
                        listener.onImageDeleted(data.size());
                    }
                });
            } else {
                deleteButton.setVisibility(View.GONE);
                image.setImageResource(R.drawable.add_image);
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.uploadImage();
                    }
                });
            }
        }
    }


    public interface ProductImageListener {

        void onImageDeleted(int size);

        void uploadImage();
    }


    public void addImage(ImageUpload image) {
        data.add(image);
        notifyDataSetChanged();
    }

    public void setListener(ProductImageListener listener) {
        this.listener = listener;
    }

    public ArrayList<ImageUpload> getList() {
        return data;
    }

}
