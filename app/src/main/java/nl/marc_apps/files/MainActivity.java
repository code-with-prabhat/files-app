package nl.marc_apps.files;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.util.Log;
import android.content.Context;
import android.widget.Toast;
import nl.marc_apps.files.databinding.ActivityMainBinding;
import com.itsaky.androidide.logsender.LogSender;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding binding;
    
    public final Uri a = Uri.parse("content://com.android.externalstorage.documents/root/primary");

    public final boolean a(String str, ComponentName componentName) {
        Intent intent = new Intent(str, this.a);
        if (componentName != null) {
            intent.setComponent(componentName);
        }
        try {
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
            return true;
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        }
    }
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		// Remove this line if you don't want AndroidIDE to show this app's logs
		LogSender.startLogging(this);
        super.onCreate(savedInstanceState);
        // Inflate and get instance of binding
		binding = ActivityMainBinding.inflate(getLayoutInflater());
        // set content view to binding's root
        setContentView(binding.getRoot());
        
    

        
        String str = "com.android.documentsui.files.FilesActivity";
        String str2 = "android.intent.action.VIEW";
        if (!a(str2, new ComponentName("com.google.android.documentsui", str))) {
            String str3 = "com.android.documentsui";
            if (!a(str2, new ComponentName(str3, str)) && !a(str2, new ComponentName(str3, "com.android.documentsui.FilesActivity")) && !a(str2, null) && !a("android.provider.action.BROWSE", null) && !a("android.provider.action.BROWSE_DOCUMENT_ROOT", null)) {
                try {
                    startActivity(new Intent(this, ErrorActivity.class));
                    overridePendingTransition(0, 0);
                    finish();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                
    }
    }
}
}