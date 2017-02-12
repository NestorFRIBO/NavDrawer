package com.example.nfb.navdrawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerAdapter.NavHolderView>{

    String titulo[];
    int icono[];
    private final int TYPE_HEADER = 0;
    private final int TYPE_ITEM = 1;

    public NavDrawerAdapter(int icono[],String titulo[]){
        this.titulo = titulo;
        this.icono = icono;

    }


    @Override
    public NavHolderView onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == TYPE_HEADER){

            View headerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_header_layout, parent,false);
            NavHolderView holderHeader = new NavHolderView(headerView, TYPE_HEADER);

            return holderHeader;
        }

        else if (viewType == TYPE_ITEM){

            View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_list_row,parent, false);
            NavHolderView itemHolder = new NavHolderView(itemView, TYPE_ITEM);

            return itemHolder;
        }


        return null;
    }

    @Override
    public void onBindViewHolder(NavHolderView holder, int position) {

        if (holder.holderType==TYPE_HEADER){
            holder.headerImg.setImageResource(R.drawable.valencia345);


        }else{
            holder.itemImg.setImageResource(icono[position-1]);
            holder.itemText.setText(titulo[position-1]);


        }

        if(position%2==0){

        }

    }

    @Override
    public int getItemCount() {
        return titulo.length+1;
    }

    @Override
    public int getItemViewType(int position){

        if(position==TYPE_HEADER){

            return TYPE_HEADER;

        }else{

            return TYPE_ITEM;
        }
    }

    public class NavHolderView extends RecyclerView.ViewHolder{

        ImageView headerImg;
        ImageView itemImg;
        TextView itemText;

        int holderType;

        public NavHolderView(View itemView, int viewType){
            super(itemView);

            if (viewType == TYPE_HEADER){
                headerImg=(ImageView) itemView.findViewById(R.id.headerImage);

                holderType = TYPE_HEADER;

            }else if(viewType == TYPE_ITEM){

                itemImg = (ImageView)itemView.findViewById(R.id.rowIcon);
                itemText = (TextView) itemView.findViewById(R.id.rowText);

                holderType = TYPE_ITEM;
            }
        }
    }
}
