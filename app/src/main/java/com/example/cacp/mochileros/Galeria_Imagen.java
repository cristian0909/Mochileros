package com.example.cacp.mochileros;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by CACP on 30-10-2015.
 */
public class Galeria_Imagen extends Activity{
//referencia imagenes tamaño real
public static int mSelected = 0 ;
private GridView gridview;
    public static Integer[] img ={
            R.drawable.templo, R.drawable.laja,
            R.drawable.tazas, R.drawable.mochileross,
            R.drawable.torresdelpaine

    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galeria_imagen);

        gridview = (GridView) findViewById(R.id.grvGaleria);

        //asignamos el adapter

        gridview.setAdapter(new ImageAdapter(this));

        //nos movemos al elemento seleccionado

        gridview.setSelection(mSelected);

    }
public boolean onCreateOptionMenu(Menu menu){
    //agrega elementos barra de accion
  //  getMenuInflater().inflate(R.menu.main, menu);
return true;
}
    public class ImageAdapter extends BaseAdapter{
        private Context mContext;
        public ImageAdapter(Context c){
            mContext = c;

        }

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position , final View convertView, ViewGroup parent) {
            ImageView imageView;

            if(convertView == null)
            {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

          if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
              imageView.setCropToPadding(true);

          }else{

              imageView.setScaleType(ImageView.ScaleType.FIT_XY);
          }
                imageView.setPadding(8,8,8,8);
            }else{
                imageView=(ImageView) convertView;

            }
            imageView.setImageResource(img[position]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Galeria_Imagen.this, ""+position, Toast.LENGTH_LONG).show();
                    mSelected = (Integer) convertView.getTag();
                    notifyDataSetChanged();

                    String index = String.valueOf(position);
                    Bundle extras = new Bundle();

                    extras.putString("position", index);
                    startActivity(new Intent(Galeria_Imagen.this, SwipeImageActivity.class)/*.putExtras(extras).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)*/);
                }
            });
            try{
                imageView.setTag(position);
                if(position == mSelected){
                    imageView.setBackgroundColor(Color.parseColor("#ff6203"));

                }else{
                    imageView.setBackgroundColor(Color.TRANSPARENT);
                }
            }catch (Exception e){

                e.printStackTrace();
            }

            return imageView;
        }
    }
}
