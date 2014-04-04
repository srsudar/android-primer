package com.sudar.AndroidPrimerNoFrag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
  
  private static final String DEFAULT_NAME = "Lazy Bones";
  
  private Button mButton;
  private EditText mNameEntry;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mButton = (Button) findViewById(R.id.button_launch_name);
    mNameEntry = (EditText) findViewById(R.id.activity_text_view);
    mButton.setOnClickListener(new View.OnClickListener() {
      
      @Override
      public void onClick(View v) {
        String name = mNameEntry.getText().toString();
        if (name == null) {
          name = DEFAULT_NAME;
        }
        // We just want to launch the other activity.
        Intent intent = new Intent(MainActivity.this, DisplayNameActivity.class);
        intent.putExtra(DisplayNameActivity.INTENT_KEY_NAME, name);
        startActivity(intent);
      }
    });

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
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

}
