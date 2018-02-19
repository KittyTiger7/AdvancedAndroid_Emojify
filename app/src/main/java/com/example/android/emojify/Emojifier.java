package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by avigagel on 19/02/2018.
 */

public class Emojifier {


    static void detectFaces(Bitmap resampledBitmap, Context context) {

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(resampledBitmap).build();

        SparseArray<Face> faces = detector.detect(frame);

        if (faces.size() == 0) {
            Toast.makeText(context, "no faces in image", Toast.LENGTH_SHORT).show();
        } else {
            Log.i("Emojifier: ", "number of faces in Bitmap is: " + faces.size());
        }

        detector.release();
    }
}
