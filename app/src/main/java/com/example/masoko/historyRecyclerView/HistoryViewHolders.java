package com.example.masoko.historyRecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.masoko.R;

//import android.support.v7.widget.RecyclerView;
//import com.example.masoko.HistorySingleActivity;

public class HistoryViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView consultId;
    public TextView time;

    public HistoryViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

        consultId = (TextView) itemView.findViewById(R.id.consultId);
        time = (TextView) itemView.findViewById(R.id.time);
    }


    @Override
    public void onClick(View v) {
       // Intent intent = new Intent(v.getContext(), HistorySingleActivity.class);
        Bundle b = new Bundle();
        b.putString("consultId", consultId.getText().toString());
       // intent.putExtras(b);
       // v.getContext().startActivity(intent);
    }
}
