package com.sudar.AndroidPrimerNoFrag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends ActionBarActivity {
  
  private static final String TAG = MainActivity.class.getSimpleName();
  
  private static final String DEFAULT_NAME = "Lazy Bones";
  
  private Button mButton;
  private EditText mNameEntry;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.e(TAG, "in onCreate");
//    Log.e(TAG, "This is an error-level test");
    setContentView(R.layout.activity_main);
    mButton = (Button) findViewById(R.id.button_launch_name);
    mNameEntry = (EditText) findViewById(R.id.activity_text_view);
    mButton.setOnClickListener(new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {
        String name = mNameEntry.getText().toString();
        if (name.equals("")) {
          name = DEFAULT_NAME;
        }
        // We just want to launch the other activity.
        Intent intent = new Intent(MainActivity.this, DisplayNameActivity.class);
        intent.putExtra(DisplayNameActivity.INTENT_KEY_NAME, name);
        startActivity(intent);
      }
    });
    
    // Uncomment this to show programmatic view creation.
//    addEditTextProgrammatically();

  }
  
  /**
   * Add a poorly formatted EditText to show what happens on rotation, and
   * that you lose content.
   */
  public void addEditTextProgrammatically() {
    LinearLayout linearLayout = 
        (LinearLayout) this.findViewById(R.id.activity_main_linear_layout);
    EditText editText = new EditText(this);
    // TERRIBLE to add an id like this, doing it only for the purposes of
    // making a point.
//    editText.setId(100000);
    linearLayout.addView(editText);
    
  }
  
  @Override
  protected void onStart() {
    super.onStart();
    Log.e(TAG, "in onStart");
  }
  
  @Override
  protected void onResume() {
    super.onResume();
    Log.e(TAG, "in onResume");
  }
  
  @Override
  protected void onPause() {
    super.onPause();
    Log.e(TAG, "onPause");
  };
  
  @Override
  protected void onStop() {
    super.onStop();
    Log.e(TAG, "onStop");
  }
  
  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.e(TAG, "onDestroy");
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      Log.e(TAG, "you selected settings!");
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

}
