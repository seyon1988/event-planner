package com.example.testapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.db.vendor.IVendor;
import com.example.testapplication.db.vendor.Vendor_impl;
import com.example.testapplication.viewholder.VendorViewHolder;
import com.example.testapplication.R;

import java.util.ArrayList;
import java.util.List;

public class VendorAdapter extends RecyclerView.Adapter{
    private List<Vendor_impl> models = new ArrayList<Vendor_impl>();
    /**
     * ================== Adapter constructor ========================
     */
    private Context context;
    private int eid = 0;
    public VendorAdapter(Context currentAct, int eid) {
        if(currentAct == null){
            Log.d("BudgetAdapter>>","CurrentAct is null!");
        }else{
            Log.d("BudgetAdapter>>","CurrentAct is NOT null!");
        }
        this.eid = eid;
        IVendor budget = new Vendor_impl(currentAct,eid);
        List<Vendor_impl> lb = new ArrayList<Vendor_impl>();
        lb = budget.getVendor(); //error
        if (lb != null) {
            this.models.addAll(lb);
            for(Vendor_impl ib : lb){
                // Log.d("BudgetAdapter>>","models.get("+i+").id -> "+models.get(i).id);
                // Log.d("BudgetAdapter>>","List.get("+i+").id -> "+lb.get(i).id);
            }
        }
        this.context = currentAct;

    }

    /**
     * ================== onCreateViewHolder ========================
     * @param parent
     *         The ViewGroup into which the new View will be added after it is bound to
     *         an adapter position.
     * @param viewType
     *         The view type of the new View.
     *
     * @return new BudgetViewHolder(view,context);
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new VendorViewHolder(view,context,eid);
    }

    /**
     * ================== onBindViewHolder ========================
     * connects ViewHolder to Adapter
     *
     * @param holder
     *         The ViewHolder
     * @param position
     *         The position in our collection of data
     */
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ((VendorViewHolder) holder).bindData(models.get(position)); //bind each obj from model
    }

    /**
     * ===================== getItemCount ========================
     *
     * @return collection size as int
     */
    @Override
    public int getItemCount() {
        return models.size();
    }

    /**
     * ===================== getItemViewType ======================
     *
     * @param position
     *         The position in the collection
     *
     * @return The item layout id
     */
    @Override
    public int getItemViewType(final int position) {
        return R.layout.vendor_itemview;
    }

}
