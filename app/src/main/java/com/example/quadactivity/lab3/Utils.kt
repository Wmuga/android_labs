package com.example.quadactivity.lab3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class DownloadImageTask(im:ImageView) : AsyncTask<String, Int, Bitmap?>() {
    private val im: ImageView = im

    override fun doInBackground(vararg strings: String): Bitmap? {
        var url: URL? = null
        var urlConnection: HttpURLConnection? = null
        val result = StringBuilder()
        try {
            url = URL(strings[0])
            urlConnection = url.openConnection() as HttpURLConnection
            val inputStream = urlConnection.inputStream
            val bitmap = BitmapFactory.decodeStream(inputStream)
            return bitmap
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            urlConnection?.disconnect()
        }
        return null
    }

    override fun onPostExecute(result:Bitmap?){
        super.onPostExecute(result)
        if (result != null){
            im.setImageBitmap(result)
        }
    }
}
