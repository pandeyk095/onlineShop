package com.example.clothshopapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.clothshopapp.DetailsActivity;
import com.example.clothshopapp.R;
import com.example.clothshopapp.model.Items;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {
    Context mContext;
    List<Items> itemsList;

    public ItemsAdapter(Context mContext, List<Items> itemsList){
        this.mContext=mContext;
        this.itemsList=itemsList;
    }


    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items,viewGroup,false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder itemsViewHolder, final int i) {
        final Items items=itemsList.get(i);
        itemsViewHolder.imgItem.setImageResource(Integer.parseInt(items.getItemImage()));
//        itemsViewHolder.tvItemName.setText(items.getItemName());
//        itemsViewHolder.tvItemPrice.setText(items.getItemPrice());

        itemsViewHolder.imgItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, DetailsActivity.class);
                intent.putExtra("itemname",items.getItemName());
                intent.putExtra("itemprice",items.getItemPrice());
                intent.putExtra("itemdesc",items.getItemDesc());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imgItem;
        TextView tvItemName, tvItemPrice;
        public ItemsViewHolder(View itemView){
            super(itemView);
            imgItem=itemView.findViewById(R.id.itemImage);
//            tvItemName=itemView.findViewById(R.id.tvItemName);
//            tvItemPrice=itemView.findViewById(R.id.tvItemPrice);

        }
    }
}

