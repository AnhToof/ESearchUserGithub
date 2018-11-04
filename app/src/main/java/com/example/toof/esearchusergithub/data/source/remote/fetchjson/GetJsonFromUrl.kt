package com.example.toof.esearchusergithub.data.source.remote.fetchjson

import android.os.AsyncTask
import com.example.toof.esearchusergithub.data.model.User
import com.example.toof.esearchusergithub.data.source.remote.OnFetchDataJsonListener
import org.json.JSONException
import org.json.JSONObject

class GetJsonFromUrl(listener: OnFetchDataJsonListener<User>) : AsyncTask<String, Void, String>() {

    private var mListener: OnFetchDataJsonListener<User> = listener

    override fun doInBackground(vararg params: String?): String {
        var data = ""
        try {
            val parseDataWithJson = ParseDataWithJson()
            data = parseDataWithJson.getJsonFromUrl(params[0]!!)
        } catch (e: Exception) {
            mListener.onError(e)
        }
        return data
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        if (result != null) {
            try {
                val jsonObject = JSONObject(result)
                mListener.onSuccess(ParseDataWithJson().parseJsonToData(jsonObject))
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
    }
}