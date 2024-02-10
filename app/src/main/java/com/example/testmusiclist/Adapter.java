package com.example.testmusiclist;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.testmusiclist.activities.AudioActivity;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AudioViewHolder> {
    private List<AudioData> audioList;
    Context context;

    public Adapter(List<AudioData> audioList,Context context) {
        this.audioList = audioList;
        this.context=context;
    }

    @NonNull
    @Override
    public AudioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_audio_list, parent, false);
        return new AudioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AudioViewHolder holder, int position) {
        AudioData audioData = audioList.get(position);
        holder.titleTextView.setText(audioData.getTitle());
        holder.subtitleTextView.setText(audioData.getSubTitle());
        if (audioData.getImage() != null && !audioData.getImage().isEmpty()) {
            Glide.with(context)
                    .load(audioData.getImage())
                    .into(holder.imageView);
            Log.e("image", audioData.getImage());
        } else {
            Log.e("image", "Image URL is null or empty");
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AudioActivity.class);
                i.putExtra("audio",audioData.getAudioFile());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return audioList.size();
    }

    public static class AudioViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView subtitleTextView;
        ImageView imageView;
        LinearLayout linearLayout;

        public AudioViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.audioTitle);
            subtitleTextView = itemView.findViewById(R.id.audioSubtitle);
            imageView=itemView.findViewById(R.id.audioImage);
            linearLayout=itemView.findViewById(R.id.card);
        }
    }
}
