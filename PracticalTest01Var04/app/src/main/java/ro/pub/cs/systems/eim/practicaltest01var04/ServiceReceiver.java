package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

/**
 * Created by student on 30.03.2018.
 */

public class ServiceReceiver extends BroadcastReceiver {
    private TextView messageTextView;

    public ServiceReceiver() {
        this.messageTextView = null;
    }

    public ServiceReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String data = null;
        if (Constants.ACTION_STRING.equals(action)) {
            data = intent.getStringExtra(Constants.DATA);
        }
        if (Constants.ACTION_INTEGER.equals(action)) {
            data = String.valueOf(intent.getIntExtra(Constants.DATA, -1));
        }
        if (Constants.ACTION_ARRAY_LIST.equals(action)) {
            data = intent.getStringArrayListExtra(Constants.DATA).toString();
        }
        if (messageTextView != null) {
            messageTextView.setText(messageTextView.getText().toString() + "\n" + data);
        }
    }
}
