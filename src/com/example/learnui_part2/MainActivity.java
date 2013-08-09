package com.example.learnui_part2;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	
	private Gallery gallery;
	private ImageView imageView;
	private GalleryAdapter galleryAdapter;
	
	Integer[] pics = {
				R.drawable.pic_01,
				R.drawable.pic_02,
				R.drawable.pic_03,
				R.drawable.pic_04,
				R.drawable.pic_05,
				R.drawable.pic_06,
				R.drawable.pic_07,
				R.drawable.pic_08,
				R.drawable.pic_09,
				R.drawable.pic_10
			};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        gallery = (Gallery)findViewById(R.id.Gallery01);
        imageView = (ImageView)findViewById(R.id.ImageView01);
        
        galleryAdapter = new GalleryAdapter(this);
        gallery.setAdapter(galleryAdapter);
        
//        gallery.setOnItemClickListener(new OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?> a, View v, int position, long id)
//			{
//							
//			}
//        	
//        });
        
        gallery.setOnItemSelectedListener(new OnItemSelectedListener(){  
            
            @Override  
            public void onItemSelected(AdapterView<?> a, View v, int position, long id) {  
             // TODO Auto-generated method stub  
            	Toast.makeText(getBaseContext(),"選擇第"+position+"張" ,Toast.LENGTH_SHORT).show();
				imageView.setImageResource(pics[position]);	
            }  
            
            @Override  
            public void onNothingSelected(AdapterView<?> arg0) {  
             // TODO Auto-generated method stub  
              
            }
        });
          
        
    }

    
    
    public class GalleryAdapter extends BaseAdapter {

    	private Context ctx;
    	int imageBackground;
    	
    	public GalleryAdapter(Context c) {
			ctx = c;
			// 取得TypedArray
			TypedArray ta = obtainStyledAttributes(R.styleable.Gallery1);
			// 取得TypedArray的第一個參數
			imageBackground = ta.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 1);
			// TypedArray的data指派給快取, 之後要用就會比較快?!
			ta.recycle();
		}

		@Override
    	public int getCount() {   		
    		return pics.length;
    	}

    	@Override
    	public Object getItem(int arg0) {  		
    		return arg0;
    	}
    	
    	@Override
    	public long getItemId(int arg0) {	
    		return arg0;
    	}

    	@Override
    	public View getView(int arg0, View arg1, ViewGroup arg2) {
    		ImageView iv = new ImageView(ctx);
    		iv.setImageResource(pics[arg0]);
    		iv.setScaleType(ImageView.ScaleType.FIT_XY);
    		iv.setLayoutParams(new Gallery.LayoutParams(150,120));
    		iv.setBackgroundResource(imageBackground);
    		return iv;
    	}

    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
