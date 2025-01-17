package aMaz;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krystal on 5/4/17.
 * TinyURL is a URL shortening service where you enter a URL
 * such as https://leetcode.com/problems/design-tinyurl
 * and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * Design the encode and decode methods for the TinyURL service.
 * There is no restriction on how your encode/decode algorithm should aawork.
 * You just need to ensure that a URL can be encoded to
 * a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class EncodeandDecodeTinyURL {
    //https://discuss.leetcode.com/topic/81637/two-solutions-and-thoughts
    Map<String, String> index = new HashMap<String, String>();
    Map<String, String> revIndex = new HashMap<String, String>();
    static String BASE_HOST = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encodeTinyURL(String longUrl) {
        if (revIndex.containsKey(longUrl))
            return BASE_HOST + revIndex.get(longUrl);
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int r = (int) (Math.random() * charSet.length());
                sb.append(charSet.charAt(r));
            }
            key = sb.toString();
        } while (index.containsKey(key));
        index.put(key, longUrl);
        revIndex.put(longUrl, key);
        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decodeTinyURL(String shortUrl) {
        return index.get(shortUrl.replace(BASE_HOST, ""));
    }

}
