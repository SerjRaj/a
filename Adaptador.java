package com.example.exam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {

    private final String[] arreglo1, arreglo2;
    private final int[] listaimagenes;
    private final int count;
    private final LayoutInflater inflater;

    public Adaptador(Context ctx, String[] a1, String[] a2, int[] imgs) {
        this.arreglo1 = (a1 != null) ? a1 : new String[0];
        this.arreglo2 = (a2 != null) ? a2 : new String[0];
        this.listaimagenes = (imgs != null) ? imgs : new int[0];
        this.inflater = LayoutInflater.from(ctx);

        int m = this.arreglo1.length;
        if (this.arreglo2.length < m) m = this.arreglo2.length;
        if (this.listaimagenes.length < m) m = this.listaimagenes.length;
        this.count = m;
    }

    @Override public int getCount() { return count; }
    @Override public Object getItem(int position) { return (position < arreglo1.length)? arreglo1[position]: null; }
    @Override public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = (convertView != null) ? convertView : inflater.inflate(R.layout.basurita, parent, false);
        if (position >= count) return v;

        ((TextView)v.findViewById(R.id.textview)).setText(arreglo1[position]);
        ((TextView)v.findViewById(R.id.textview2)).setText(arreglo2[position]);
        ((ImageView)v.findViewById(R.id.imageicon)).setImageResource(listaimagenes[position]);
        return v;
    }
}