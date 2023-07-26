package io.capawesome.capacitorjs.plugins.fileopener;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;

public class FileOpener {

    private FileOpenerPlugin plugin;

    FileOpener(FileOpenerPlugin plugin) {
        this.plugin = plugin;
    }

    public void openFile(@NonNull String path) throws Exception {
      Uri data = Uri.parse(path);
      String mimeType = plugin.getBridge().getContext().getContentResolver().getType(data);
      Intent intent = new Intent(Intent.ACTION_VIEW);
      intent.setDataAndType(data, mimeType);
      intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
      Intent chooser = Intent.createChooser(intent, "Open with");
      plugin.getActivity().startActivity(chooser);
    }
}
