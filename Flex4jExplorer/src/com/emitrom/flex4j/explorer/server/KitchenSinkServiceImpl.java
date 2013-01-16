/*******************************************************************************
 * KitchenSinkServiceImpl.java is part of the Flex4j Explorer (for Flex4j 3.0)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * http://www.emitrom.com/
 * 
 ******************************************************************************/
package com.emitrom.flex4j.explorer.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.emitrom.flex4j.explorer.client.KitchenSinkService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class KitchenSinkServiceImpl extends RemoteServiceServlet implements KitchenSinkService {

    private final static String SVN_BASE_PATH = "https://raw.github.com/emitrom/Flex4jExplorer/master/Flex4jExplorer/src/com/emitrom/flex4j/explorer/client/ui/demos/";

    @Override
    public String getSource(String url) throws IllegalArgumentException {
        return sendGetRequest(SVN_BASE_PATH + url);
    }

    @Override
    public String getVersion() {
        return null;
    }

    private String sendGetRequest(String urlStr) {

        String result = null;
        try {

            URL url = new URL(urlStr);

            /**
             * String userPass = ""; byte[] bytes = null; try { bytes =
             * userPass.getBytes("ISO-8859-1"); } catch
             * (UnsupportedEncodingException e) {
             * 
             * } String header = "Basic " + Base64Utils.toBase64(bytes);
             */
            URLConnection conn = url.openConnection();
            // conn.setRequestProperty("Authorization", header);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }

            bufferedReader.close();
            result = stringBuffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

}