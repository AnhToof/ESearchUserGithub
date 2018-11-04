package com.example.toof.esearchusergithub.data.source.remote.fetchjson

import com.example.toof.esearchusergithub.data.model.User
import com.example.toof.esearchusergithub.utils.Constant
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.net.HttpURLConnection
import java.net.URL

class ParseDataWithJson {
    private val TIME_OUT = 15000
    private val METHOD_GET = "GET"

    fun getJsonFromUrl(strUrl: String): String {
        val url = URL(strUrl)
        val connection = url.openConnection() as HttpURLConnection
        connection.readTimeout = TIME_OUT
        connection.connectTimeout = TIME_OUT
        connection.requestMethod = METHOD_GET
        connection.doOutput = true
        connection.connect()
        val bufferedReader = BufferedReader(InputStreamReader(url.openStream()) as Reader?)
        val stringBuilder = StringBuilder()
        var line: String?
        do {
            line = bufferedReader.readLine()
            if (line == null) break
            stringBuilder.append(line)
        } while (true)

        bufferedReader.close()
        connection.disconnect()
        return stringBuilder.toString()
    }

    fun parseJsonToData(jsonObject: JSONObject): ArrayList<User> {
        val list = ArrayList<User>()

        val jsonArray = jsonObject.getJSONArray(Constant.USER_ENTRY_ITEM)
        if (jsonArray.length() != 0) {
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                val user = User(
                    obj.getString(Constant.USER_ENTRY_LOGIN),
                    obj.getString(Constant.USER_ENTRY_ID),
                    obj.getString(Constant.USER_ENTRY_AVATAR_URL),
                    obj.getString(Constant.USER_ENTRY_HTML_URL)
                )
                list.add(user)
            }
        }
        return list
    }
}